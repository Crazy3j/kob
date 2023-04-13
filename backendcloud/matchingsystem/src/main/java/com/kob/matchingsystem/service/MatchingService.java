package com.kob.matchingsystem.service;

/**
 * @ClassName MatchingService
 * @Description TODO
 * @Author ultraman
 * @Date 2023/3/31 21:45
 * @Version 1.0
 */
public interface MatchingService {
    String addPlayer(Integer userId, Integer rating);
    String removePlayer(Integer userId);
}
