package kr.co.bomb.sample.biz.login.mapper;

import kr.co.bomb.sample.auth.vo.AuthTokenVO;
import kr.co.bomb.sample.auth.vo.AuthUserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface LoginMapper {

    int insertLoginToken(AuthTokenVO param);

    int updateLoginToken(AuthTokenVO param);

    int deleteLoginToken(String memId);

    AuthTokenVO selectAuthToken(String seriesId);

    AuthUserVO selectAuthUser(AuthUserVO authUserVO);


}
