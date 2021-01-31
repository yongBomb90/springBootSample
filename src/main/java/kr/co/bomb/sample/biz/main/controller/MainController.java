package kr.co.bomb.sample.biz.main.controller;


import kr.co.bomb.sample.biz.main.service.MainService;
import kr.co.bomb.sample.common.constant.MessageConstants;
import kr.co.bomb.sample.common.exception.BombCommonException;
import kr.co.bomb.sample.common.vo.ResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/main")
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    MainService mainService;

    @RequestMapping(value = "/sample"  , method = RequestMethod.GET )
    public ResultDTO sampleViewGet(HttpServletRequest request) throws Exception {
        logger.info("===========================================================");
        HashMap<String,Object> data = new HashMap<>();
        data.put("sample","GET");
        logger.info("===========================================================");
        return new ResultDTO(data);
    }

    @RequestMapping(value = "/sample"  , method = RequestMethod.POST ,  consumes = "application/json" )
    public ResultDTO sampleViewPost(HttpServletRequest request) throws Exception {
        logger.info("===========================================================");
        HashMap<String,Object> data = new HashMap<>();
        data.put("sample","POST");
        logger.info("===========================================================");
        return new ResultDTO(data);
    }

    @RequestMapping(value = "/sampleExcept"  , method = RequestMethod.GET )
    public ResultDTO sampleExceptViewGet(HttpServletRequest request) throws Exception {
        logger.info("===========================================================");
        if ( 1 == 1 ) {
            throw  new BombCommonException(MessageConstants.ResponseEnum.BAD_REQUEST);
        }
        logger.info("===========================================================");
        return new ResultDTO(null);
    }



}
