package com.kob.backend.controller.pk;

import com.kob.backend.service.pk.StartGameService;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @ClassName StartGameController
 * @Description TODO
 * @Author ultraman
 * @Date 2023/4/14 1:12
 * @Version 1.0
 */

@RestController
public class StartGameController {

    @Resource
    private StartGameService startGameService;

    @PostMapping("/pk/start/game/")
    public String startGame(@RequestParam MultiValueMap<String, String> data){
        Integer aId = Integer.parseInt((Objects.requireNonNull(data.getFirst("a_id"))));
        Integer bId = Integer.parseInt((Objects.requireNonNull(data.getFirst("b_id"))));

        return startGameService.startGame(aId,bId);

    }

}
