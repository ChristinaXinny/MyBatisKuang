package com.lxy.dao;

import com.lxy.pojo.User;
import com.lxy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * @author ChristinaXinny
 * @create 2020-11-07 3:40 下午
 */
public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);

    //    根据id查询用户
    @Test
    public void test2GetUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(2);

//        logger.info("info：进入selectUser方法");

        System.out.println(userById);


        sqlSession.close();
    }


//    日志log4j
    @Test
    public void testLog4j() {
//    logger.info("info：进入selectUser方法");
//    logger.debug("debug：进入selectUser方法");
//    logger.error("error: 进入selectUser方法");
//    Logger.info("info:");
        logger.info("info：进入selectUser方法");
        logger.debug("debug：进入selectUser方法");
        logger.error("error: 进入selectUser方法");


    }

//    limit分页
    @Test
    public void testLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex", 0);
        map.put("pageSize", 2);


        List<User> list = mapper.getUserByLimit(map);
        list.forEach(System.out::println);

        sqlSession.close();
    }
}










