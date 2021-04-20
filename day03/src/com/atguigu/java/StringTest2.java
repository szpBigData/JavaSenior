package com.atguigu.java;


import sun.applet.Main;

/**
 * Created by YinHU on 2019-11-12.
 */
public class StringTest2 {
    String str=new String("good");
    char[] ch={'t','e','s','t'};
    public void change(String str,char ch[]){
        str="test ok";
        ch[0]='b';
    }

    public static void main(String[] args) {
        StringTest2 ex=new StringTest2();
        ex.change(ex.str,ex.ch);
        System.out.println(ex.str);
        System.out.println(ex.ch);
    }
}
