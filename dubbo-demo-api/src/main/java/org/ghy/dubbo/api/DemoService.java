package org.ghy.dubbo.api;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public interface DemoService {

  String sayHello(String name);

  CompletableFuture<String> sayHelloFuture(String name);

  void addListener(String key, CallbackListener listener);

  Mono<String> sayMono(Mono<String> m1, Mono<String> m2);

  Flux<String> sayFlux(Flux<String> f1, Flux<String> f2);
}
