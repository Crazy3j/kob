package com.kob.matchingsystem.service.impl.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Player
 * @Description TODO
 * @Author ultraman
 * @Date 2023/4/14 0:37
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    private Integer userId;
    private Integer rating;
    private Integer botId;
    private Integer waitingTime; // 等待时间

}
