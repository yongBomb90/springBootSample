package kr.co.bomb.sample.auth.service;

import kr.co.bomb.sample.auth.vo.AuthUserVO;
import kr.co.bomb.sample.biz.login.mapper.LoginMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;

@Component
public class BombUserDetailService implements UserDetailsService {

    @Resource
    LoginMapper loginMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUserVO authUserVO = new AuthUserVO();
        authUserVO.setMemId(username);
        authUserVO =  loginMapper.selectAuthUser(authUserVO);
        if ( authUserVO == null ) {
            throw new UsernameNotFoundException("username : "+username);
        }
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        authUserVO.setAuthorities(authorities);
        return authUserVO;
    }

    public UserDetails loadUserByUsernamePassword(String username,String userPw) throws UsernameNotFoundException {
        AuthUserVO authUserVO = new AuthUserVO();
        authUserVO.setMemId(username);
        authUserVO.setMemPw(userPw);
        authUserVO =  loginMapper.selectAuthUser(authUserVO);
        if ( authUserVO == null ) {
            throw new UsernameNotFoundException("username : "+username);
        }
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        authUserVO.setAuthorities(authorities);
        return authUserVO;
    }
}
