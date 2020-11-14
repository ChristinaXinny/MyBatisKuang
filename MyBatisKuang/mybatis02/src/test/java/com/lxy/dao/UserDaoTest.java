package com.lxy.dao;

import com.lxy.pojo.User;
import com.lxy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * @author ChristinaXinny
 * @create 2020-11-07 3:40 下午
 */
public class UserDaoTest {

    @Test
    public void test1GetUserList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

        userList.forEach(System.out::println);

        sqlSession.close();
    }







}










