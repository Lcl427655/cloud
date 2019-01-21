package com.cbs.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApp17001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApp17001.class,args);
    }
}
