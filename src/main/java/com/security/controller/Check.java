package com.security.controller;

import com.security.config.MyCustomException;

import java.util.ArrayList;
import java.util.List;

/**
 * @title： Check
 * @Description： TODO
 * @Author： liang.he
 * @CreateTime： 2024/4/21 12:14
 * @Version： 1.0.0
 * @department： 房联电⼦科技有限公司
 */
public class Check {
    public static void check(){
        try {
            // 创建一个包含值的 List 集合
            List<MyClass> listWithValueOne = new ArrayList<>();
            listWithValueOne.add(new MyClass(10));
            listWithValueOne.add(new MyClass(20));
            listWithValueOne.add(new MyClass(30));
            List<MyClass> listWithValueTwo = new ArrayList<>();
            if (listWithValueOne.size()>0) {
                throw new Exception("项目集已存在模板请不要重复添加");
            }
            if (listWithValueTwo.size()>0){
                throw new MyCustomException("项目已存在模板请不要重复添加");
            }
        } catch (Exception e) {
            System.out.println("捕获到自定义异常：" + e.getMessage());
            // 在这里处理异常
        }

    }


}
