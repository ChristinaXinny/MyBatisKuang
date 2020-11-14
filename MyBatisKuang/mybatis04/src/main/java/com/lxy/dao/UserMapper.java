package com.lxy.dao;

import com.lxy.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author ChristinaXinny
 * @create 2020-11-07 2:54 下午
 */
public interface UserMapper {

//    根据id查询用户
    User getUserById(int id);

//    分页
    List<User> getUserByLimit(Map<String, Integer> map);

}
