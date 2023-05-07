package com.mybatis.controller;


import com.alibaba.fastjson2.JSON;
import com.mybatis.mapper.UserMapper;
import com.mybatis.pojo.Result;
import com.mybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080/", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

//登录界面中，向数据库中传输账号和密码
    //查找对应的数据
    @GetMapping("/userselect")
    private String userselect(Integer page,Integer pagesize ,
                                  @RequestParam(defaultValue = "") String userName,
                                  @RequestParam(defaultValue = "") String authority,
                                  @RequestParam(defaultValue = "") String status){


        Integer index = (page - 1) * pagesize;

        List<User> list = userMapper.select(index,pagesize,userName,authority,status);

        Integer count = userMapper.count(userName,authority,status);
        System.out.println(count);

        Result result = new Result(list,count);

        String reJson = JSON.toJSONString(result);

        System.out.println(reJson);
        return reJson;

    }

    @GetMapping("/selectname")
    private List<String> selectname(String authority,String status){

        List<String> list = userMapper.selectName(authority,status);

        return list;

    }

    @GetMapping("/userdelete")
    private void userdelete(@RequestParam("ids") List<Integer> ids){

        String strids = ids.toString();
        System.out.println("传入的参数为"+strids);
        userMapper.multidelete(ids);

    }


    @GetMapping("/userinsert")
    private void userinsert(String userName,String password,String userNo,String authority,String image,String status,String phone){

        userMapper.userinsert(userNo,userName,password,authority,image,status,phone);
        System.out.println("传入的参数为"+userName+password+userNo+authority+image+status+phone);

    }


    @GetMapping("/userupdate")
    private void update(Integer id,String password,String authority,String status,String phone){

        System.out.println("传入的参数为"+"密码："+password+",权限："+authority+",状态："+status+",电话："+phone);


        userMapper.userupdate(id,password,authority,status,phone);

    }

    @GetMapping("/dashusercount")
    private Integer count(){

       Integer count =  userMapper.usercount();
       return count;
    }



}
