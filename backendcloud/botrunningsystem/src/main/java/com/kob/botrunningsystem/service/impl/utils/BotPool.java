package com.kob.botrunningsystem.service.impl.utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName BotPool
 * @Description TODO
 * @Author Ultraman
 * @Date 2023/4/18 11:45
 * @Version 1.0
 */

public class BotPool extends Thread {

    final private ReentrantLock lock = new ReentrantLock();
    final private Condition condition = lock.newCondition();
    final private Queue<Bot> bots = new LinkedList<>();


    public void addBot(Integer userId, String botCode, String input) {
        lock.lock();
        try {
            bots.add(new Bot(userId, botCode, input));
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    private void consume(Bot bot) {

        Consumer consumer = new Consumer();
        consumer.startTimeout(2000, bot);

    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (bots.isEmpty()) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    lock.unlock();
                    break;
                }
            } else {
                Bot bot = bots.remove();
                lock.unlock();
                consume(bot); // 比较消耗时间
            }
        }

    }
}
