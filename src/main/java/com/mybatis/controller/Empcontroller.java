package com.mybatis.controller;

import com.mybatis.mapper.EmpMapper;
import com.mybatis.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Empcontroller {

    @Autowired
    EmpMapper empMapper;

    @RequestMapping("/selectall")
    @ResponseBody
    private void selectall(){
        List<Emp> list = empMapper.selectAll();
        for (Emp emp: list)
        {
            System.out.println(emp);
        }
    }

    @RequestMapping("/selectbyid")
    @ResponseBody
    private void selectbyid(){
        Emp emp = empMapper.selectById(2);
        System.out.println(emp);
    }






}
