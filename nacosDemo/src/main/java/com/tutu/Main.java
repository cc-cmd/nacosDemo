package com.tutu;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * JAVA SDK方式获取nacos配置
 */
public class Main {
    public static void main(String[] args) {
        //拉取nacos配置
        try {
            String serverAddr = "localhost:8848";
            String dataId = "test";
            String group = "DEFAULT_GROUP";

            Properties properties = new Properties();
            properties.put("serverAddr", serverAddr);
            ConfigService configService = NacosFactory.createConfigService(properties);
            String content = configService.getConfig(dataId, group, 5000);
//            System.out.println(content);

            //添加监听器
            configService.addListener(dataId, group, new Listener() {
                @Override
                public Executor getExecutor() {
                    return null;
                }

                @Override
                public void receiveConfigInfo(String s) {
                    System.out.println("receiveConfigInfo");
                    System.out.println(s);
                }
            });

            System.in.read();
        }catch(NacosException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}