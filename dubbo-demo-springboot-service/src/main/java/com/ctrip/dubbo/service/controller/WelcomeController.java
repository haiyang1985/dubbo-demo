package com.ctrip.dubbo.service.controller;

import java.util.Date;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author hy_gu on 2019/7/9
 **/
@Controller
public class WelcomeController {

  @GetMapping("/")
  public String welcome(Map<String, Object> model) {
    model.put("time", new Date());
    model.put("message", "Dubbo Service Started!");
    return "welcome";
  }
}

