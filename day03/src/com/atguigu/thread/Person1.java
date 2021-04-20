package com.atguigu.thread;


/**
 * Created by YinHU on 2019-11-15.
 */
public class Person1 {
    public static void main(String[] args) {
           SUn sun=new SUn();
           Thread thread=new Thread(sun);
           thread.start();
    }
}
class SUn implements Runnable{
    public void run(){
        System.out.println("hahhahha");
    }
}
