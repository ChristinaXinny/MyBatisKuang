package com.lxy.dao;


import com.lxy.pojo.User;
import com.lxy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

/**
 * @author ChristinaXinny
 * @create 2020-11-07 3:40 下午
 */
public class UserMapperTest {

    //查询全部user表
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = mapper.getUser();
        for (User user1 : user) {
            System.out.println(user1);
        }
        sqlSession.close();

    }

    //     insert
    @Test
    public void testInsert() {
//        这里的getSqlSession2是可以自动提交事务的
        SqlSession sqlSession = MybatisUtils.getSqlSession2();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.addUser(new User(22, "hello", "123wer"));
//所以这里不用 sqlSession.commit();
        sqlSession.close();

    }


//    update
    @Test
    public void testUpdate() {
        SqlSession sqlSession = MybatisUtils.getSqlSession2();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.upDate(new User(12, "update22", "111111"));
        sqlSession.close();

    }


    //    delete
    @Test
    public void testDelete() {
        SqlSession sqlSession = MybatisUtils.getSqlSession2();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(12);
        sqlSession.close();

    }


}










