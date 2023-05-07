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
public class Project {

    private Integer id;
    private String projectNo;
    private String projectName;
    private String startTime;
    private String finishTime;
    private String manager;
    private String province;
    private String city;
    private String lng;
    private String lat;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String status;

}
