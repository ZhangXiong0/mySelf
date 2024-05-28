package com.zx.testself.functionalInterface;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataTypeExecutor {

  private static DealServiceComponent dealServiceComponent;

  @Autowired
  private DataTypeExecutor(DealServiceComponent dealServiceComponent) {
    DataTypeExecutor.dealServiceComponent = dealServiceComponent;
  }

  //1、通过构造器注入一个具体实现的方法实例
  //2、定义一个函数式接口
  //3、定义枚举，每个枚举执行不同的方法
  @Getter
  public enum DataTypeEnum {
    DEAL_METHOD1(1, "dealMethod1", "dealMethod1",
        (dataTypeReq) -> dealServiceComponent.dealMethod1(dataTypeReq)),
    DEAL_METHOD2(2, "dealMethod2", "dealMethod2",
        (dataTypeReq) -> dealServiceComponent.dealMethod2(dataTypeReq)),
    DEAL_METHOD3(3, "dealMethod3", "dealMethod3",
        (dataTypeReq) -> dealServiceComponent.dealMethod3(dataTypeReq));

    private final int code;
    private final String name;
    private final String desc;
    private final DataTypeInterface dataTypeInterface;

    DataTypeEnum(int code, String name, String desc, DataTypeInterface dataTypeInterface) {
      this.code = code;
      this.name = name;
      this.desc = desc;
      this.dataTypeInterface = dataTypeInterface;
    }

    public DataTypeResult deal(DataTypeReq dataTypeReq) {
      return dataTypeInterface.dealMethod(dataTypeReq);
    }

    //根据code获取枚举
    public static DataTypeEnum of(int code) {
      for (DataTypeEnum value : values()) {
        if (value.getCode() == code) {
          return value;
        }
      }
      return null;
    }


  }


}
