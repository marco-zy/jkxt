package com.mybatis.mapper;

import com.mybatis.pojo.Mission;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface MissionMapper {



    public List<Mission> MissionSelect(Integer index, Integer pagesize, String executorName, String createDepartment, String status);


    public int MissionCount(String executorName,String createDepartment,String status);



    public void multidelete(List<Integer> ids);

    //OK--改
    @Select("update mission set status = #{status} where id = #{id}")
    public void updateStatus(Integer id,String status);


    public void update(Integer id, String status, String executor,
                        LocalDateTime executeTime,
                        LocalDateTime finishTime);


    public void insert(String missionNo,String projectId,String missionName,String createDepartment,
                       String executor,LocalDateTime executeTime,LocalDateTime finishTime,
                       String status,String deviceId);


    public List<String> selectdepartment();


    public List<String> selectexecutor();


    public Integer dashmisscount();

    public List<Mission> promission(Integer projectId);

}
