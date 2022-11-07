package com.daishuai.view;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @version 1.0.0
 * @description 启动类
 * @createTime 2022-11-06 21:44:32
 */
@MapperScan(basePackages = {"com.daishuai.view.mapper"})
@SpringBootApplication
public class ViewApplication {

    public static void main(String[] args) {
        SpringApplication.run(ViewApplication.class, args);
    }

}
