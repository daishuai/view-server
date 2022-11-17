package com.daishuai.view.delayqueue;

import com.daishuai.view.delayqueue.processor.RedisDelayQueueProcessor;
import com.daishuai.view.delayqueue.service.RedisDelayQueueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Daishuai
 * @version 1.0.0
 * @description 启动延迟队列检测扫描
 * @createTime 2022年11月17日 17:48:00
 */
@Slf4j
@Component
public class RedisDelayQueueRunner implements CommandLineRunner {

    @Resource
    private RedisDelayQueueService redisDelayQueueService;

    @Autowired(required = false)
    private List<RedisDelayQueueProcessor<?>> redisDelayQueueProcessors;

    @Override
    public void run(String... args) throws Exception {

    }
}
