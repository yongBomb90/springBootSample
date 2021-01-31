package kr.co.bomb.sample.common.handler;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.bomb.sample.common.exception.BombCommonException;
import kr.co.bomb.sample.common.vo.ResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.BindException;
import java.util.Map;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class BombExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(BombExceptionHandler.class);


    private String getParam(HttpServletRequest request) {
        String params = "";
        if ( request.getMethod().equals(HttpMethod.GET.name()) || request.getMethod().equals(HttpMethod.DELETE.name()) ) {
            params = request.getQueryString();
        } else {
            Map<String,String[]> paramMap = request.getParameterMap();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                params = paramMap == null ? "" : objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(paramMap);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            if ( params == "" ) {
                params = request.getQueryString();
            }
        }
        return params;
     }

    /**
     * 500 서버 에러 처리
     * @param request
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String handleException(HttpServletRequest request,Exception e) {
        StringWriter errors = new StringWriter();
        e.printStackTrace(new PrintWriter(errors));
        StringBuffer logMsg = new StringBuffer();
        logMsg.append("\n======================================================");
        logMsg.append("\nREQUEST URL    : "+request.getRequestURL());
        logMsg.append("\nREQUEST METHOD : "+(request.getMethod() == null ? "" : request.getMethod() ));
        logMsg.append("\nREQUEST TYPE   : "+request.getContentType());
        logMsg.append("\nUSER           : "+( request.getUserPrincipal() == null ? "" : request.getUserPrincipal().getName() ));
        logMsg.append("\nPARAM          : "+getParam(request));
        logMsg.append("\nBODY           : %s");
        logMsg.append("\nEXCEPTION      : \n"+errors);
        logMsg.append("\n======================================================");
        request.setAttribute("errorLog",logMsg.toString());
        return "/error/500";
    }

    /**
     * 404 에러 처리
     * @param request
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler( {NoHandlerFoundException.class })
    public String handleNotFoundException(HttpServletRequest request,Exception e) {
        return "/error/404";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler( {BombCommonException.class })
    @ResponseBody
    public ResultDTO handleJuvisMallException(HttpServletRequest request, BombCommonException e) {
        return new ResultDTO(e.getRes());
    }




    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler( { HttpMediaTypeNotSupportedException.class
                        , HttpRequestMethodNotSupportedException.class
                        , HttpMessageNotReadableException.class
                        , BindException.class
                        , MethodArgumentNotValidException.class
                        , MethodArgumentTypeMismatchException.class

    })
    public String handleBadRequestException(HttpServletRequest request,Exception e) {
        return "/error/400";
    }






}
