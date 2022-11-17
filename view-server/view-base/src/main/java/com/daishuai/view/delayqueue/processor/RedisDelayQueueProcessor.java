package com.daishuai.view.delayqueue.processor;

/**
 * @author Daishuai
 * @version 1.0.0
 * @description Redis延迟队列消息处理器
 * @createTime 2022年11月17日 17:45:00
 */
public interface RedisDelayQueueProcessor {

    String queueCode();

    void process(Object t);
}
