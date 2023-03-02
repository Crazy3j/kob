package com.kob.backend.controller.user.account;

import com.kob.backend.service.user.account.InfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName InfoServiceImpl
 * @Description TODO
 * @Author ultraman
 * @Date 2023/3/2 20:06
 * @Version 1.0
 */

@RestController
public class InfoServiceController {
    @Resource
    private InfoService infoService;

    @GetMapping("/user/account/info/")
    public Map<String, String> getInfo() {
        return infoService.getInfo();

    }

}
