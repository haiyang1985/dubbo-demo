package com.ctrip.dubbo.client.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author hy_gu on 2018/3/12
 **/
@Controller
public class WelcomeController {

  @GetMapping("/")
  public String welcome(Map<String, Object> model) {
    model.put("time", new Date());
    model.put("message", "Dubbo Client Started");
    return "welcome";
  }
}
