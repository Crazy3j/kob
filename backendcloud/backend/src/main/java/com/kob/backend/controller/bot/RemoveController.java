package com.kob.backend.controller.bot;

import com.kob.backend.service.user.bot.RemoveService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName RemoveController
 * @Description TODO
 * @Author Ultraman
 * @Date 2023/3/6 0:06
 * @Version 1.0
 */

@RestController
public class RemoveController {

    @Resource
    private RemoveService removeService;

    @PostMapping("/user/bot/remove/")
    public Map<String, String> remove(@RequestParam Map<String, String> data) {
        return removeService.remove(data);
    }
}
