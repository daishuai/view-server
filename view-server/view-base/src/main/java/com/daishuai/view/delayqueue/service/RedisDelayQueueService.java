package com.daishuai.view.delayqueue.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RBlockingQueue;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author Daishuai
 * @version 1.0.0
 * @description 分布式延迟队列工具
 * @createTime 2022年11月17日 17:19:00
 */
@Slf4j
@Service
@ConditionalOnBean(RedissonClient.class)
public class RedisDelayQueueService {

    @Resource
    private RedissonClient redissonClient;

    public <T> boolean addDelayQueue(T value, long delay, TimeUnit timeUnit, String queueCode) {
        if (StringUtils.isBlank(queueCode) || Objects.isNull(value)) {
            return false;
        }
        RBlockingQueue<Object> blockingQueue = redissonClient.getBlockingQueue(queueCode);
        RDelayedQueue<Object> delayedQueue = redissonClient.getDelayedQueue(blockingQueue);
        delayedQueue.offer(value, delay, timeUnit);
        return true;
    }

    public <T> T getDelayQueue(String queueCode) {
        if (StringUtils.isBlank(queueCode)) {
            return null;
        }
        RBlockingQueue<Object> blockingQueue = redissonClient.getBlockingQueue(queueCode);
        T value = (T) blockingQueue.poll();
        return value;
    }

    public boolean removeDelayQueue(Object obj, String queueCode) {
        if (StringUtils.isBlank(queueCode) || Objects.isNull(obj)) {
            return false;
        }
        RBlockingQueue<Object> blockingQueue = redissonClient.getBlockingQueue(queueCode);
        RDelayedQueue<Object> delayedQueue = redissonClient.getDelayedQueue(blockingQueue);
        return delayedQueue.remove(obj);
    }
}
