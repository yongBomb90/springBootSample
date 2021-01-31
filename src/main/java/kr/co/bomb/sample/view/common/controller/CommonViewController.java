package kr.co.bomb.sample.view.common.controller;

import kr.co.bomb.sample.auth.vo.AuthUserVO;
import kr.co.bomb.sample.biz.main.controller.MainController;
import kr.co.bomb.sample.biz.main.service.MainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
public class CommonViewController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    MainService mainService;

    @RequestMapping(value = "/index")
    public String indexView(ModelMap modelMap)  throws Exception {
        logger.info("===========================================================");
        modelMap.addAttribute("time",mainService.searchTime(null));
        logger.info(modelMap.toString());
        logger.info("===========================================================");
        return "index";
    }

    @RequestMapping(value = "/{dir}/{file}.view")
    public String productChartView(@PathVariable("dir") String dir ,@PathVariable("file") String file ) throws Exception {
        return "/"+dir+"/"+file;
    }

}
