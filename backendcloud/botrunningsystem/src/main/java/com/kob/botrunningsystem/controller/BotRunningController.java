package com.kob.botrunningsystem.controller;

import com.kob.botrunningsystem.service.BotRunningService;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @ClassName BotRunningController
 * @Description TODO
 * @Author ultraman
 * @Date 2023/4/17 2:22
 * @Version 1.0
 */

@RestController
public class BotRunningController {

    @Resource
    private BotRunningService botRunningService;

    @PostMapping("/bot/add/")
    public String  addBot(@RequestParam MultiValueMap<String, String> data){

        Integer userId = Integer.parseInt(Objects.requireNonNull(data.getFirst("user_id")));
        String botCode = data.getFirst("bot_code");
        String input = data.getFirst("input");

        return botRunningService.addBot(userId,botCode,input);
    }
}
