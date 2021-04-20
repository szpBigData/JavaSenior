package com.atguigu.java;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by YinHU on 2019-11-13.
 */
public class Test3 {
    public static void main(String[] args) {
     StringBuffer stringBuffer=new StringBuffer("helloworld");
     stringBuffer.setLength(30);
        System.out.println(stringBuffer);
        StringBuilder stringBuilder=new StringBuilder("HelloWorld");
        System.out.println(stringBuilder.insert(4,"SUNZHIPENG"));
//        stringBuffer.setLength(20);
//        System.out.println(stringBuilder);
//        System.out.println(stringBuilder.reverse());
//        stringBuffer.delete(0,5);
//        System.out.println(stringBuffer);
//        System.out.println(stringBuilder.deleteCharAt(6));
//        System.out.println(stringBuffer.append("hello"));
    }
}
