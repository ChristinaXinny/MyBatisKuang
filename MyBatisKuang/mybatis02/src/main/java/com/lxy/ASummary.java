package com.lxy;

/**
 * @author ChristinaXinny
 * @create 2020-11-07 3:33 下午
 */

/*

配置讲解

1。配置文件
2。配置环境讲解 <environments>
3。属性  <properties>
4。类型别名   <typeAliases>

 */




/*




 */

/*

    <environments default="development">
default： 选那个环境
        <environment id="development">
            <transactionManager type="JDBC"/>
transactionManager ：有两种
            <dataSource type="POOLED">
dataSource ： 有三种
                <property name="driver" value="${driver}"/>
                <property name="url" value="${url}"/>
                <property name="username" value="${username}"/>
                <property name="password" value="${password}"/>
            </dataSource>
        </environment>
    </environments>



 */


/*
选择外部properties
        <properties resource="db.properties">
内部配置property
            <property name="username" value="root"/>
            <property name="pwd" value="11111"/>
         </properties>

优先级： 外》内


*/


/*
1.
可以给实体类其别名
    <typeAliases>
        <typeAlias type="com.lxy.pojo.User"/>
    </typeAliases>

    <select id="getUserList" resultType="User">

2.
定位到实体类上层的包 其别名
    <typeAliases>
        <package name="com.lxy.pojo"/>
    </typeAliases>
    <select id="getUserList" resultType="User">

其别名之后UserMapper.xml的parameterType/resultType="com.lxy.pojo.User"----->"User"

3.
@Alias("hello")
public class User {}
        <select id="getUserList" resultType="hello">



 */
public class ASummary {
}


