package com.atguigu.thread;

/**
 * Created by YinHU on 2019-11-15.
 */

class MyThread2 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<=100;i++){
            if(i%2==0) {
                System.out.println(i);
            }
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        MyThread2 myThread=new MyThread2();
        myThread.start();
    }
}
