package com.mybatis.controller;


import com.alibaba.fastjson2.JSON;
import com.mybatis.mapper.DevMapper;
import com.mybatis.pojo.Dev;
import com.mybatis.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080/", maxAge = 3600)
@RestController
public class DevController {

    @Autowired
    DevMapper devMapper;

    /*
    * 查找设备
    * */

    @GetMapping("/devselect")
    private String devselect(Integer page,Integer pagesize,String status,String projectNo){

        if(status.equals("未绑定")){
            projectNo="无";
        }

        Integer starter = (page - 1) * pagesize;

        List<Dev> list = devMapper.devselect(starter,pagesize,status,projectNo);

        Integer count = devMapper.count(status,projectNo);

        Result result = new Result(list,count);

        String reJson = JSON.toJSONString(result);

        return reJson;


    }

    /*
    * 修改设备信息
    *
    * */

    @GetMapping("/devupdate")
    private void devupdate(Integer id,String channel,String deviceName,String deviceNo,String storage,String status,String projectNo){

        //System.out.println("1");
        if(status.equals("未绑定")){
            projectNo="无";
            System.out.println("未绑定");
        }
        devMapper.devupdate(id,deviceName,channel,deviceNo,storage,status,projectNo);

    }

    /*
    * 插入设备
    *
    * */

    @GetMapping("/devinsert")
    private void devinsert(String channel,String deviceName,String deviceNo,String storage,String status,String projectNo){
        if(status.equals("未绑定")){
            projectNo="无";
            System.out.println("未绑定");
        }
        devMapper.devinsert(deviceName,channel,deviceNo,storage,status,projectNo);

    }


    /*
    * 多选删除
    * */
    @GetMapping("/devdelete")
    private void devdelete(@RequestParam("ids") List<Integer> ids){
        String strids = ids.toString();
        devMapper.devdelete(ids);
        System.out.println("传入的参数为"+strids);

    }

    /*
    *获取项目信息
    * 用于设备的绑定选择
    * */

    @GetMapping("/selectprojectNo")
    private List<String> selectprojectNo(){
        List<String> list = devMapper.selectprojectNo();
        return list;
    }


/*
* 获取设备数量
* 用于主页展示
*
* */

    @GetMapping("/dashdevcount")
    private Integer dashdevcount(){

        int count = devMapper.dashdevcount();
        System.out.println(count);

        return(count);

    }

    /*
    * 查找未被绑定的设备
    * 用于新建项目时绑定设备选择用
    *
    * */

    @GetMapping("/selectnotbound")
    private String selectnotbound(String status){

        List<Dev> list = devMapper.selectnotbound(status);

        String reJson = JSON.toJSONString(list);

        System.out.println(reJson);

        return reJson;

    }

//    @GetMapping("/devbound")
//    private void devbound(String deviceName,String status,String projectNo){
//
//        devMapper.devbound(deviceName,status,projectNo);
//
//    }
    @GetMapping("/devbound")
    private void devbound(Integer id,String projectNo){

        String status="已绑定";
        devMapper.devbound(id,status,projectNo);

        System.out.println(id);
        System.out.println(projectNo);

    }

}
