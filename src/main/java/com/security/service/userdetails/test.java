package com.security.service.userdetails;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title： test
 * @Description： TODO
 * @Author： liang.he
 * @CreateTime： 2023/4/1 11:47
 * @Version： 1.0.0
 * @department： 房联电⼦科技有限公司
 */
public class test {
    /**
     * 比较两个实体属性值，返回一个map以有差异的属性名为key，
     * value为一个list分别存obj1,obj2此属性名的值。
     *
     * @param obj1       进行属性比较的对象1
     * @param obj2       进行属性比较的对象2
     * @param ignoreList 选择不需要比较的属性名集合
     * @return 属性差异比较结果map
     */
    public static Map<String, List<Object>> compareFields(Object obj1, Object obj2, List<String> ignoreList) {
        Map<String, List<Object>> map = new HashMap<>();
        if (obj1.getClass() != obj2.getClass()) {
            throw new IllegalArgumentException("Objects must be of the same type.");
        }

        Class<?> clazz = obj1.getClass();
        try {
            PropertyDescriptor[] pds = Introspector.getBeanInfo(clazz, Object.class).getPropertyDescriptors();

            for (PropertyDescriptor pd : pds) {
                String name = pd.getName();

                // 忽略某些属性
                if (ignoreList.contains(name)) {
                    continue;
                }

                Method readMethod = pd.getReadMethod();
                if (readMethod != null) {
                    Object value1 = readMethod.invoke(obj1);
                    Object value2 = readMethod.invoke(obj2);

                    if (!value1.equals(value2)) {
                        List<Object> values = new ArrayList<>();
                        values.add(value1);
                        values.add(value2);
                        map.put(name, values);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error comparing fields", e);
        }

        return map;
    }

    public static void main(String[] args) {
        // 示例：ArrayList
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        String itemToCheck = "banana";
        if (list.contains(itemToCheck)) {
            System.out.println("List contains " + itemToCheck);
        } else {
            System.out.println("List does not contain " + itemToCheck);
        }
    }

}
