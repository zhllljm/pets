package com.zkt;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableEurekaClient
@Import(FdfsClientConfig.class)
public class AppCartServer {
    public static void main(String[] args) {
        SpringApplication.run(AppCartServer.class, args);
    }
}
