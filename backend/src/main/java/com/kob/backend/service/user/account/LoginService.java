package com.kob.backend.service.user.account;

import java.util.Map;

/**
 * @ClassName LoginService
 * @Description TODO
 * @Author ultraman
 * @Date 2023/3/2 19:35
 * @Version 1.0
 */

public interface LoginService {

    Map<String, String> getToken(String username, String password);
}
