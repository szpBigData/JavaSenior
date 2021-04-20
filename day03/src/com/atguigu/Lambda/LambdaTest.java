package com.atguigu.Lambda;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by YinHU on 2019-11-25.
 */
class Ticket{
    private int ticket=100;
    private Lock lock=new ReentrantLock();

    public void buyTicket(){
        lock.lock();
        try{
            if (ticket>0) {
                ticket--;
                System.out.println(Thread.currentThread().getName() + "售出车票. " + "总计还有：" + ticket + "张票");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class LambdaTest{
    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        new Thread(()->{
            for(int i=1;i<=100;i++){
              ticket.buyTicket();
            }
        },"A").start();
        new Thread(()->{
            for(int i=1;i<=100;i++){
                ticket.buyTicket();
            }
        },"B").start();
    }
}