package com.kob.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kob.backend.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author ultraman
 * @Date 2023/2/25 23:41
 * @Version 1.0
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
