package com.tri.watchservice_se173191;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WatchServiceSe173191Application {

    public static void main(String[] args) {
        SpringApplication.run(WatchServiceSe173191Application.class, args);
    }

}
