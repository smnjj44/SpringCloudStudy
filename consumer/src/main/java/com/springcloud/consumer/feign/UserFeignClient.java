package com.springcloud.consumer.feign;

import com.springcloud.consumer.vo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author simonliang
 * @className UserFeignClient
 * @description
 * @date 2020/9/28 6:00 下午
 */
//自带ribbon的负载均衡功能，通过provider-user到注册中心找到对应ip，直接http请求拼接上requestmapping上的value，id和id相对称
@FeignClient(name = "provider-user")//@FeignClient(name = "provider-user",url = "提供者暴露的地址和端口")
public interface UserFeignClient {
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public User findById(@PathVariable("id") int id);
}
