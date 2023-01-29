package com.kob.backend.controller.pk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ultraman
 * @date 2023/1/30 1:04
 */

@Controller()
@RequestMapping("/pk/")
public class IndexController {

    @RequestMapping("index/")
    public String index(){
        return "pk/index";
    }
}
