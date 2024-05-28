package com.zx.testself.functionalInterface;

import org.springframework.stereotype.Service;

/**
 * @ClassName FunctionalInetrfaceDemo
 * @Description 函数式接口测试类
 * @Author EDY
 * @Date 2024/5/28 上午8:56
 **/
@Service
public class FunctionalInterfaceService {

  public void test(DataTypeReq dataTypeReq) {
    //根据code获取对应枚举
    DataTypeExecutor.DataTypeEnum dataTypeEnum =
        DataTypeExecutor.DataTypeEnum.of(dataTypeReq.getCode());
    //根据具体枚举调用不同的方法
    assert dataTypeEnum != null;
    DataTypeResult deal = dataTypeEnum.deal(dataTypeReq);
    System.out.println(deal.getResult());
  }

}
