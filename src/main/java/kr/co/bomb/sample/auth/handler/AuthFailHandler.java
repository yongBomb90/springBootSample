package kr.co.bomb.sample.auth.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.bomb.sample.common.constant.MessageConstants;
import kr.co.bomb.sample.common.vo.ResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class AuthFailHandler extends SimpleUrlAuthenticationFailureHandler {

    private static final Logger logger = LoggerFactory.getLogger(AuthFailHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ResultDTO dto = new ResultDTO(MessageConstants.ResponseEnum.LOGIN_FAIL);
        String jsonString = new ObjectMapper().writeValueAsString(dto);
        response.setHeader("Content-Type","application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(jsonString);
        response.getWriter().flush();
    }
}
