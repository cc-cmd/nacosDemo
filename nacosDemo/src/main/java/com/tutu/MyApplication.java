package com.tutu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spring方式获取nacos配置
 */
public class MyApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MyConfig.class);

        UserService userService = applicationContext.getBean(UserService.class);
        userService.test();
    }
}
