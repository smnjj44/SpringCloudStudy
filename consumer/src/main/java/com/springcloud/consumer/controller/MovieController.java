package com.springcloud.consumer.controller;

import com.springcloud.consumer.feign.UserFeignClient;
import com.springcloud.consumer.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author simonliang
 * @className MovieController
 * @description
 * @date 2020/9/27 4:24 下午
 */
@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private UserFeignClient userFeignClient;

    /**
     * 传统调用,硬编码方式
     * @param id
     * @return
     */
    @GetMapping("user/{id}")
    public User findById(@PathVariable int id){
        return this.restTemplate.getForObject("http://localhost:8000/" + id , User.class);
    }

    //在RestTemplate贴上LoadBalanced注解就行，启动多个提供者，提供者虚拟主机名一致就行，然后观察sout出来的端口，相同请求参数只会去同一台机
    @GetMapping("user/ribbon/{id}")
    public User findByIdRibbon(@PathVariable int id){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("provider-user");
        System.out.println(serviceInstance.getServiceId()+serviceInstance.getHost()+serviceInstance.getPort());
        return this.restTemplate.getForObject("http://provider-user/"+id,User.class);
    }

    //编辑好feign接口在启动上贴个EnableFeignClients注解和feign上的FeignClient的注解相对应，
    // FeignClient上是寻找对应的应用和创建ribbon的负载均衡器，EnableFeignClients相当于接口的@bean或者@service
    @GetMapping("user/feign/{id}")
    public User findByIdFeign(@PathVariable int id){
        return this.userFeignClient.findById(id);
    }
}
