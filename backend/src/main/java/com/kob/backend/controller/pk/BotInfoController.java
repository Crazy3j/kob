package com.kob.backend.controller.pk;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName BotinfoController
 * @Description TODO
 * @Author ultraman
 * @Date 2023/1/30 1:40
 * @Version 1.0
 */

@RestController()
@RequestMapping("/pk/")
public class BotInfoController {

    @RequestMapping("getbotinfo/")
    public List<String> getBotInfo(){
        List<String> list = new LinkedList<>();
        list.add("sword");
        list.add("tiger");
        list.add("apple");

        return list;
    }
}
