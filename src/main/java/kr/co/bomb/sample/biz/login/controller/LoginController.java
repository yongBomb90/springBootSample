package kr.co.bomb.sample.biz.login.controller;


import kr.co.bomb.sample.biz.main.controller.MainController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login/view")
    public String loginView(ModelMap modelMap, Map<String,Object> param) throws Exception {
        logger.info("access loginView");
        return "/login/login";
    }

    @RequestMapping(value = "/popup/test")
    public String popupTest(ModelMap modelMap, Map<String,Object> param) throws Exception {
        logger.info("access loginView");
        return "/popup/test";
    }







}
