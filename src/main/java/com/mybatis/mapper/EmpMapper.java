package com.mybatis.mapper;


import com.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    @Delete("delete from emp where id = #{id}")
    public void delete(Integer ID);

    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) values" +
           " (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);


//    @Select("select * from emp where id = #{id}")
//    实体类的属性名要与表格中的字段名保持一致
//    若有下划线要打开驼峰命名匹配
    public Emp selectById(Integer id);


    @Select("select * from emp")
    public List<Emp> selectAll();


    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);






}
