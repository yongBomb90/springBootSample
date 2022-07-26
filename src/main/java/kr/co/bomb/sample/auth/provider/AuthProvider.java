package kr.co.bomb.sample.auth.provider;

import kr.co.bomb.sample.auth.service.BombUserDetailService;

import kr.co.bomb.sample.auth.vo.AuthUserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
//성공시 로직처리
@Component("authProvider")
public class AuthProvider implements AuthenticationProvider {

    private static final Logger logger = LoggerFactory.getLogger(AuthProvider.class);

    @Autowired
    BombUserDetailService userDetailService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String id = authentication.getName();
        String password = authentication.getCredentials().toString();
        if ( id == null || password == null ) {
            throw new UsernameNotFoundException("params is null ");
        }
        AuthUserVO loginVo = (AuthUserVO) userDetailService.loadUserByUsernamePassword(id,password);
        return  new RememberMeAuthenticationToken(id,loginVo,loginVo.getAuthorities());
    }



    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
