package com.kob.backend.service.impl.user.bot;

import com.kob.backend.mapper.BotMapper;
import com.kob.backend.pojo.Bot;
import com.kob.backend.pojo.User;
import com.kob.backend.service.impl.utils.UserUtilImpl;
import com.kob.backend.service.user.bot.RemoveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName RemoveServiceImpl
 * @Description TODO
 * @Author Ultraman
 * @Date 2023/3/5 23:44
 * @Version 1.0
 */

@Service
public class RemoveServiceImpl implements RemoveService {

    @Resource
    private BotMapper botMapper;

    @Override
    public Map<String, String> remove(Map<String, String> data) {

        User user = UserUtilImpl.getUser();

        int bot_id = Integer.parseInt(data.get("bot_id"));
        Bot bot = botMapper.selectById(bot_id);

        Map<String, String> map = new HashMap<>();

        if (bot == null) {
            map.put("error_message", "Bot不存在");
            return map;
        }

        if (!bot.getUserId().equals(user.getId())) {
            map.put("error_message", "没有权限删除该Bot");
            return map;
        }

        botMapper.deleteById(bot_id);

        map.put("error_message", "success");
        return map;
    }
}
