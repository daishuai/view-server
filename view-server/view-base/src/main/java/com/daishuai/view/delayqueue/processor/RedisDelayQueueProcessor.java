package com.daishuai.view.delayqueue.processor;

import com.daishuai.view.delayqueue.enums.RedisDelayQueueEnums;

/**
 * @author Daishuai
 * @version 1.0.0
 * @description Redis延迟队列消息处理器
 * @createTime 2022年11月17日 17:45:00
 */
public interface RedisDelayQueueProcessor {

    RedisDelayQueueEnums queue();

    void process(Object t);
}
