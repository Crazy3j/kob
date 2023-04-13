package com.kob.matchingsystem.service.impl.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName MatchingPool
 * @Description TODO
 * @Author ultraman
 * @Date 2023/4/14 0:37
 * @Version 1.0
 */

@Component
public class MatchingPool extends Thread {

    private static List<Player> players = new ArrayList<>();
    final private ReentrantLock lock = new ReentrantLock();

    final private static String startGameUrl = "http://127.0.0.1:3000/pk/start/game/";
    private static RestTemplate restTemplate;

    @Resource
    public void setRestTemplate(RestTemplate restTemplate) {
        MatchingPool.restTemplate = restTemplate;
    }

    public void addPlayer(Integer userId, Integer rating) {
        lock.lock();
        try {
            players.add(new Player(userId, rating, 0));

        } finally {
            lock.unlock();
        }
    }

    public void removePlayer(Integer userId) {
        lock.lock();
        try {
            List<Player> newPlayers = new ArrayList<>();
            for (Player player : players) {
                if (!player.getUserId().equals(userId)) {
                    newPlayers.add(player);
                }
                players = newPlayers;
            }
        } finally {
            lock.unlock();
        }

    }

    private void increaseWaitingTime() {
        for (Player player :
                players) {
            player.setWaitingTime(player.getWaitingTime() + 1);
        }

    }


    private boolean checkMatcher(Player a, Player b) { // 是否能匹配
        int ratingDelta = Math.abs(a.getRating() - b.getRating());
        int waitingTime = Math.min(a.getWaitingTime(), b.getWaitingTime());
        return ratingDelta <= waitingTime * 10;
    }

    private void sendResult(Player a, Player b) { // 匹配结果
        System.out.println("send result " + a + " " + b);
        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
        data.add("a_id", a.getUserId().toString());
        data.add("b_id", b.getUserId().toString());
        restTemplate.postForObject(startGameUrl, data, String.class);
    }

    private void matchPlayers() { // 尝试匹配玩家
        System.out.println("match players: " + players.toString());
        boolean[] used = new boolean[players.size()];
        for (int i = 0; i < players.size(); i++) {
            if (used[i]) continue;
            for (int j = i + 1; j < players.size(); j++) {
                if (used[j]) continue;
                Player a = players.get(i), b = players.get(j);
                if (checkMatcher(a, b)) {
                    used[i] = used[j] = true;
                    sendResult(a, b);
                    break;
                }

            }
        }
        List<Player> newPlayer = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            if (!used[i]) {
                newPlayer.add(players.get(i));
            }
        }
        players = newPlayer;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(1000);
                lock.lock();
                try {
                    increaseWaitingTime();
                    matchPlayers();
                } finally {
                    lock.unlock();
                }


            } catch (InterruptedException e) {

            }
        }


    }
}
