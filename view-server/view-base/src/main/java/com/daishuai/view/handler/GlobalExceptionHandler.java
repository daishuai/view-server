package com.daishuai.view.handler;

import com.daishuai.view.exception.ServiceException;
import com.daishuai.view.model.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author admin
 * @version 1.0.0
 * @description 全局异常处理器
 * @createTime 2022-11-07 21:38:18
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ServiceException.class)
    public ResponseMessage<String> serviceException(ServiceException serviceException) {
        log.error("业务异常: {}", serviceException.getMessage(), serviceException);
        return ResponseMessage.error(serviceException.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseMessage<String> exception(Exception exception) {
        log.error("服务异常: {}", exception.getMessage(), exception);
        return ResponseMessage.error(exception.getMessage());
    }
}
