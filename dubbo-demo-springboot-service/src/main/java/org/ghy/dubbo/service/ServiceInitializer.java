package org.ghy.dubbo.service;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@DubboComponentScan()
@EnableDubbo(scanBasePackages = "org.ghy.dubbo.service")
@PropertySource("classpath:/spring/dubbo-provider.properties")
public class ServiceInitializer extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(ServiceInitializer.class);
  }
}
