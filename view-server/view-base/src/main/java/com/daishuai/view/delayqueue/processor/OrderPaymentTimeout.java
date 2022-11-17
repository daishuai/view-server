package com.daishuai.view.delayqueue.processor;

import com.alibaba.fastjson.JSON;
import com.daishuai.view.delayqueue.enums.RedisDelayQueueEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Daishuai
 * @version 1.0.0
 * @description 订单支付超时
 * @createTime 2022年11月17日 17:46:00
 */
@Slf4j
@Component
public class OrderPaymentTimeout implements RedisDelayQueueProcessor {

    @Override
    public RedisDelayQueueEnums queue() {
        return RedisDelayQueueEnums.ORDER_PAYMENT_TIMEOUT;
    }

    @Override
    public void process(Object map) {
        log.info("订单支付超时通知: {}", JSON.toJSONString(map));
    }
}
