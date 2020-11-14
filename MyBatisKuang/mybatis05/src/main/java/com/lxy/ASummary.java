package com.lxy;

/**
 * @author ChristinaXinny
 * @create 2020-11-07 3:33 下午
 */
/*
        #将等级为DEBUG的日志信息输出到console和file这两个目的地，console和file的
        # 定义在下面的代码
        log4j.rootLogger=DEBUG,console,file

        #控制台输出的相关设置
        log4j.appender.console = org.apache.log4j.ConsoleAppender
        log4j.appender.console.Target = System.out  【输出
        log4j.appender.console.Threshold=DEBUG      【debug格式】
        log4j.appender.console.layout = org.apache.log4j.PatternLayout
        log4j.appender.console.layout.ConversionPattern=[%c]-%m%n

        #文件输出的相关设置
        log4j.appender.file = org.apache.log4j.RollingFileAppender
        log4j.appender.file.File=./log/kuang.log        【文件生成地址
        log4j.appender.file.MaxFileSize=10mb        【超过10mb 生产新的文件
//        debug的格式
        log4j.appender.file.Threshold=DEBUG
        log4j.appender.file.layout=org.apache.log4j.PatternLayout
        log4j.appender.file.layout.ConversionPattern=[%p][%d{yy-MM-dd}][%c]%m%n

//如果是debug才输出
        #日志输出级别
        log4j.logger.org.mybatis=DEBUG
        log4j.logger.java.sql=DEBUG
        log4j.logger.java.sql.Statement=DEBUG
        log4j.logger.java.sql.ResultSet=DEBUG
        log4j.logger.java.sql.PreparedStatement=DEBUG


 */
public class ASummary {
}


