package com.mybatis.mapper;

import com.mybatis.pojo.Children;
import com.mybatis.pojo.Project;
import com.mybatis.pojo.coordination;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ProMapper {



    public List<Project> proSelect(Integer index, Integer pagesize, String manager, String status,String province,String city);

    public List<String> prolist();

    //public Integer procount(String manager, String status,String province,String city);


    //public Integer proCount(String manager, Integer status);

    public Integer proCount(String manager, String status,String province,String city);


    public void proInsert(String projectNo, String projectName,LocalDateTime startTime, LocalDateTime finishTime,
                          String manager,String province,String city,String lng,String lat,String status);


    public void proUpdate(Integer id,String projectNo,String projectName,LocalDateTime startTime, LocalDateTime finishTime,String manager,String status);


    public void proDelete(List<Integer> ids);


    public List<String> selectprovince();

    public List<String> selectcity(String province);

    public List<String> selectmanager();


    public int dashprocount();

    public List<coordination> coorselect();

    public List<Children> province();

    public List<Children> city(String province);

    public List<Project> project(String city);

    public  List<Project> selectall();



}
