package kr.co.bomb.sample.auth.repo;

import kr.co.bomb.sample.auth.vo.AuthTokenVO;
import kr.co.bomb.sample.biz.login.mapper.LoginMapper;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

@Component
public class BombTokenRepository implements PersistentTokenRepository {

    @Resource
    LoginMapper loginMapper;

    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        AuthTokenVO authToken = new AuthTokenVO(token);
        loginMapper.insertLoginToken(authToken);
    }

    @Override
    public void updateToken(String series, String tokenValue, Date lastUsed) {
        AuthTokenVO authToken = new AuthTokenVO(null, series, tokenValue, lastUsed);
        loginMapper.updateLoginToken(authToken);
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        AuthTokenVO authToken = loginMapper.selectAuthToken(seriesId);
        if ( authToken == null ) {
            return null;
        }
        return new PersistentRememberMeToken(authToken.getMemId(),seriesId,authToken.getMemToken(),authToken.getLastDate());
    }

    @Override
    public void removeUserTokens(String username) {
        loginMapper.deleteLoginToken(username);
    }
}
