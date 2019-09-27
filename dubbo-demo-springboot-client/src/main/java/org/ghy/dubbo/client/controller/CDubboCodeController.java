package org.ghy.dubbo.client.controller;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.function.Consumer;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.rpc.RpcContext;
import org.ghy.dubbo.api.DemoService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    model.put("serverIP", "Null");
    return "service";
  }


  @GetMapping("/mono")
  public String mono(Map<String, Object> model) throws Exception {
    model.put("codeType", "Contract First");
    model.put("invokeType", "Mono");
    model.put("dubboResponse", testMono());
    model.put("serverIP", "Null");
    return "service";
  }

  @GetMapping("/flux")
  public String flux(Map<String, Object> model) throws Exception {
    model.put("codeType", "Contract First");
    model.put("invokeType", "Flux");
    model.put("dubboResponse", testFlux());
    model.put("serverIP", "Null");
    return "service";
  }

  private String testMono() {
    CompletableFuture<String> future = new CompletableFuture();
    try {
      Mono<String> mono = demoService.sayMono(Mono.just("Hi"), Mono.just("message"));
      mono.subscribe(s -> {
        future.complete(s);
      });
      return future.get();
    } catch (Throwable e) {
      e.printStackTrace();
    }
    return "";
  }

  private String testFlux() {
    CompletableFuture<String> future = new CompletableFuture<>();
    try {
      Flux<String> flux = demoService.sayFlux(Flux.just("Hi"), Flux.just("message"));
      flux.doOnNext(new Consumer<String>() {
        @Override
        public void accept(String s) {
          future.complete(s);
        }
      }).blockFirst();

      return future.get();
    } catch (Throwable e) {
      e.printStackTrace();
    }
    return "";
  }
}
