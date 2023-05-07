package com.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tree {
    private Integer id;
    private String label;
    private Boolean isLeaf;

    private String lng;
    private String lat;


//新增一个属性，用于前端的界面展示
//    用于区分节点是省/市/项目
//    省市的时候map的center是label即列表的值
    private String level;

//    private String objId;


}
