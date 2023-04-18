package com.kob.backend.service.impl.bot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kob.backend.mapper.BotMapper;
import com.kob.backend.pojo.Bot;
import com.kob.backend.pojo.User;
import com.kob.backend.service.impl.utils.UserUtilImpl;
import com.kob.backend.service.user.bot.GetListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName GetListServiceImpl
 * @Description TODO
 * @Author Ultraman
 * @Date 2023/3/6 0:46
 * @Version 1.0
 */

@Service
public class GetListServiceImpl implements GetListService {

    @Resource
    private BotMapper botMapper;
    @Override
    public List<Bot> getList() {

        User user = UserUtilImpl.getUser();
        QueryWrapper<Bot> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",user.getId());

        return botMapper.selectList(queryWrapper);
    }
}
