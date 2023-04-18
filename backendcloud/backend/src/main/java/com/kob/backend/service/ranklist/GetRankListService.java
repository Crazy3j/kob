package com.kob.backend.service.ranklist;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName GetRankListService
 * @Description TODO
 * @Author ultraman
 * @Date 2023/4/18 21:12
 * @Version 1.0
 */
public interface GetRankListService {
    JSONObject getList(Integer page);

}
