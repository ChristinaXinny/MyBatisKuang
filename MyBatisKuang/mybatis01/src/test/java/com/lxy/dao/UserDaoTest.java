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
//        获取sqlSession的对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

//        执行sql
//        想要执行dao就要拿到dao【dao=mapper】的文件
//        要么从UserDaoImpl sql接口实现类里面拿 要么就从UserMapper.xml拿
//        UserDaoImpl实现UserDao接口的类  UserMapper.xml是绑定了UserDao接口的文件
        lxy.dao.UserMapper mapper = sqlSession.getMapper(lxy.dao.UserMapper.class);
        List<User> userList = mapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
//            mapper.addUser()


        }

//        关闭sqlSession
        sqlSession.close();
    }

    //    根据id查询用户
    @Test
    public void test2GetUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        lxy.dao.UserMapper mapper = sqlSession.getMapper(lxy.dao.UserMapper.class);
        User userById = mapper.getUserById(1);

        System.out.println(userById);


        sqlSession.close();
    }


//    增删改查需要提交事务
    @Test
    public void test3AddUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        lxy.dao.UserMapper mapper = sqlSession.getMapper(lxy.dao.UserMapper.class);
        int res = mapper.addUser(new User(35, "hh", "1231sdad"));
        if (res > 0) {
            System.out.println("add success");
        }

//        提交事务
        sqlSession.commit();

        sqlSession.close();
    }


//    更改需要提交事务
    @Test
    public void test4UpdateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        lxy.dao.UserMapper mapper = sqlSession.getMapper(lxy.dao.UserMapper.class);


        int cg = mapper.updateUser(new User(2, "www", "123123"));
        System.out.println(cg);


//        提交事务
        sqlSession.commit();

        sqlSession.close();
    }



//    模版
    @Test
    public void testMoBan() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        lxy.dao.UserMapper mapper = sqlSession.getMapper(lxy.dao.UserMapper.class);

//        ...



//        提交事务
        sqlSession.commit();

        sqlSession.close();
    }



//    万能map查询 int addUserMap(Map<String, Object> map);
    @Test
    public void testMap() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        lxy.dao.UserMapper mapper = sqlSession.getMapper(lxy.dao.UserMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("userid", 11);
        map.put("userName", "hello");
        map.put("Password", "123qwq");

        mapper.addUserMap2(map);

//        提交事务
        sqlSession.commit();

        sqlSession.close();
    }



//    万能map查询 int addUserMap(Map<String, Object> map);
    @Test
    public void testMap2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        lxy.dao.UserMapper mapper = sqlSession.getMapper(lxy.dao.UserMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("userid", 11);
//        map.put("userName", "hello");
        map.put("Password", "123qwq");

        mapper.addUserMap(map);

//        提交事务
        sqlSession.commit();

        sqlSession.close();
    }





//    模糊查询
    @Test
    public void testMoHu() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        lxy.dao.UserMapper mapper = sqlSession.getMapper(lxy.dao.UserMapper.class);

//        ...



//        提交事务
        sqlSession.commit();

        sqlSession.close();
    }




    //    查询like用户 List<User> getUserLike();
    @Test
    public void testLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        lxy.dao.UserMapper mapper = sqlSession.getMapper(lxy.dao.UserMapper.class);

        List<User> list = mapper.getUserLike("%w%");

        list.forEach(System.out::println);

        sqlSession.commit();
        sqlSession.close();


    }





}










