package com.daishuai.view.model;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.*;

/**
 * @author admin
 * @version 1.0.0
 * @description 响应结果
 * @createTime 2022-11-07 21:21:00
 */
@Data
public class ResponseMessage<T> {

    private static final String SUCCESS = "0";

    private static final String ERROR = "-1";

    @ApiModelProperty("错误消息")
    protected String message;
    @ApiModelProperty("成功时响应内容")
    protected T result;
    @ApiModelProperty(value = "状态码", required = true)
    protected int status;
    @ApiModelProperty("业务自定义状态码")
    protected String code;
    @ApiModelProperty(value = "时间戳", required = true, dataType = "Long")
    protected Long timestamp;

    public ResponseMessage() {
    }

    public static <T> ResponseMessage<T> error(String message) {
        return error(500, ERROR, message);
    }

    public static <T> ResponseMessage<T> error(String message, Object... args) {
        return error(500, message, args);
    }

    public static <T> ResponseMessage<T> error(int status, String message) {
        return error(status, ERROR, message);
    }

    public static <T> ResponseMessage<T> error(int status, String message, Object... args) {
        return error(status, ERROR, message, args);
    }

    public static <T> ResponseMessage<T> error(int status, String code, String message) {
        return error(status, code, message, (Object[]) null);
    }

    public static <T> ResponseMessage<T> error(int status, String code, String message, Object... args) {
        ResponseMessage<T> msg = new ResponseMessage<>();
        msg.message = String.format(message, args);
        msg.status(status);
        msg.code(code);
        return msg.putTimeStamp();
    }

    public static <T> ResponseMessage<T> ok() {
        return ok(null);
    }

    public static <T> ResponseMessage<T> ok(T result) {
        ResponseMessage<T> responseMessage = new ResponseMessage<>();
        responseMessage.result(result).putTimeStamp().code(SUCCESS).status(200);
        return responseMessage;
    }

    private ResponseMessage<T> putTimeStamp() {
        this.timestamp = System.currentTimeMillis();
        return this;
    }

    public ResponseMessage<T> result(T result) {
        this.result = result;
        return this;
    }


    public String toString() {
        return JSON.toJSONStringWithDateFormat(this, "yyyy-MM-dd HH:mm:ss");
    }

    public void status(int status) {
        this.status = status;
    }

    public ResponseMessage<T> code(String code) {
        this.code = code;
        return this;
    }

}
