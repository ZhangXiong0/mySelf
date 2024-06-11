package com.zx.testself.completable;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import lombok.AllArgsConstructor;

/**
 * @ClassName CompletableFutureManage
 * @Description CompletableFuture管理类
 * @Author EDY
 * @Date 2024/6/11 上午11:49
 **/

@AllArgsConstructor
public class CompletableFutureManage {

  CompletableFuture<String> future1;

  CompletableFuture<Map<String, String>> future2;

  public String getFuture1() throws ExecutionException, InterruptedException {
    return future1.get();
  }

  public Map<String, String> getFuture2() throws ExecutionException, InterruptedException {
    return future2.get();
  }


  //获取所有结果
  public List<CompletableFuture<?>> values() {
    return List.of(future1, future2);
  }

}
