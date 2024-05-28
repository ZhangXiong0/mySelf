package com.zx.testself.functionalInterface;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @ClassName DealServiceImpl
 * @Description 具体实现逻辑类
 * @Author EDY
 * @Date 2024/5/28 上午9:01
 **/


@Slf4j
@Component
public class DealServiceComponent {

  public DataTypeResult dealMethod1(DataTypeReq dataTypeReq) {
    DataTypeResult dataTypeResult = new DataTypeResult();
    dataTypeResult.setResult("dealMethod1" + dataTypeReq.getName());
    return dataTypeResult;
  }


  public DataTypeResult dealMethod2(DataTypeReq dataTypeReq) {
    DataTypeResult dataTypeResult = new DataTypeResult();
    dataTypeResult.setResult("dealMethod2" + dataTypeReq.getName());
    return dataTypeResult;
  }

  public DataTypeResult dealMethod3(DataTypeReq dataTypeReq) {
    DataTypeResult dataTypeResult = new DataTypeResult();
    dataTypeResult.setResult("dealMethod3" + dataTypeReq.getName());
    return dataTypeResult;
  }


}
