package com.ctrip.dubbo.client.controller;

import java.util.Map;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.rpc.RpcContext;
import com.ctrip.framework.api.DemoService;

/**
 * @author hy_gu on 2018/3/6
 **/
@Controller
@RequestMapping("/dubbo")
public class CDubboCodeController {

  @Reference(init = true)
  private DemoService demoService;

  @GetMapping("/sync")
  public String sync(Map<String, Object> model) throws Exception {
    model.put("codeType", "Contract First");
    model.put("invokeType", "Sync");
    model.put("dubboResponse", demoService.sayHello("sayHello"));
    model.put("serverIP", RpcContext.getContext().getRemoteHost() + ":" + RpcContext.getContext().getRemotePort());
    return "service";
  }
}
