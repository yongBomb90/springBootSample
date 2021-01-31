package kr.co.bomb.sample.auth.vo;

import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.*;

@Alias("authUserVO")
public class AuthUserVO implements  Serializable, UserDetails {

    private String memIdx;                              //사용자 번호
    private String memId;                               //사용자 아이디
    private String memPw;                               //사용자 비밀번호
    private String memName;                             //사용자 이름
    private String memSms;                              //사용자 번호
    private String memSmsYn;                            //사용자 메신저 수신여부
    private String memEmail;                            //사용자 이메일
    private String memEmailYn;                          //사용자 수신여부
    private String memZipCode;                          //사용자 우편번호
    private String memAddr1;                            //자택주소1
    private String memAddr2;                            //자택주소2
    private String memSex;                              //사용자성별


    private Collection<? extends GrantedAuthority> authorities;// 권한

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return memPw;
    }

    @Override
    public String getUsername() {
        return memId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public AuthUserVO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super();
        this.memId = username;
        this.memPw = password;
        this.authorities = authorities;
    }

    public AuthUserVO() {
        super();
    }

    public String getMemIdx() {
        return memIdx;
    }

    public void setMemIdx(String memIdx) {
        this.memIdx = memIdx;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getMemPw() {
        return memPw;
    }

    public void setMemPw(String memPw) {
        this.memPw = memPw;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getMemSms() {
        return memSms;
    }

    public void setMemSms(String memSms) {
        this.memSms = memSms;
    }

    public String getMemSmsYn() {
        return memSmsYn;
    }

    public void setMemSmsYn(String memSmsYn) {
        this.memSmsYn = memSmsYn;
    }

    public String getMemEmail() {
        return memEmail;
    }

    public void setMemEmail(String memEmail) {
        this.memEmail = memEmail;
    }

    public String getMemEmailYn() {
        return memEmailYn;
    }

    public void setMemEmailYn(String memEmailYn) {
        this.memEmailYn = memEmailYn;
    }

    public String getMemZipCode() {
        return memZipCode;
    }

    public void setMemZipCode(String memZipCode) {
        this.memZipCode = memZipCode;
    }

    public String getMemAddr1() {
        return memAddr1;
    }

    public void setMemAddr1(String memAddr1) {
        this.memAddr1 = memAddr1;
    }

    public String getMemAddr2() {
        return memAddr2;
    }

    public void setMemAddr2(String memAddr2) {
        this.memAddr2 = memAddr2;
    }

    public String getMemSex() {
        return memSex;
    }

    public void setMemSex(String memSex) {
        this.memSex = memSex;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
