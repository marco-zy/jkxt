package com.mybatis.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor


@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
public class Mission {

    private Integer id;
    private String missionNo;
    private String projectId;
    private String missionName;
    private String createDepartment;
    private String executor;
    private LocalDateTime executeTime;
    private LocalDateTime finishTime;
    private String status;
    private String deviceId;//一个任务一个设备
    private String createTime;
    private String updateTime;

}
