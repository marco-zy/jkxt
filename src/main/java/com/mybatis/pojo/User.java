package com.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;
    private String userName;
    private String password;
    private String userNo;
    private String authority;
    private String image;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String status;
    private String phone;


}
