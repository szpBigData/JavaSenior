package com.atguigu.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by YinHU on 2019-11-15.
 */

class A extends Thread{
    public void run(){
        System.out.println("你好，孙志鹏");
    }

}
class B implements Runnable{
    public void run(){
        System.out.println("你好，杨晓宇");
    }
}

class Ticket{
    private int ticket=100;
    Lock lock=new ReentrantLock();
    public void sale(){
        lock.lock();
        try {
            if(ticket>0){
                System.out.println(Thread.currentThread().getName()+"\t卖出："+(ticket--)+"\t 还剩下："+ticket);
            }
        }   catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
public class Demo1{
    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        new Thread(()->{for(int i=0;i<=100;i++){ticket.sale();}},"A").start();
        new Thread(()->{for(int i=0;i<=100;i++){ticket.sale();}},"B").start();
        new Thread(()->{for(int i=0;i<=100;i++){ticket.sale();}},"C").start();

        A a=new A();
        a.start();
         B b=new B();
        Thread thread =new Thread(b);
        thread.start();

    }
}
