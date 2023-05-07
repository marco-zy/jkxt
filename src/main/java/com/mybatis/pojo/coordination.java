package com.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class coordination {

    private String lng;
    private String lat;
    private String projectName;
    private Boolean showFlag = false;

}
