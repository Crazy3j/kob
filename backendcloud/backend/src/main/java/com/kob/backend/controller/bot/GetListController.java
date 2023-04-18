package com.kob.backend.controller.bot;

import com.kob.backend.pojo.Bot;

import com.kob.backend.service.user.bot.GetListService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName GetListController
 * @Description TODO
 * @Author Ultraman
 * @Date 2023/3/6 0:51
 * @Version 1.0
 */

@RestController
public class GetListController {

    @Resource
    private GetListService getListService;

    @GetMapping("/user/bot/getlist")
    public List<Bot> getList() {
        return getListService.getList();
    }
}
