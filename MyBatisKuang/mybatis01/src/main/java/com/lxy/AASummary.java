package lxy;

/**
 * @author ChristinaXinny
 * @create 2020-11-09 5:47 下午
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


//-----------------------MybatisUtils.java---------------------------------------
/*

    这个是一个mybatis的工具类
    为之后的mybatis的sql语句的摄取进行类封装
    里面实现的是一个sql语句制造工厂的建立
    这个是从官方文档上导出的
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        1。分别是加载一个配置文件mybatis-config.xml
            配置mysql
        2。把这个配置文件放到流里面 为了下一步的加载
        3。sql语句工厂 = new sql语句工厂的建造者。建造（mybatis-config.xml配置文件）
            【（。。。）里面是这个工厂的设计图】



     //获取SqlSession连接
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
    调用一个函数去从sql语句工厂中获取一个sql语句者


*/





//--------------------------一个表的4个部分---------------------------------------
/*

    一个数据库的表 ----- 一个java类
    UserMapper 接口     定义操作方法的一个接口 用于规范后面  也是一个操作的目录
    UserMapper xml文件   对sql语句的编写
    UserMapperTest     对UserMapper的xml文件和接口的结合调用

*/






//--------------------------xxxMapper.java【接口】---------------------------------------
/*

//    查询全部用户
    List<User> getUserList();

//    根据id查询用户
    User getUserById(int id);

//    插入
    int addUser(User u);

//    修改
    int updateUser(User u);

//    删除
    void deleteUser(int id);




 */



//--------------------------xxxMapper.xml【转换】---------------------------------------
/*


    namespace绑定一个Dao/Mapper接口
        <mapper namespace="com.lxy.dao.UserMapper">

    ·············
    查询List<User> getUserList();
        <select id="getUserList" resultType="com.lxy.pojo.User">
            select * from mybatisKuang.user
        </select>
    id： 接口函数的名字
    resultType返回类型


    ·············
    插入 int addUser(User u);
        <insert id="addUser" parameterType="com.lxy.pojo.User">
            insert into mybatisKuang.user(id, name, pwd) values(#{id}, #{name}, #{pwd})
        </insert>
    parameterType 传入参数
    (id, name, pwd) ：数据库每列的列头名
     (#{id}, #{name}, #{pwd}) ： 对应表类的属性名字



    ·············
    map



    ·············
    模糊查询
    List<User> getUserLike(String value);
    <select id="getUserLike" resultType="com.lxy.pojo.User">
        select * from mybatisKuang.user where name like "%"#{value}"%";
    </select>
    List<User> list = mapper.getUserLike("%w%");







 */





//--------------------------xxxMapperTest.java---------------------------------------
/*
    @Test
    public void test() {
    1。
        SqlSession sqlSession = MybatisUtils.getSqlSession();

    2。
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    3。
        ...

    4。
        sqlSession.commit();

    5。
        sqlSession.close();
    }


    1。先从MybatisUtils工具类中调用出sql语句控制者
    2。之后得到的sql控制者。get一个mapper【映射器; 映射对象; 映像器; 映射程序; 变换器】
    3。通过调用接口的函数 从后台传递参数到数据库  数据库返回值到后台
    4。sql语句的提交
    5。sql语句的关闭【世纪是返还给sql语句工厂】


 */





public class AASummary {
}
