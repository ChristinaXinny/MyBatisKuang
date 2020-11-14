package com.lxy.dao;

import com.lxy.pojo.User;

/**
 * @author ChristinaXinny
 * @create 2020-11-13 7:15 下午
 */
public interface UserMapper {

    User selectId(int id);

    int update(User user);

}
