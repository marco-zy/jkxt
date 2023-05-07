package com.mybatis.controller;

import com.alibaba.fastjson2.JSON;
import com.mybatis.mapper.MissionMapper;
import com.mybatis.pojo.Mission;
import com.mybatis.pojo.Result;
import com.mybatis.pojo.Tree;
import com.mybatis.pojo.Treenew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080/", maxAge = 3600)
@RestController
public class MissController {

    @Autowired
    MissionMapper missionMapper;

    //1.地址怎么配的
    //2.怎么向前台传数据的
    //3.如何接收前台的数据

    @GetMapping("/missionselect")
    private String missionSelect(Integer page,Integer pagesize,
                                 @RequestParam(defaultValue = "") String executorName,
                                 @RequestParam(defaultValue = "") String createDepartment,
                                 @RequestParam(defaultValue = "") String status){

        //page表示第几页数据，everypage表示每页查询多少个
        //根据上面数据算出起始索引
        Integer starter = (page - 1) * pagesize;
        List<Mission> list = missionMapper.MissionSelect(starter,pagesize,executorName,createDepartment,status);
        int count = missionMapper.MissionCount(executorName,createDepartment,status);

        System.out.println(executorName);
        System.out.println(createDepartment);
        System.out.println("状态"+status);

        Result result = new Result(list,count);
        String reJson = JSON.toJSONString(result);

        System.out.println(reJson);
        return reJson;

    }

    @GetMapping("/update")
    private void update(Integer id, String status, String executor,
                        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime executeTime,
                        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime finishTime){

        System.out.println("传入的参数为"+id+","+status+","+executor+","+executeTime+","+finishTime);


        missionMapper.update(id,status,executor,executeTime,finishTime);
//        missionMapper.update(id,status,executorName);
    }


    @GetMapping("/multidelete")
    private void update(@RequestParam("ids") List<Integer> ids){

        String strids = ids.toString();
        missionMapper.multidelete(ids);
        System.out.println("传入的参数为"+strids);
    }

    @GetMapping("/missioninsert")
    private void insert(String missionNo,String projectId,String missionName,String createDepartment,String executor,
                        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime executeTime,
                        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime finishTime,
                        String status,String deviceId){

        missionMapper.insert(missionNo,projectId,missionName,createDepartment,executor,executeTime,finishTime,status,deviceId);

        System.out.println("传入的参数为"+"+"+missionNo+"+"+projectId+"+"+missionName+"+"+createDepartment+"+"
                +executor+"+"+executeTime+"+"+finishTime+"+"+status+"+"+deviceId);

    }

    @GetMapping("/selectdepartment")
    private List<String> selectdepartment(){

        List<String> list = missionMapper.selectdepartment();
        return list;
    }


    @GetMapping("/selectexecutor")
    private List<String> selectexecutor(){

        List<String> list = missionMapper.selectexecutor();
        return list;
    }

    @GetMapping("/dashmisscount")
    private Integer dashmisscount(){
        int count = missionMapper.dashmisscount();

        return count;
    }

    @GetMapping("/promission")
    private List<Treenew> promission(Integer projectId){

        List<Mission> list = missionMapper.promission(projectId);

        List<Treenew> tree1 = new ArrayList<>();

        String strlist = list.toString();

        System.out.println(strlist);


        int id=10000;

        Boolean Leaf=true;
        for (int i = 0; i < list.size(); i++) {
            Treenew tree =new Treenew(id++,list.get(i).getMissionName(),Leaf,"","","mission",list.get(i).getMissionNo());
            tree1.add(tree);
        }

        String reJson1 = JSON.toJSONString(tree1);
        System.out.println(reJson1);
        return tree1;

   }
//    @GetMapping("/promission")
//    private List<Mission> promission(Integer projectId){
//
//        List<Mission> list = missionMapper.promission(projectId);
//
//        List<Tree> tree1 = new ArrayList<>();
//
//        String strlist = list.toString();
//
//        System.out.println(strlist);
//
//
//        int id=1000;
//
//        Boolean Leaf=true;
//        for (int i = 0; i < list.size(); i++) {
//            Tree tree =new Tree(id++,list.get(i).getDeviceId(),Leaf,"","","mission");
//            tree1.add(tree);
//        }
//
//        String reJson1 = JSON.toJSONString(tree1);
//        System.out.println(reJson1);
//        return list;
//
//    }



}
