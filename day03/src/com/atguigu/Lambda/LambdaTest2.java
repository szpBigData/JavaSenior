package com.atguigu.Lambda;

/**
 * Created by YinHU on 2019-11-25.
 */

import org.junit.Test;

import java.util.Comparator;

/**
 * Lambda表达式的使用举例
 * 
 */
public class LambdaTest2 {
    @Test
    public void test(){
         Runnable r1=new Runnable() {
             @Override
             public void run() {
                 System.out.println("我爱北京天安门");
             }
         };
         r1.run();
        System.out.println("-----------------------------------");
        Runnable r2=()-> System.out.println("我爱北京故宫");
        r2.run();
    }
    @Test
    public void Test(){
        Comparator<Integer> com1=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        int compare1=com1.compare(12,21);
        System.out.println(compare1);
        System.out.println("********************");
        //lambda表达式的写法
        Comparator<Integer> com2=(o1,o2)->Integer.compare(o1,o2);
        int compare2=com2.compare(32,21);
        System.out.println(compare2);
        System.out.println("======================");
        Comparator<Integer> com3=Integer::compare;
       //----------------00 com3.compare()
    }

}
