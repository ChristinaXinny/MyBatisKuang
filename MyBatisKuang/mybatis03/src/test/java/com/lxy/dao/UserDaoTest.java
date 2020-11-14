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

    //    根据id查询用户
    @Test
    public void test2GetUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(2);

        System.out.println(userById);


        sqlSession.close();
    }



}










