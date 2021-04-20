package com.atguigu.thread;


/**
 * Created by YinHU on 2019-11-15.
 */

class C extends Thread{
    public void run(){
        for(int i=0;i<=100;i++){
            if(i%2==0){
                System.out.println("我是线程C："+Thread.currentThread().getName()+"  "+i);
            }
        }
    }
}

class D implements Runnable{
    public void run(){
        for(int j=0;j<=100;j++){
            if(j%2!=0){
                System.out.println("我是编程D："+Thread.currentThread().getName()+"  "+j);
            }
        }
    }
}


public class Demo2 {
    public static void main(String[] args) {
        C c=new C();
        c.start();
        D d=new D();
        Thread thread =new Thread(d);
        thread.start();


    }

    
}
