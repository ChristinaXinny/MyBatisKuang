import com.lxy.dao.StudentMapper;
import com.lxy.dao.TeacherMapper;
import com.lxy.pojo.Student;
import com.lxy.pojo.Teacher;
import com.lxy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author ChristinaXinny
 * @create 2020-11-11 7:57 下午
 */
public class TestOneToMore {

    @Test
    public void test01(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);


        sqlSession.close();

    }


    @Test
    public void testGetStudents1(){
        SqlSession session = MybatisUtils.getSqlSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        List<Student> students = mapper.getStu1();

        for (Student student : students){
            System.out.println(student);
        }
    }

    @Test
    public void testGetStudents2(){
        SqlSession session = MybatisUtils.getSqlSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        List<Student> students = mapper.getStu2();

        for (Student student : students){
            System.out.println(student);
        }
    }

    @Test
    public void testGetStudents3() {
        SqlSession session = MybatisUtils.getSqlSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        List<Student> students = mapper.getStu3();

        for (Student student : students) {
            System.out.println(student);
        }
    }
 @Test
    public void testGetStudents4() {
        SqlSession session = MybatisUtils.getSqlSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        List<Student> students = mapper.getStu4();

        for (Student student : students) {
            System.out.println(student);
        }
    }

}
