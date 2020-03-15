package com.example.caricature;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.example.caricature.mapper")
@EnableScheduling    //启动定时任务
public class CaricatureApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaricatureApplication.class, args);
    }

}
