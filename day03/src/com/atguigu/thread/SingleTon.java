package com.atguigu.thread;

/**
 * Created by YinHU on 2019-11-15.
 */
public class SingleTon {
    private SingleTon(){}
    private static SingleTon singleTon=new SingleTon();
    public static SingleTon getSingle(){
        System.out.println("这是单例模式");
        return singleTon;

    }
}
