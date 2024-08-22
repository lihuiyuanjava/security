package com.security.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class ExcelExporter {
    public static void main(String[] args) throws IOException {
        String[] column={"用户名称","用户密码","用户类型","用户手机号"};
        List<UserTest> userTestParent = new ArrayList<>();
        ArrayList<UserTest> childList1 = new ArrayList<>();
        UserTest childTest1 = new UserTest();
        childTest1.setUserName("张张1");
        childTest1.setTyep("测试任务");
        childTest1.setPassWrod("123456");
        childTest1.setUserPhone("17789456321");
        childList1.add(childTest1);

        UserTest childTest2 = new UserTest();
        childTest2.setUserName("张张1.1");
        childTest2.setPassWrod("admin12345");
        childTest2.setTyep("交付物审批");
        childTest2.setUserPhone("13378654211");
        childList1.add(childTest2);

        ArrayList<UserTest> childList2 = new ArrayList<>();
        UserTest childTest3 = new UserTest();
        childTest3.setUserName("张张2");
        childTest3.setPassWrod("pht123456");
        childTest3.setTyep("交付物必上传");
        childTest3.setUserPhone("17768360574");
        childList2.add(childTest3);

        UserTest childTest4 = new UserTest();
        childTest4.setUserName("张张2.2");
        childTest4.setPassWrod("gtr123456");
        childTest4.setTyep("交付物非必上传");
        childTest4.setUserPhone("13657598421");
        childList2.add(childTest4);

        ArrayList<UserTest> childList3 = new ArrayList<>();
        UserTest childTest5 = new UserTest();
        childTest5.setUserName("张张3");
        childTest5.setPassWrod("ioop168354");
        childTest5.setTyep("开发任务");
        childTest5.setUserPhone("17768362598");
        childList3.add(childTest5);

        UserTest childTest6 = new UserTest();
        childTest6.setUserName("张张3.3");
        childTest6.setPassWrod("aaa123852");
        childTest6.setTyep("需求编写");
        childTest6.setUserPhone("19806235213");
        childList3.add(childTest6);


        UserTest testRoot1 = new UserTest();
        testRoot1.setUserName("张一");
        testRoot1.setPassWrod("aaabbb123456");
        testRoot1.setTyep("需求编写");
        testRoot1.setUserPhone("19135315365");
        testRoot1.setChildUser(childList1);
        userTestParent.add(testRoot1);

        UserTest testRoot2 = new UserTest();
        testRoot2.setUserName("张二");
        testRoot2.setPassWrod("lhy3333");
        testRoot2.setTyep("开发任务");
        testRoot2.setUserPhone("18327594591");
        testRoot2.setChildUser(childList2);
        userTestParent.add(testRoot2);

        UserTest testRoot3 = new UserTest();
        testRoot3.setUserName("张三");
        testRoot3.setPassWrod("阿达23456");
        testRoot3.setTyep("测试任务");
        testRoot3.setUserPhone("17756985421");
        testRoot3.setChildUser(childList3);
        userTestParent.add(testRoot3);
        //exportTreeDataToExcel(userTestParent,column,"tree_data.xlsx");
        System.out.println("Excel文件导出成功！");

    }




}

