package com.tutu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Value("${spring.datasource.username}")
    String username;

    public void test (){
        System.out.println(username);
    }
}
