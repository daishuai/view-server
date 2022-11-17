package com.daishuai.view.delayqueue.processor;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Daishuai
 * @version 1.0.0
 * @description 订单支付超时
 * @createTime 2022年11月17日 17:46:00
 */
@Slf4j
@Component
public class OrderPaymentTimeout implements RedisDelayQueueProcessor<Map<String, Object>> {

    @Override
    public void process(Map<String, Object> map) {
        log.info("订单支付超时通知: {}", JSON.toJSONString(map));
    }
}
