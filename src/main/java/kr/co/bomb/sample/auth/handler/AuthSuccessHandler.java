package kr.co.bomb.sample.auth.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.bomb.sample.common.constant.MessageConstants;
import kr.co.bomb.sample.common.vo.ResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(AuthSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_OK);
        ResultDTO dto = new ResultDTO(MessageConstants.ResponseEnum.SUCCESS);
        String jsonString = new ObjectMapper().writeValueAsString(dto);
        response.setHeader("Content-Type","application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(jsonString);
        response.getWriter().flush();
    }
}
