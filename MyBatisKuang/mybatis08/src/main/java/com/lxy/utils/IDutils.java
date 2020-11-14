package com.lxy.utils;

import com.sun.javafx.binding.StringFormatter;
import org.junit.Test;

import java.util.UUID;

/**
 * @author ChristinaXinny
 * @create 2020-11-13 10:55 上午
 */

@SuppressWarnings("all")//抑制警告
public class IDutils {

//    获取一个随机的id
    public static String getRandomId(){
//        return UUID.randomUUID().toString();
//2a527633-2a6e-4850-892a-83604717ebe0


        return UUID.randomUUID().toString().replaceAll("-", "");
//00951563655c414c814e86c5747e7b49
//e7268d98637f419c871ad3212d2d76b4
//20b7499ff2e74a9584ab7e30d3d1cc70
//cc25a87e118f4c9db52b0286deda0810

    }


//    测试
    @Test
    public void test1(){
        System.out.println(IDutils.getRandomId());
        System.out.println(IDutils.getRandomId());
        System.out.println(IDutils.getRandomId());
        System.out.println(IDutils.getRandomId());

    }
}
