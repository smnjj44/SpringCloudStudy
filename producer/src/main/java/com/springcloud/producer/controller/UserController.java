package com.springcloud.producer.controller;

import com.springcloud.producer.vo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author simonliang
 * @className UserController
 * @description
 * @date 2020/9/27 4:06 下午
 */
@RestController
public class UserController {

    @GetMapping("/{id}")
    public User findById(@PathVariable int id){
        User user = new User();
        user.setId(id);
        user.setName("李飞1");
        return user;
    }

    //测试网关跳转
    @GetMapping("/zuul/test/{id}")
    public String zuulMovieTest(@PathVariable int id){
        return "test zuul" + id;
    }
}
