package com.kob.matchingsystem.service.impl;

import com.kob.matchingsystem.service.MatchingService;
import com.kob.matchingsystem.service.impl.utils.MatchingPool;
import org.springframework.stereotype.Service;

/**
 * @ClassName MatchingServiceImpl
 * @Description TODO
 * @Author ultraman
 * @Date 2023/3/31 21:44
 * @Version 1.0
 */

@Service
public class MatchingServiceImpl implements MatchingService {

    final public static MatchingPool matchingPool = new MatchingPool();
    @Override
    public String addPlayer(Integer userId, Integer rating, Integer botId) {
        System.out.println("add player: " + userId + " " + rating);
        matchingPool.addPlayer(userId,rating,botId);
        return "add player success!";
    }

    @Override
    public String removePlayer(Integer userId) {
        System.out.println("remove player:" + userId);
        matchingPool.removePlayer(userId);
        return "remove player success!";
    }
}
