package kr.co.bomb.sample.auth.vo;

import org.apache.ibatis.type.Alias;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;

import java.util.Date;

@Alias("authTokenVO")
public class AuthTokenVO extends PersistentRememberMeToken {

    private String memId;
    private String memSeries;
    private String memToken;
    private Date lastDate;


    public AuthTokenVO() {
        super(null, null, null, null);
    }

    public AuthTokenVO(String username, String series, String tokenValue, Date date) {
        super(username, series, tokenValue, date);
        this.memId = username;
        this.memSeries = series;
        this.memToken = tokenValue;
        this.lastDate = date;
    }
    public AuthTokenVO(PersistentRememberMeToken token) {
        super(token.getUsername(), token.getSeries(), token.getTokenValue(), token.getDate());
        this.memId = token.getUsername();
        this.memSeries = token.getSeries();
        this.memToken = getTokenValue();
        this.lastDate = token.getDate();
    }


    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getMemSeries() {
        return memSeries;
    }

    public void setMemSeries(String memSeries) {
        this.memSeries = memSeries;
    }

    public String getMemToken() {
        return memToken;
    }

    public void setMemToken(String memToken) {
        this.memToken = memToken;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }
}
