package com.zx.testself.completable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName CompletableFutureService
 * @Description 业务处理类
 * @Author EDY
 * @Date 2024/6/11 上午11:51
 **/

@Service
@Slf4j
public class CompletableFutureService {
  private final ThreadPoolExecutor threadPoolExecutor =
      new ThreadPoolExecutor(20, 50, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(2000),
          (r, executor) -> log.error("有任务被拒绝执行了"));


  public void dealBusiness() throws ExecutionException, InterruptedException, TimeoutException {
    // 业务处理
    CompletableFutureManage completableFutureManage = new CompletableFutureManage(
        doSomething1(), doSomething2()
    );

    //同步获取所有结果
    System.out.println(CompletableFuture.allOf(
            completableFutureManage.values().stream().map(future -> future.thenApplyAsync(
                Function.identity(), threadPoolExecutor)).toArray(CompletableFuture[]::new))
        .get(1, TimeUnit.MILLISECONDS));
  }


  //异步处理
  public CompletableFuture<String> doSomething1() {

    return CompletableFuture.supplyAsync(() -> {
      try {
        // 业务处理
        Thread.sleep(2000);
        return "success";
      } catch (Exception e) {
        log.error("doSomething1 error", e);
      }
      return "fail";
    });

  }


  //异步处理
  public CompletableFuture<Map<String, String>> doSomething2() {
    return CompletableFuture.supplyAsync(() -> {
      // 业务处理
      HashMap<String, String> map = new HashMap<>();
      map.put("key", "value");
      try {
        return map;
      } catch (Exception e) {
        log.error("doSomething2 error", e);
      }
      return null;
    });
  }


}
