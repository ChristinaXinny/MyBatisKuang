package com.lxy.dao;

import com.lxy.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ChristinaXinny
 * @create 2020-11-11 4:04 下午
 */
public interface TeacherMapper {


    List<Teacher> getTeacher();



    //获取指定老师，及老师下的所有学生【结果查询】
    Teacher getTeacherStu1(@Param("tid") int id);


    //获取指定老师，及老师下的所有学生【子查询】
    Teacher getTeacherStu2(@Param("tid") int id);



}
