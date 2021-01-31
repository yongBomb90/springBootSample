package kr.co.bomb.sample.biz.main.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface MainMapper {


    String selectTime(Map<String, Object> param);


}
