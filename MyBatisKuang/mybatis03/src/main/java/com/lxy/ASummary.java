package com.lxy;

/**
 * @author ChristinaXinny
 * @create 2020-11-07 3:33 下午
 */

/*


流程：
1.utils : MybatisUtils.java
2.resources : mybatis-config.xml
3.pojo/bean : User
4.dao : UserMapper
5.resources.dao : UserMapper.xml
6.test : UserDaoTest
7.maven

*/




    /*
    每一个表对应一个类、接口、接口mapper。xml文件、test文件
     */


    /*
    万能map
在mapper的#{...} 可以是任何字符 不一定要匹配user类里面的属性
insert into user (id, name, pwd) values(#{userid}, #{userName}, #{Password})


<update id="updateUser" parameterType="com.lxy.pojo.User">
        update mybatisKuang.user set name = #{name}, pwd=#{pwd} where id=#{id};
    </update>
    普通的#{}中一定是匹配user类的属性名字

    这样使用map 可以实现类对象与my代码的分离

    同时 如果是要inser一个新的数据
    就要在test中new一个user的对象
    map可以不用new对象
    同时 map可以随意选择要inser几个数据



     */

/*
UserMapper.xml:

<update id="update" parameterType="com.lxy.pojo.User">
        update mybatisKuang.user set name = #{name}, pwd=#{pwd} where id=#{id};
    </update>
#{pwd} pwd 是user类里面的属性名字
name = #{name}
数据库列表里每一列的名字 = #{类对象的属性名字}



接口里面的操作函数名字
 List<User> getUserList();
对应mapper。xml的
 <select id="getUserById" parameterType="int" resultType="com.lxy.pojo.User">
    select * from mybatisKuang.user where id = #{id}
</select>
id： 接口是函数名字
parameterType： 对应传入的类型
resultType： 返回的类型
sql语句中的表 要写全名

每次添加一个操作现在接口里面添加对应函数
之后在mapper的xml文件中添加对应的sql语句


*/





/*




MybatisUtils.java：被迫需要一个配置文件-----mybatis-config.xml
mybatis-config.xml : 环境准备
User : 实体类
UserDao : 接口
UserMapper.xml : 连接接口



之后的运行中 只用改UserMapper、UserMapper.xml、UserDaoTest



 */


/*
UserMapper.xml

这个是mybatis的核心文件
主要就是学习里面的《select resultType = "。。。"  parameterType = "。。。"  。。。》
 */

/*
DAO(Data Access Object) 【数据访问对象】这是一个面向对象的数据库接口

Dao接口：
public interface UserDao {
    List<User> getUserList();
}

以前实现接口用到接口实现类
接口实现类UserDaoImpl：【.java】
在之后：
要转变成UserMapper配置文件【.xml】

注意
绑定的接口名字
查询的方法名字
返回的结果集

*/


//    二测试
/*

org.apache.ibatis.binding.BindingException: Type interface com.lxy.dao.UserDao is not known to the MapperRegistry.
MapperRegistry----mapper注册


The error may exist in com/lxy/dao/userMapper.xml




 */


/*
src/main/resources/mybatis-config.xml



<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<!--核心配置文件-->
<configuration>

<environments default="development">
<environment id="development">
<!--事务管理-->
<transactionManager type="JDBC"/>
<dataSource type="POOLED">
<property name="driver" value="com.mysql.jdbc.Driver"/>
<property name="url"
        value="jdbc:mysql://localhost:3306/mybatis?useSSL=false&amp;useUnicode=true&amp;characterEncoding=UTF8"/>
<!--                useSSL=true：安全连接-->
<property name="username" value="root"/>
<property name="password" value="qwe123123"/>
</dataSource>
</environment>
</environments>

<!--    每一个mapper.xml都要在mybatis核心配置文件中注册-->

<mappers>
<mapper resource="userMapper.xml"/>
</mappers>

</configuration>

*/


    /*

    <?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <!--父工程-->
    <groupId>org.example</groupId>
    <artifactId>MyBatis01</artifactId>
    <packaging>pom</packaging>
    <version>1.0-SNAPSHOT</version>


    <modules>
        <module>mybts01</module>
    </modules>

    <!--导入依赖-->
    <dependencies>

<!--mysql驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.22</version>
        </dependency>


<!--mybatis-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.6</version>
        </dependency>


<!--junit-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.11</version>

        </dependency>

    </dependencies>

*/





    /*



  <?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!--namespace绑定一个Dao/Mapper接口-->

<!--这里的实现内容和UserDaoImpl的接口实现类一样的步骤-->
<!--先是UserDaoImpl实现类一开始先implements UserDao继承类一个接口======对应这里的namespace="com.lxy.dao.UserDao"-->
<mapper namespace="com.lxy.dao.UserMapper">

    <!--    UserDaoImpl里面继承接口的方法=======这里的select语句-->
    <select id="getUserList" resultType="com.lxy.pojo.User">

-- resultType 和 resultMap比较常用 最多用的是resultType【返回结果集
-- resultType="com.lxy.pojo.User"   就是结果集==== UserDaoImpl里面返回的List《User》【注意要写《》里面的泛型
-- 这里是sql语句的编写处【看看注释的格式就知道

        select * from mybatisKuang.user



   </select>
</mapper>


     */
public class ASummary {
}




/*



    <!--查询语句-->
    <select id="getUserList" resultType="com.lxy.pojo.User">
        select * from user
   </select>

    <!--    <select id="getUserById" parameterType="int" resultType="com.lxy.pojo.User">
           select * from mybatisKuang.user where id = #{id}
        </select> -->

    <select id="getUserById" parameterType="int" resultType="com.lxy.pojo.User">
        select * from user where id = #{id};
    </select>

    <insert id="addUser" parameterType="com.lxy.pojo.User">
        insert into mybatisKuang.user (id, name, pwd) value (#{id}, #{name}, #{pwd}) ;
    </insert>



    <!--    #{name}-->
    <update id="updateUser" parameterType="com.lxy.pojo.User">
        update mybatisKuang.user set name = #{name}, pwd=#{pwd} where id=#{id};
    </update>



    <delete id="deleteUser" parameterType="int">
        delete from mybatis.user where id = #{id};
    </delete>




<!--    万能map      -->
    <select id="addUserMap" parameterType="map" resultType="int">
        insert into user (id, name, pwd) values(#{userid}, #{userName}, #{Password})
    </select>
<!--    万能map 可以随意选择输入数据库的几个数据   只要和前面相匹配 -->
    <select id="addUserMap" parameterType="map" resultType="int">
        insert into user (id,  pwd) values(#{userid},  #{Password})
    </select>





 */

