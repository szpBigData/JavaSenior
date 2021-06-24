package com.atguigu.java;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunzhipeng
 * @create 2021-06-05 10:49
 */
class Ticket{
    private int num=30;
    Lock lock=new ReentrantLock();
    public void sale(){
        lock.lock();
        try {
            if(num>0) {
                System.out.println(Thread.currentThread().getName() + "\t卖出第：" + (num--) + "\t 还剩下：" + num);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class SaleTicket {

    public static void main(String[] args) {
        Ticket  ticket=new Ticket();
        new Thread(()->{
            for (int i=0;i<10;i++){
                ticket.sale();
            }
        },"A").start();
        new Thread(()->{
            for (int i=0;i<10;i++){
                ticket.sale();
            }
        },"B").start();
        new Thread(()->{
            for (int i=0;i<10;i++){
                ticket.sale();
            }
        },"C").start();
    }
}
