package com.ctrip.framework.api;

import java.util.concurrent.CompletableFuture;

public interface DemoService {

  String sayHello(String name);

  CompletableFuture<String> sayHelloFuture(String name);

  void addListener(String key, CallbackListener listener);
}
