package com.kob.backend.controller.record;

import com.alibaba.fastjson.JSONObject;
import com.kob.backend.service.record.GetRecordListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName GetRecordListController
 * @Description TODO
 * @Author ultraman
 * @Date 2023/4/18 19:10
 * @Version 1.0
 */

@RestController
public class GetRecordListController {

    @Resource
    private GetRecordListService getRecordListService;

    @GetMapping("/record/getlist/")
    JSONObject getList(@RequestParam Map<String, String> data) {
        Integer page = Integer.parseInt(data.get("page"));
        return getRecordListService.getList(page);
    }
}
