package org.ghy.dubbo.service.configuration;

import org.apache.dubbo.config.ProtocolConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfiguration {
    @Bean
    public ProtocolConfig getConfig(){
        ProtocolConfig config=new ProtocolConfig();
        config.setId("dubbo1");
        config.setName("dubbo");
        config.setPort(20770);
        return config;
    }
}
