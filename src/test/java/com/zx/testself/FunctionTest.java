package com.zx.testself;

import com.zx.testself.functionalInterface.DataTypeReq;
import com.zx.testself.functionalInterface.FunctionalInterfaceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName FunctionTest
 * @Description 函数式接口测试类
 * @Author EDY
 * @Date 2024/5/28 上午9:32
 **/
@ComponentScan(basePackages = {"com.zx.testself.*"})
@SpringBootTest(classes = FunctionTest.class)
public class FunctionTest {

  @Autowired
  private FunctionalInterfaceService functionalInterfaceService;

  @Test
  void testFunction() {
    DataTypeReq dataTypeReq = new DataTypeReq();
    dataTypeReq.setCode(1);
    dataTypeReq.setName("张三");
    functionalInterfaceService.test(dataTypeReq);

    DataTypeReq dataTypeReq2 = new DataTypeReq();
    dataTypeReq2.setCode(2);
    dataTypeReq2.setName("里斯");
    functionalInterfaceService.test(dataTypeReq2);

    DataTypeReq dataTypeReq3 = new DataTypeReq();
    dataTypeReq3.setCode(3);
    dataTypeReq3.setName("王武");
    functionalInterfaceService.test(dataTypeReq3);
  }


}
