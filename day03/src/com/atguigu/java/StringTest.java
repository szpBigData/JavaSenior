package com.atguigu.java;

/**
 * Created by YinHU on 2019-11-12.
 */
/*
    String:字符串，使用一对""引起来表示。
    1.String声明为final的，不可被继承
    2.String实现了Serializable接口：表示字符串是支持序列化的。
            实现了Comparable接口：表示String可以比较大小
    3.String内部定义了final char[] value用于存储字符串数据
    4.String:代表不可变的字符序列。简称：不可变性。
        体现：1.当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值。
             2. 当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。
             3. 当调用String的replace()方法修改指定字符或字符串时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。
    5.通过字面量的方式（区别于new）给一个字符串赋值，此时的字符串值声明在字符串常量池中。
    6.字符串常量池中是不会存储相同内容的字符串的。
  */

        /* 面试题：String s = new String("abc");方式创建对象，在内存中创建了几个对象？
             两个:一个是堆空间中new结构，另一个是char[]对应的常量池中的数据："abc"
         */
public class StringTest {
    public static void main(String[] args) {
        String s1="abc";
        String s2="abc";
       // s1="Hello";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1==s2);
        Person person =new Person("Tom",12);
        Person person1=new Person("Tom",12);
        System.out.println(person.name.equals(person1.name));



    }
}
