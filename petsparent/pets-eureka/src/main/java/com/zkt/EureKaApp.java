package com.zkt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EureKaApp {
    public static void main(String[] args) {
        SpringApplication.run(EureKaApp.class, args);
    }
}
