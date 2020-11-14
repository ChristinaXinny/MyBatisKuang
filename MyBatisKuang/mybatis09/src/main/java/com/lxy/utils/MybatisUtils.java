package com.lxy.utils;//package lxy.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/*

这里这个是一个sql的语句制造的工厂
resource 获取到的是一个 连接sql数据库的配置文件
把这个配置文件运行之后获得到一个来自数据库数据到流
工厂到建造者FactoryBuilder拿了这个流去建造build这个工厂Factory
最后这个工厂有一个出口给各个不同的地方 每个一个sql语句sqlSessionFactory.openSession()



 */

//工具类
//sqlSessionFactory
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
//            使用mybatis第一步：获取SqlSessionFactory对象
            String resource = "mybatis-config.xml";
//            采用流将加载进来
            InputStream inputStream = Resources.getResourceAsStream(resource);
//            通过builder把流加载进来
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //获取SqlSession连接
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(true);
    }



}
