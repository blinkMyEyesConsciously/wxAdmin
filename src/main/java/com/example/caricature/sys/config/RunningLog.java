package com.example.caricature.sys.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RunningLog implements CommandLineRunner{
    @Value("${server.port}")
    private int port;
    @Override
    public void run(String... var1) throws Exception{
        log.info("---------------- 执行 打印文档地址 ----------------------");
        System.out.println("API文档的地址: http://localhost:"+port+"/swagger-ui.html#/");

    }
}