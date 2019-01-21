package com.cbs.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;

@AllArgsConstructor//全参构造
@NoArgsConstructor//空参构造
@Data//get-set
@Accessors(chain = true)//链式操作
public class Dept implements Serializable {//必须序列化
    private Integer deptId;
    private String deptName;
    private String deptCode;
    private String dbSource;

    public static void main(String[] args) {
        Dept dept = new Dept().setDeptCode("0001").setDeptName("测试一部").setDbSource("cbs_0001");
        System.out.println(dept);
    }
}

