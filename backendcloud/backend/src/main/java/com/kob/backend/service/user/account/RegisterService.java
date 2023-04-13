package com.kob.backend.service.user.account;

import java.util.Map;

/**
 * @ClassName RegisterService
 * @Description TODO
 * @Author ultraman
 * @Date 2023/3/2 19:36
 * @Version 1.0
 */

public interface RegisterService {

    Map<String, String> register(String username, String password, String confirmedPassword);
}
