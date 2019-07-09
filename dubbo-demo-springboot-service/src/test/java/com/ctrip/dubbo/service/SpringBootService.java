package com.ctrip.dubbo.service;

import java.awt.*;
import java.net.URI;
import org.springframework.boot.SpringApplication;
import com.ctrip.dubbo.service.zookeeper.EmbeddedZooKeeper;

/**
 * @author hy_gu on 2018/3/9
 **/
public class SpringBootService {

  public static void main(String[] args) throws Exception {
    System.setProperty("java.awt.headless", "false");
    new EmbeddedZooKeeper(2181, false).start();
    SpringApplication.run(ServiceInitializer.class);
    Desktop.getDesktop().browse(new URI("http://localhost:8080"));
  }
}
