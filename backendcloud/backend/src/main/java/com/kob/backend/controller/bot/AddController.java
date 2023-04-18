package com.kob.backend.controller.bot;

import com.kob.backend.service.user.bot.AddService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName AddController
 * @Description TODO
 * @Author ultraman
 * @Date 2023/3/5 1:07
 * @Version 1.0
 */

@RestController
public class AddController {
    @Resource
    private AddService addService;

    @PostMapping("/user/bot/add/")
    public Map<String, String> add(@RequestParam Map<String, String> data) {
        return addService.add(data);
    }
}
