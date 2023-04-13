package com.kob.matchingsystem;

import com.kob.matchingsystem.service.impl.MatchingServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName ${NAME}
 * @Description TODO
 * @Author ${USER}
 * @Date ${DATE} ${TIME}
 * @Version 1.0
 */

@SpringBootApplication
public class MatchingSystemApplication {
    public static void main(String[] args) {
        MatchingServiceImpl.matchingPool.start(); // 启动匹配线程
        SpringApplication.run(MatchingSystemApplication.class, args);

    }
}