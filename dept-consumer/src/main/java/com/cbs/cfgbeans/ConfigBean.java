package com.cbs.cfgbeans;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootConfiguration
public class ConfigBean {

    @Bean
    @LoadBalanced//ribbon客户端负载均衡工具
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}