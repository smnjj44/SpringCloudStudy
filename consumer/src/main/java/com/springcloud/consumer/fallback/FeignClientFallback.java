package com.springcloud.consumer.fallback;

import com.springcloud.consumer.feign.UserFeignClient;
import com.springcloud.consumer.vo.User;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author simonliang
 * @className FeignClientFallback
 * @description
 * @date 2020/9/29 4:00 下午
 */
@Component
public class FeignClientFallback implements UserFeignClient {

    @Override
    public User findById(int id) {
        User user = new User();
        user.setName("默认yonghu");
        user.setId(0);
        return user;
    }

    @Override
    public User get1(int id, String userName) {
        return null;
    }

    @Override
    public User get2(Map<String, Object> map) {
        return null;
    }

    @Override
    public User post(User user) {
        return null;
    }
}
