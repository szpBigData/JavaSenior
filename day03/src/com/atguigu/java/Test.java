package com.atguigu.java;

/**
 * Created by YinHU on 2019-11-13.
 */
 class MyThread extends Thread {
    public void run(){
        for(int i=0;i<=100;i++){
            if(i%2==0){
                System.out.print(i+" ");
                System.out.println("-----");
            }
        }
    }
}
class SeRunnable implements Runnable{
    public void run(){
        for(int i=0;i<=100;i++){
            if(i%2!=0){
                System.out.print(i+" ");
                System.out.println("#######");
            }
        }
    }
}
public class Test{
    public static void main(String[] args) {
              MyThread myThread=new MyThread();
              myThread.start();
              SeRunnable seRunnable =new SeRunnable();
              Thread thread=new Thread(seRunnable);
              thread.start();
    }
}