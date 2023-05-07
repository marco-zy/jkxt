package com.mybatis.mapper;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    public List<User> select(Integer index,Integer pagesize,String userName,String authority,String status);

    public Integer count(String userName, String authority, String status);

    public List<String> selectName(String authority,String status);

    public void multidelete(List<Integer> ids);

    public void userinsert(String userName,String password,String userNo,String authority,String image,String status,String phone);

    public void userupdate(Integer id,String password,String authority,String status,String phone);

    public Integer usercount();
}
