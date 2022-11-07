package com.daishuai.view.exception;

/**
 * @author admin
 * @version 1.0.0
 * @description 服务异常
 * @createTime 2022-11-07 21:34:04
 */
public class ServiceException extends RuntimeException {

    private final Integer status;
    private final String message;
    private final String code;

    public ServiceException(String message) {
        super(message);
        this.message = message;
        this.status = 500;
        this.code = "500";
    }

    public ServiceException(Integer status, String message) {
        super(message);
        this.status = status;
        this.message = message;
        this.code = String.valueOf(status);
    }

    private ServiceException() {
        this.status = null;
        this.message = null;
        this.code = null;
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return this.code;
    }

}
