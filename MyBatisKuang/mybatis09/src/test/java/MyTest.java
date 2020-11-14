import com.lxy.dao.UserMapper;
import com.lxy.pojo.User;
import com.lxy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author ChristinaXinny
 * @create 2020-11-13 7:18 下午
 */
public class MyTest {

    @Test
    public void testFirst1() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectId(1);
        System.out.println(user);

        System.out.println("========================");
        User user1 = mapper.selectId(1);
        System.out.println(user1);

        System.out.println(user == user1);


        sqlSession.close();

    }

    //    缓存失效1  查询不同的数据
    @Test
    public void testFirst2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectId(1);
        System.out.println(user);

        System.out.println("========================");
        User user1 = mapper.selectId(2);
        System.out.println(user1);

        System.out.println(user == user1);


        sqlSession.close();

    }


    //    缓存失效2：  增删改操作 改变原来数据--》刷新缓存   在查询1和2 之间update了2的信息
    @Test
    public void testFirst3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectId(1);
        System.out.println(user);

        mapper.update(new User(2, "qqq", "3333"));

        System.out.println("========================");
        User user1 = mapper.selectId(2);
        System.out.println(user1);

        System.out.println(user == user1);


        sqlSession.close();

    }


//***********************二级缓存*************************************************


    @Test
    public void testSecond1() {


        SqlSession session = MybatisUtils.getSqlSession();
        SqlSession session2 = MybatisUtils.getSqlSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        UserMapper mapper2 = session2.getMapper(UserMapper.class);

        User user = mapper.selectId(1);
        System.out.println(user);
        session.close();

        User user2 = mapper2.selectId(1);
        System.out.println(user2);
        System.out.println(user==user2);

        session2.close();

//        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
//        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
//        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
//
//        User user = mapper1.selectId(1);
//        System.out.println(user);
//
//        sqlSession1.close();
//
//        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
//
//        User user1 = mapper2.selectId(1);
//        System.out.println(user1);
//
//
//        System.out.println("========================");
//
//
//        sqlSession2.close();

    }
}

