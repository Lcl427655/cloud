package com.cbs.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
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

    /*@Bean
    public IRule getIRule(){
        //覆盖原有的轮询算法
        return new RandomRule();
    }*/
}