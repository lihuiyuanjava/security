package com.security.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @title： user
 * @Description： TODO
 * @Author： liang.he
 * @CreateTime： 2023/4/1 11:47
 * @Version： 1.0.0
 * @department： 房联电⼦科技有限公司
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTest {
    private String userName;

    private String passWrod;

    private String userPhone;

    private String tyep;


    List<UserTest> childUser;


    public static void main(String[] args) {
        /*String input1 = "value1";
        String input2 = "value1,value2";

        String[] array1 = input1 .split(",");
        String[] array2 = input2.split(",");
        System.out.println(array1);
        System.out.println(array2);*/

    /*    String[] array = {"value1", "value2", "value3"};
        List<String> set = new ArrayList<>(Arrays.asList("value2", "value4", "value6"));

        boolean existsInSet = Arrays.stream(array)
                .anyMatch(set::contains);

        if (existsInSet) {
            System.out.println("在");
        } else {
            System.out.println("不在");


        }*/
       /* String[] options = {"Option 1", "Option 2", "Option 3"};

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Data");

            // 创建下拉列表约束
            DataValidationHelper validationHelper = sheet.getDataValidationHelper();

            // 下拉列表
            CellRangeAddressList addressList = new CellRangeAddressList(1, 1, 0, 0); // 第2行的第1列
            DataValidationConstraint constraint = validationHelper.createExplicitListConstraint(options);
            DataValidation dataValidation = validationHelper.createValidation(constraint, addressList);
            sheet.addValidationData(dataValidation);

            // 创建标题行
            Row headerRow = sheet.createRow(0);
            Cell headerCell = headerRow.createCell(0);
            headerCell.setCellValue("Select an Option");

            // 保存工作簿到文件
            try (FileOutputStream fileOut = new FileOutputStream("workbook.xlsx")) {
                workbook.write(fileOut);
                System.out.println("Excel file has been created successfully!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        /*int[] arr = {1, 2, 3, 4, 5};
        StringJoiner joiner = new StringJoiner(",");
        for (int num : arr) {
            joiner.add(String.valueOf(num));
        }
        String str = joiner.toString();
        System.out.println(str);*/

      /*  List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        // 将list2的数据添加到list1中
        list1.addAll(list2);
        System.out.println(list1);
        String str = "example.txt";

        // 找到第一个点的位置
        int dotIndex = str.indexOf(".");

        // 如果找到了点，则截取点后面的字符串
        if (dotIndex != -1) {
            String result = str.substring(dotIndex + 1);
            System.out.println("截取后的字符串为：" + result);
        } else {
            System.out.println("未找到点");
        }*/


        /*@GetMapping("/download")
        public ResponseEntity<ByteArrayResource> downloadFiles() throws IOException {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try (ZipOutputStream zipOut = new ZipOutputStream(outputStream)) {
                // 添加多个文件到压缩包中
                String[] files = {"file1.txt", "file2.txt", "file3.txt"};
                for (String file : files) {
                    addToZipFile(file, zipOut);
                }

                zipOut.finish();
            }

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", "files.zip");
            ByteArrayResource resource = new ByteArrayResource(outputStream.toByteArray());

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(resource.contentLength())
                    .body(resource);
        }

        private void addToZipFile(String fileName, ZipOutputStream zipOut) throws IOException {
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zipOut.putNextEntry(zipEntry);
            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }*/
        String a = "1-2";

        // 获取杠之前的字符
        String beforeDash = a.substring(0, a.indexOf("-"));

        // 获取杠之后的字符
        String afterDash = a.substring(a.indexOf("-") + 1);

        System.out.println("Before dash: " + beforeDash);
        System.out.println("After dash: " + afterDash);
  /*      List<String> list = List.of("a", "b", "c", "d");
2. WebSocket配置
创建一个WebSocket配置类，用于注册WebSocket端点：

java
复制代码
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new WebSocketHandler(), "/websocket");
    }
}


3. WebSocket处理器
创建一个WebSocket处理器类，用于处理WebSocket连接、消息、关闭等事件：

java
复制代码
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 接收到消息
        System.out.println("Received message: " + message.getPayload());

        // 发送消息给所有连接的客户端
        session.sendMessage(new TextMessage("Server received: " + message.getPayload()));
    }
}

ALTER TABLE your_table_name ADD COLUMN id INT AUTO_INCREMENT PRIMARY KEY;

4. 控制器
创建一个简单的控制器类，用于返回WebSocket页面：

java
复制代码
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebSocketController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}

SELECT u.username, GROUP_CONCAT(r.role_name) AS roles
FROM users u
JOIN user_roles ur ON u.user_id = ur.user_id
JOIN roles r ON ur.role_id = r.role_id
GROUP BY u.username
HAVING COUNT(ur.role_id) > 1; -- 选择具有多个角色的用户

*/

        ArrayList<Object> objects = new ArrayList<>();


        ArrayList<String> allPermission = new ArrayList<>();
        allPermission.add("ADMIN");
        allPermission.add("MANAGEMENT");

        ArrayList<String> partPermission = new ArrayList<>();
        partPermission.add("BUSINESS_MANAGER");
        partPermission.add("DEMAND");
        partPermission.add("DEVELOPMENT_DESIGNER");
        partPermission.add("PROJECT_MANAGER_INBANK");
        partPermission.add("PROJECT_ASSISTANT_INBANK");
        partPermission.add("TEXT_EXAMINATION");
        partPermission.add("PROJECT_MANAGER");
        partPermission.add("TECHNICAL_MANAGER");
        partPermission.add("DEVELOPMENT_LEADER");
        partPermission.add("TEST_MANAGER");

        ArrayList<String> selfPermission = new ArrayList<>();
        selfPermission.add("DEV_OPS");
        selfPermission.add("CHECKING");
        selfPermission.add("DEVELOPER");
        selfPermission.add("TESTER");


        // 创建一个ArrayList集合并添加元素
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0,1,1,1,0));
        List<Integer> collect = list.stream().distinct().toList();

        // 要比较的int值
        Integer intValue = 0;

        // 使用Integer.valueOf()方法将int值包装为Integer对象，然后使用contains()方法进行比较
        if (collect.contains(intValue)) {
            System.out.println("Int value '" + intValue + "' is in the collection.");
        } else {
            System.out.println("Int value '" + intValue + "' is not in the collection.");
        }

        // 创建两个ArrayList集合并添加元素
        List<Integer> collection1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> collection2 = new ArrayList<>(Arrays.asList(3, 4));

        // 判断集合2中的所有int值是否都在集合1中
        boolean allInCollection1 = collection1.containsAll(collection2);



        // 输出结果
        if (allInCollection1) {
            System.out.println("All int values in collection2 are also in collection1.");
        } else {
            System.out.println("Not all int values in collection2 are in collection1.");
        }
    }
}
