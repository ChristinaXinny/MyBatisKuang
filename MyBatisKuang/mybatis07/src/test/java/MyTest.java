import com.lxy.dao.TeacherMapper;
import com.lxy.pojo.Teacher;
import com.lxy.utils.MybatisUtils;
import javafx.application.Application;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author ChristinaXinny
 * @create 2020-11-11 10:32 下午
 */
public class MyTest {

    //    获取老师
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teacher = mapper.getTeacher();
        teacher.forEach(System.out::println);
        sqlSession.close();

    }


    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacherStu = mapper.getTeacherStu1(1);
        System.out.println(teacherStu);
        sqlSession.close();

        /*
        Teacher{
        id=1, name='秦老师', students=[
            Student{id=1, name='小明', tid=1},
            Student{id=2, name='小红', tid=1},
            Student{id=3, name='小张', tid=1},
            Student{id=4, name='小李', tid=1},
            Student{id=5, name='小王', tid=1}
        ]}

         */

    }


    //    子查询
    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacherStu = mapper.getTeacherStu2(1);
        System.out.println(teacherStu);
        sqlSession.close();

        /*

         */

    }


}
