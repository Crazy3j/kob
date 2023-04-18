package com.kob.backend.service.record;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName GetRecordListService
 * @Description TODO
 * @Author ultraman
 * @Date 2023/4/18 19:07
 * @Version 1.0
 */

public interface GetRecordListService {

    JSONObject getList(Integer page);

}
