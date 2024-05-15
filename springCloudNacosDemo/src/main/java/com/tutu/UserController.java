package com.tutu;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class UserController {

////    @NacosValue(value = "${spring.datasource.username}", autoRefreshed = true)
//    @Value("${spring.datasource.username}")
//    String username;

    @Autowired
    CommonConfig config;


    @GetMapping("/test")
    public String test () {
        return config.getUsername();
    }
}
