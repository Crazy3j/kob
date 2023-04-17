package com.kob.botrunningsystem.service;

/**
 * @ClassName BotRunningService
 * @Description TODO
 * @Author ultraman
 * @Date 2023/4/17 2:19
 * @Version 1.0
 */
public interface BotRunningService {
    String addBot(Integer userId, String botCode, String input);
}
