package org.ghy.dubbo.service;

import java.awt.*;
import java.net.URI;
import org.ghy.dubbo.service.zookeeper.EmbeddedZooKeeper;
import org.springframework.boot.SpringApplication;

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
