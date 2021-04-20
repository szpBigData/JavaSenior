package com.atguigu.java;

/**
 * Created by YinHU on 2019-11-13.
 */
public class TestTime {
    public static void main(String[] args) {
//		testStringBuilder();
        testStringBuffer();
//		testString();
    }
    public static void testString(){
        long start = System.currentTimeMillis();
        String s = new String("0");
        for(int i=1;i<=10000;i++){
            s += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("String拼接+用时："+(end-start));//444

        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("String拼接+memory占用内存: " + memory);//53185144字节
    }
    public static void testStringBuilder(){
        long start = System.currentTimeMillis();
        StringBuilder s = new StringBuilder("0");
        for(int i=1;i<=10000;i++){
            s.append(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder拼接+用时："+(end-start));//4
        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("StringBuilder拼接+memory占用内存: " + memory);//1950488
    }
    public static void testStringBuffer(){
        long start = System.currentTimeMillis();
        StringBuffer s = new StringBuffer("0");
        for(int i=1;i<=10000;i++){
            s.append(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuffer拼接+用时："+(end-start));//7
        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("StringBuffer拼接+memory占用内存: " + memory);//1950488
    }
}
