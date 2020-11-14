package com.lxy.dao;

import com.lxy.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author ChristinaXinny
 * @create 2020-11-13 10:44 上午
 */
public interface BlogMapper {



//insert
    int addBlog(Blog blog);


//    if标签
    List<Blog> selectBlogIF(Map map);


//    where标签
    List<Blog> selectBlogWhere(Map map);



//    when标签
    List<Blog> selectBlogWhen(Map map);



//    set标签
    int updateBlogSet(Map map);


//    choose
    List<Blog> selectBlogChoose(Map map);


//sql
    List<Blog> selectBlogSql(Map map);


//    foreach
    List<Blog> selectBlogFor(Map map);

}
