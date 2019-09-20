package org.ghy.dubbo.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.dubbo.config.annotation.Service;

import org.ghy.dubbo.api.CallbackListener;
import org.ghy.dubbo.api.DemoService;

@Service
public class DemoServiceImpl implements DemoService {
  private final Map<String, CallbackListener> listeners = new ConcurrentHashMap<String, CallbackListener>();

  public DemoServiceImpl() {
    startTimer();
  }

  @Override
  public String sayHello(String name) {
    return "Hello " + name;
  }

  @Override
  public CompletableFuture<String> sayHelloFuture(String name) {
    return CompletableFuture.supplyAsync(() -> {
      return "welcome " + name;
    });
  }

  @Override
  public void addListener(String key, CallbackListener listener) {
    listeners.put(key, listener);
  }

  private String getChanged(String key) {
    return "Changed: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
  }

  private void startTimer() {
    Thread t = new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          try {
            for (Map.Entry<String, CallbackListener> entry : listeners.entrySet()) {
              try {
                entry.getValue().changed(getChanged(entry.getKey()));
              } catch (Throwable t) {
                listeners.remove(entry.getKey());
              }
            }
            Thread.sleep(1000); // 定时触发变更通知
          } catch (Throwable t) { // 防御容错
            t.printStackTrace();
          }
        }
      }
    });
    t.setDaemon(true);
    t.start();
  }
}
