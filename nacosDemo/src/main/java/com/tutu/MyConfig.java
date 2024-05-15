package com.tutu;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.tutu")
@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "localhost:8848"))
@NacosPropertySource(dataId = "test", autoRefreshed = true)
public class MyConfig {
}
