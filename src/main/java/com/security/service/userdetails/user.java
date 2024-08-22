package com.security.service.userdetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class user {
    private String userName;

    private String passWrod;
}
