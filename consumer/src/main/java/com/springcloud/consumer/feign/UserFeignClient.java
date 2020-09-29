package com.springcloud.consumer.feign;

import com.springcloud.consumer.fallback.FeignClientFallback;
import com.springcloud.consumer.fallback.FeignClientFallbackFactory;
import com.springcloud.consumer.vo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author simonliang
 * @className UserFeignClient
 * @description
 * @date 2020/9/28 6:00 下午
 */
//自带ribbon的负载均衡功能，通过provider-user到注册中心找到对应ip，直接http请求拼接上requestmapping上的value，id和id相对称
//@FeignClient(name = "provider-user")//@FeignClient(name = "provider-user",url = "提供者暴露的地址和端口") @FeignClient(name = "",configuration = 配置类class.class)例如修改feign的默认原生契约和自定义feign配置的编码器，解码器，日志打印
//只要Hystrix在项目的classpath中，Feign就会使用断路器包裹feign客户端的所有方法，可以对部分feign不用回滚的实施禁用，把不需要回滚的方法都放在这个feign即可@FeignClient(name="provider-user",configuration = FeignDisableHystrixConfiguration.class,也可以在yml中配置feign.hystrix.enabled=false)
//@FeignClient(name = "provider-user",fallback = FeignClientFallback.class)//回滚的class，不带失败导致回滚的原因
@FeignClient(name = "provider-user",fallbackFactory = FeignClientFallbackFactory.class)//fallback为hystrix专用,如果要查回滚原因回滚类需要实现FallbackFactory接口,需要在yml配置文件开启feign的熔断器hystrix功能，feign.hystrix.enable=true功能
public interface UserFeignClient {
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    User findById(@PathVariable("id") int id);

    //get多参数写法
    @RequestMapping(value = "/get" , method = RequestMethod.GET)
    User get1(@RequestParam("id")int id,@RequestParam("username")String userName);

    @RequestMapping(value = "/get" , method = RequestMethod.GET)
    User get2(@RequestParam Map<String,Object> map);

    //post多参数写法
    @PostMapping("/post")
    User post(@RequestBody User user);
}
