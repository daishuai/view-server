package com.daishuai.view.delayqueue.enums;

/**
 * @author admin
 * @version 1.0.0
 * @description Redis延迟队列
 * @createTime 2022-11-17 21:32:59
 */
public enum RedisDelayQueueEnums {

    ORDER_PAYMENT_TIMEOUT("OrderPaymentTimeout");

    private final String queueCode;

    RedisDelayQueueEnums(String queueCode) {
        this.queueCode = queueCode;
    }

    public String queueCode() {
        return this.queueCode;
    }
}
