package com.springcloud.consumer.config;

import feign.Feign;
import org.springframework.context.annotation.Configuration;

/**
 * @author simonliang
 * @className FeignDisableHystrixConfiguration
 * @description
 * @date 2020/9/29 4:09 下午
 */
@Configuration
public class FeignDisableHystrixConfiguration {
    public Feign.Builder feignBuilder(){
        return Feign.builder();
    }
}
