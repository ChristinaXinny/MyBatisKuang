package com.lxy.dao;

import com.lxy.pojo.Student;

import java.util.List;

/**
 * @author ChristinaXinny
 * @create 2020-11-11 4:04 下午
 */
public interface StudentMapper {

//    查询所有学生的信息包括老师的名字
    public List<Student> getStu1();

//    getTeacher

    public List<Student> getStu2();

    public List<Student> getStu3();
    public List<Student> getStu4();

}
