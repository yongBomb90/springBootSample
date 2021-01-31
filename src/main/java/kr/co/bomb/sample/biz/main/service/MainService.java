package kr.co.bomb.sample.biz.main.service;

import kr.co.bomb.sample.biz.main.mapper.MainMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class MainService {

    @Resource
    MainMapper mainMapper;


    public String searchTime(Map<String, Object> param) {
        return mainMapper.selectTime( param);
    }



}
