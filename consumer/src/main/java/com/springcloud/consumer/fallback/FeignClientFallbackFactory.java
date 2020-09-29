package com.springcloud.consumer.fallback;

import com.springcloud.consumer.feign.UserFeignClient;
import com.springcloud.consumer.vo.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author simonliang
 * @className FeignClientFallbackFactory
 * @description 查找回滚原因的回滚类
 * @date 2020/9/29 4:04 下午
 */
@Component
public class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {
    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {
            @Override
            public User findById(int id) {
                System.out.println("失败原因-----------"+throwable);
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
        };
    }
}
