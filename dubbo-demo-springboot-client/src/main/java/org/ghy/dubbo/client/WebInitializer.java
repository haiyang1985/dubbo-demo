package org.ghy.dubbo.client;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author hy_gu on 2018/3/6
 **/
@SpringBootApplication
@ComponentScan(value = {"org.ghy.dubbo.client"})
@EnableDubbo(scanBasePackages = "org.ghy.dubbo.client")
@PropertySource("classpath:/spring/dubbo-consumer.properties")
public class WebInitializer extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(WebInitializer.class);
  }
}
