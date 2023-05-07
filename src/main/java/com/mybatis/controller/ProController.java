package com.mybatis.controller;

import com.alibaba.fastjson2.JSON;
import com.mybatis.mapper.ProMapper;
import com.mybatis.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080/", maxAge = 3600)
@RestController
public class ProController {

    @Autowired
    ProMapper proMapper;

    //Test OK
    @GetMapping("/proselect")
    private String proselect(Integer page, Integer pagesize,String manager,String status,String province,String city){

        //根据页码index换算出分页查询开始索引
        Integer starter = (page -1) * pagesize;
        List<Project> list = proMapper.proSelect(starter,pagesize,manager,status,province,city);

        int count = proMapper.proCount(manager,status,province,city);
        Result result= new Result(list,count);

        String reJson = JSON.toJSONString(result);
        System.out.println(reJson);
        return reJson;
    }
    /*
    * 获取项目列表
    * */
    @GetMapping("/prolist")
    private List<String> prolist(){

        List<String> list = proMapper.prolist();
        String reJson = JSON.toJSONString(list);
        System.out.println(reJson);
        return list;
    }

    @GetMapping("/proinsert")
    private void proinsert(String projectNo,String projectName,
                           @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startTime,
                           @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime finishTime,
                           String manager,String province,String city,String lng,String lat,String status)
    {
        proMapper.proInsert(projectNo,projectName,startTime,finishTime,manager,province,city,lng,lat,status);

        System.out.println();
        System.out.println("proInsert被调用了");


    }


    @GetMapping("/prodelete")
    private void prodelete(@RequestParam("ids") List<Integer> ids){

        String strids = ids.toString();
        proMapper.proDelete(ids);
        System.out.println("传入的参数为"+strids);

    }

    @GetMapping("/proupdate")
    private void proupdate(Integer id,String projectNo,String projectName,
                           @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startTime,
                           @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime finishTime,String manager,String status){

        System.out.println(finishTime);
        System.out.println(startTime);
        proMapper.proUpdate(id,projectNo,projectName,startTime,finishTime,manager,status);

    }

    @GetMapping("/selectprovince")
    private List<String> selectprovince(){

        List<String> list = proMapper.selectprovince();

        String reJson = JSON.toJSONString(list);

        System.out.println(reJson);

        return list;

    }


    @GetMapping("/selectcity")
    private List<String> selectcity(String province){

        List<String> list = proMapper.selectcity(province);

        String reJson = JSON.toJSONString(list);

        System.out.println(reJson);

        return list;

    }


    @GetMapping("/selectmanager")
    private List<String> selectmanager(){

        List<String> list = proMapper.selectmanager();
        String reJson = JSON.toJSONString(list);
        System.out.println("manager"+reJson);

        return list;

    }

    @GetMapping("/dashprocount")
    private Integer dashprocount(){

        int count = proMapper.dashprocount();
        System.out.println(count);

        return(count);

    }

//    @GetMapping("/dashproselect")
//    private String dashproselect(){
//
//        List<coordination> list = proMapper.coorselect();
//
//        System.out.println(list);
//
//        String reJson = JSON.toJSONString(list);
//
//        return(reJson);
//
//    }


    @GetMapping("/dashproselectall")
    private String dashproselectall(){

        List<Project> list = proMapper.selectall();

        System.out.println(list);

        String reJson = JSON.toJSONString(list);

        return(reJson);

    }

    @GetMapping("/province")
    private String province(){

        List<Children> list = proMapper.province();
        List<Tree> tree1 = new ArrayList<>();

        int id=1;
        Boolean Leaf=false;

        for (int i = 0; i < list.size(); i++) {

            String province =list.get(i).getProvince();
            Tree tree =new Tree(id++,province,Leaf,"","","province");
            tree1.add(tree);

        }

        String reJson1 = JSON.toJSONString(tree1);
        System.out.println(reJson1);
        return reJson1;

    }


    //传进来label和id 然后city id是province id+拼起来

    @GetMapping("/city")
    private String city(String province){

        List<Children> list = proMapper.city(province);
        System.out.println("list"+list);
        List<Tree> tree1 = new ArrayList<>();
        System.out.println("省份是"+province);
        int id=100;
        Boolean Leaf=false;
        for (int i = 0; i < list.size(); i++) {
            Tree tree =new Tree(id++,list.get(i).getCity(),Leaf,"","","city");
            tree1.add(tree);
        }

        String reJson1 = JSON.toJSONString(tree1);
        System.out.println(reJson1);
        return reJson1;
    }

    @GetMapping("/project")
    private String project(String city){

        List<Project> list = proMapper.project(city);
        List<Treenew> tree1 = new ArrayList<>();

        int id=1000;

        Boolean Leaf=false;
        for (int i = 0; i < list.size(); i++) {
            Treenew tree =new Treenew(id++,list.get(i).getProjectName(),Leaf,list.get(i).getLng(),list.get(i).getLat(),"project",list.get(i).getProjectNo());
            tree1.add(tree);
        }

        String reJson1 = JSON.toJSONString(tree1);
        System.out.println(reJson1);
        return reJson1;

    }

//        @GetMapping("/project")
//    private String project(String city){
//
//        List<Project> list = proMapper.project(city);
//        List<Tree> tree1 = new ArrayList<>();
//
//        int id=1000;
//
//        Boolean Leaf=false;
//        for (int i = 0; i < list.size(); i++) {
//            Tree tree =new Tree(id++,list.get(i).getProjectName(),Leaf,list.get(i).getLng(),list.get(i).getLat(),"project");
//            tree1.add(tree);
//        }
//
//        String reJson1 = JSON.toJSONString(tree1);
//        System.out.println(reJson1);
//        return reJson1;
//
//    }
//
//



}
