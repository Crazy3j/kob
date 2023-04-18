package com.kob.botrunningsystem.service.impl.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Bot
 * @Description TODO
 * @Author Ultraman
 * @Date 2023/4/18 11:50
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bot {

    Integer userId;
    String botCode;
    String input;

}
