package com.lxy.dao;

import com.lxy.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author ChristinaXinny
 * @create 2020-11-07 2:54 下午
 */
public interface UserMapper {


    @Select("select * from User")
    List<User> getUser() ;


//    传入两个参数   【有多个参数的时候一定要加上@Param】
//    @Param（xx）的'xx' 就是对应 #{xx}的'xx'
    @Select("select * from user where id = #{id} and name = #{name}")
    User getUserById(@Param("id") int id, @Param("name") String name);


//    插入
// #{password}离面是类内的属性名字
    @Insert("insert into user(id, name, pwd) values(#{id}, #{name}, #{password}) ")
    int addUser(User user);



//    更新
//    时刻谨记的#{}是类内的属性名字
    @Update("update user set name=#{name}, pwd=#{password} where id = #{id}")
    int upDate(User user);




//    删除
    @Delete("delete from user where id=#{id}")
    int deleteUser(@Param("id") int id);


}
