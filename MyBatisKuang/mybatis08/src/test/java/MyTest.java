import com.lxy.dao.BlogMapper;
import com.lxy.pojo.Blog;
import com.lxy.utils.IDutils;
import com.lxy.utils.MybatisUtils;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

/**
 * @author ChristinaXinny
 * @create 2020-11-13 12:04 下午
 */
public class MyTest {

//    初始化
    @Test
    public void addInitBlog(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDutils.getRandomId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDutils.getRandomId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDutils.getRandomId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDutils.getRandomId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        session.commit();

        session.close();
    }


//    查询if   【当map为空的时候 也可以查询出】
    @Test
    public void teat2If(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap hashMap = new HashMap();

//        hashMap.put("title", "Java如此简单");

//        hashMap.put("author", "kk");

        hashMap.put("title", "Java如此简单");
        hashMap.put("author", "kk");

        List<Blog> blogs = mapper.selectBlogIF(hashMap);


        blogs.forEach(System.out::println);


        sqlSession.close();

    }



//    查询if --lxy 从控制台输入语句进行查询  【当map为空的时候 也可以查询出】
    @Test
    public void teat3Iflxy(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap hashMap = new HashMap();

        Scanner in = new Scanner(System.in);

        String author = in.nextLine();

//        hashMap.put("title", "Java如此简单");


//        hashMap.put("author", "kk");


        hashMap.put("title", "Java如此简单");
        hashMap.put("author", "kk");

        List<Blog> blogs = mapper.selectBlogIF(hashMap);


        blogs.forEach(System.out::println);


        sqlSession.close();

    }



//   <where>标签queryBlogWhere接口方法
    @Test
    public void teat4Where(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap hashMap = new HashMap();

//1。title   2。author    3。title + author     4。空map
//        hashMap.put("title", "Java如此简单");
//        hashMap.put("author", "kk");

        List<Blog> blogs = mapper.selectBlogWhere(hashMap);


        blogs.forEach(System.out::println);


        sqlSession.close();

    }



//   <when>标签queryBlogWhen接口方法
    @Test
    public void teat4When(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap hashMap = new HashMap();

//1。title   2。author    3。title + author     4。空map
//        hashMap.put("title", "Java如此简单");
//        hashMap.put("author", "kk");

        List<Blog> blogs = mapper.selectBlogWhen(hashMap);


        blogs.forEach(System.out::println);


        sqlSession.close();

    }



//    set
    @Test
    public void testUpdateBlogSet(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("title","动态SQL");
        map.put("author","秦疆");
        map.put("id","9d6a763f5e1347cebda43e2a32687a77");

        mapper.updateBlogSet(map);


        session.close();
    }


//choose
    @Test
    public void testSelectBlogChoose(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title","Java如此简单");
        map.put("author","狂神说");
        map.put("views",9999);
        List<Blog> blogs = mapper.selectBlogChoose(map);

        System.out.println(blogs);

        session.close();
    }



// sql
    @Test
    public void teatSql(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap hashMap = new HashMap();

//        hashMap.put("title", "Java如此简单");

//        hashMap.put("author", "kk");

        hashMap.put("title", "Java如此简单");
        hashMap.put("author", "kk");

        List<Blog> blogs = mapper.selectBlogSql(hashMap);


        blogs.forEach(System.out::println);


        sqlSession.close();

    }



    @Test
    public void testFor(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        map.put("ids", list);
        List<Blog> blogs = mapper.selectBlogFor(map);

        System.out.println(blogs);

        sqlSession.commit();

        sqlSession.close();
    }






}
