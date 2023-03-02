package com.kob.backend.controller.user.account;

import com.kob.backend.service.user.account.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author ultraman
 * @Date 2023/3/2 19:49
 * @Version 1.0
 */

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/user/account/token/")
    public Map<String, String> getToken(@RequestParam Map<String, String> map) {

        String username = map.get("username");
        String password = map.get("password");
        return loginService.getToken(username, password);


    }
}
