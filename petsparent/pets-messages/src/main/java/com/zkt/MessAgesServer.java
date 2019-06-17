
package com.zkt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MessAgesServer {
	public static void main(String[] args) {
       SpringApplication.run(MessAgesServer.class, args);
	}
}
