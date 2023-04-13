package com.kob.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kob.backend.pojo.Record;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName RecordMapper
 * @Description TODO
 * @Author ultraman
 * @Date 2023/3/14 0:31
 * @Version 1.0
 */

@Mapper
public interface RecordMapper extends BaseMapper<Record> {
}
