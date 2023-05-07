package com.mybatis.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")

public class Dev {
    private Integer id;
    private String projectNo;
    private String deviceName;
    private String channel;
    private String deviceNo;
    private String storage;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String status;
}
