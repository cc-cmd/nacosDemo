package com.tutu;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {

//    @Value注解无法实时刷新。此外，在springboot项目中外层的autoRefreshed属性不起作用，必须在bean属性中配置autoRefreshed属性如下
//    @NacosValue(value = "${spring.datasource.user}", autoRefreshed = true)
    @Value("${spring.datasource.username}")
    String username;

    @GetMapping("/test")
    public String test () {
        return username;
    }

}
