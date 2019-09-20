import java.awt.*;
import java.net.URI;
import org.springframework.boot.SpringApplication;

import org.ghy.dubbo.client.WebInitializer;

/**
 * @author hy_gu on 2018/3/9
 **/
public class SpringBootClient {

  public static void main(String[] args) throws Exception {
    System.setProperty("java.awt.headless", "false");
    System.setProperty("server.port", "8090");
    SpringApplication.run(WebInitializer.class);
    Desktop.getDesktop().browse(new URI("http://localhost:8090"));
  }
}
