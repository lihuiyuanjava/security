package com.security.controller;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

      /*  public static void exportTreeDataToExcel(List<UserTest> customers, String[] column, int rowStart, String filePath) throws IOException {

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Tree Data");

            int rowNum = 0;

            for (UserTest customer : customers) {
                Row row = sheet.createRow(rowNum++);
                Cell cell = row.createCell(1);
                cell.setCellValue(customer.getUserName());

                List<UserTest> childUser = customer.getChildUser();
                for (UserTest child : childUser) {
                    row = sheet.createRow(rowNum++);
                    cell = row.createCell(1);
                    cell.setCellValue(child.getUserName());
                }
            }

            FileOutputStream fileOut = new FileOutputStream(filePath);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
        }*/





      /*  public static void exportTreeDataToExcel(List<UserTest> userList,String[] column, String filePath) throws IOException {
            try (Workbook workbook = new XSSFWorkbook()) {
                Sheet sheet = workbook.createSheet("User Tree");

                // Create headers
                Row headerRow = sheet.createRow(0);
                *//*headerRow.createCell(0).setCellValue("Username");
                headerRow.createCell(1).setCellValue("Password");
                headerRow.createCell(2).setCellValue("Phone");
                headerRow.createCell(3).setCellValue("Type");*//*

                for(int i =0; i<column.length;i++){
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(column[i]);
                }

                int rowNum = 1;
                for (UserTest user : userList) {
                    rowNum = createRow(sheet, user, rowNum, 0);
                }

                // Write the output to a file
                try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                    workbook.write(fileOut);
                }
            }
        }
*/
/*
    在Java做数据新增过程中，有这样一种场景，一个集合之中有B、C、D、数据还有其他的数据，B、C为D的前置任务此时怎么获取B、C的id以方便存储
*/

    public class Main {
        public static void main(String[] args) {
            // 创建一个Map来保存任务和其前置任务的关系
            Map<String, List<String>> taskMap = new HashMap<>();
            taskMap.put("D", Arrays.asList("B", "C")); // D的前置任务是B和C

            // 保存数据的过程中根据前置任务获取B和C的ID
            List<String> tasks = Arrays.asList("A", "B", "C", "D");
            for (String task : tasks) {
                List<String> prerequisiteTasks = taskMap.get(task);
                if (prerequisiteTasks != null) {
                    System.out.println("任务 " + task + " 的前置任务：" + prerequisiteTasks);
                    // 在这里可以保存B和C的ID
                    // 例如，将它们存储到数据库或其他数据结构中
                }
            }
        }
    }

    // 在保存数据的过程中获取B和C的ID
       /* private static int createRow(Sheet sheet, UserTest user, int rowNum, int indent) {
            Row row = sheet.createRow(rowNum++);
            CellStyle style = sheet.getWorkbook().createCellStyle();
            //style.setIndention(indent);

            row.createCell(0).setCellValue(user.getUserName());
            row.createCell(1).setCellValue(user.getPassWrod());
            row.createCell(2).setCellValue(user.getUserPhone());
            row.createCell(3).setCellValue(user.getTyep());


            if (user.getChildUser() != null) {
                for (UserTest child : user.getChildUser()) {
                    rowNum = createRow(sheet, child, rowNum, indent + 1);
                }
            }
            return rowNum;
        }*/

    private static int createRow(Sheet sheet, UserTest user, int rowNum, int indent) {
        Row row = sheet.createRow(rowNum++);
        CellStyle style = sheet.getWorkbook().createCellStyle();
        // style.setIndention(indent);

        // 一次性设置多个单元格的值
        String[] values = {user.getUserName(), user.getPassWrod(), user.getUserPhone(), user.getTyep()};
        for (int i = 0; i < values.length; i++) {
            row.createCell(i).setCellValue(values[i]);
        }

        if (user.getChildUser() != null) {
            for (UserTest child : user.getChildUser()) {
                rowNum = createRow(sheet, child , rowNum, indent + 1);
            }
        }
        return rowNum;
    }

    /*
    内连接（INNER JOIN）：

INNER JOIN 从两个表中选取符合条件的记录。
如果两个表中的行在连接条件上匹配，则会被包含在结果集中。
如果一个表中的行在另一个表中没有匹配，则不会包含在结果集中。
例如，如果你有两个表，一个是“顾客”表，另一个是“订单”表，你可以使用 INNER JOIN 找到两个表中匹配的记录，比如每个订单对应的顾客信息。

sql
复制代码
SELECT Orders.OrderID, Customers.CustomerName
FROM Orders
INNER JOIN Customers ON Orders.CustomerID = Customers.CustomerID;
左连接（LEFT JOIN）：

LEFT JOIN 从左表（第一个表）中选取所有的行，而不管是否在右表（第二个表）中存在匹配的行。
如果右表中没有与左表中的行匹配的行，则结果集中右表的列将包含 NULL 值。
例如，使用 LEFT JOIN，你可以获取包括没有订单的顾客信息。

sql
复制代码
SELECT Customers.CustomerName, Orders.OrderID
FROM Customers
LEFT JOIN Orders ON Customers.CustomerID = Orders.CustomerID;
总的来说，INNER JOIN 返回两个表中匹配的行，而 LEFT JOIN 返回左表中的所有行，同时匹配右表中的行，如果没有匹配，则右表中的列将包含 NULL 值。

SELECT *
    FROM my_table
    WHERE created_at >= NOW() - INTERVAL 2 HOUR;

    SELECT *
    FROM my_table
    WHERE created_at >= NOW() AND created_at <= DATE_ADD(NOW(), INTERVAL 2 HOUR);


    */




}
