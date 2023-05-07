package com.mybatis.mapper;

import com.mybatis.pojo.Dev;
import com.mybatis.pojo.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DevMapper {


    public Integer count(String status,String projectNo);

    public List<Dev> devselect(Integer index,Integer pagesize,String status,String projectNo);


    public void devupdate(Integer id,String deviceName,String channel,String deviceNo,String storage,String status,String projectNo);


    public void devinsert(String deviceName,String channel,String deviceNo,String storage,String status,String projectNo);

    public void devdelete(List<Integer> ids);

    public List<String> selectprojectNo();

    public Integer dashdevcount();

    public List<Dev> selectnotbound(String status);

    public void devbound(Integer id, String status, String projectNo);

//    public void devbound(String deviceName,String status,String projectNo);




}
