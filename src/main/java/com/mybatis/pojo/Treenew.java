package com.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Treenew {

    private Integer id;
    private String label;
    private Boolean isLeaf;

    private String lng;
    private String lat;

    private String level;
    private String objId;


}
