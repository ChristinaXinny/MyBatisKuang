package com.lxy.dao;

import com.lxy.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author ChristinaXinny
 * @create 2020-11-11 4:04 下午
 */
public interface TeacherMapper {


    @Select("select * from teacher where id = #{id}")
    Teacher getTeaId(@Param("id") int id);

}
