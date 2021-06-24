package com.atguigu.java;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunzhipeng
 * @create 2021-06-05 12:56
 */
class ShareResource{
    private int num=1;
    Lock lock=new ReentrantLock();
    Condition condition1=lock.newCondition();
    Condition condition2=lock.newCondition();
    Condition condition3=lock.newCondition();
    public void print5(){
        lock.lock();
        try {
            //判断
            while (num!=1){
                condition1.await();
            }
            //干活
            for (int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            num=2;
            condition2.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print10(){
        lock.lock();
        try {
            //判断
            while (num!=2){
                condition2.await();
            }
            //干活
            for (int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            num=3;
            condition3.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print15(){
        lock.lock();
        try {
            //判断
            while (num!=3){
                condition3.await();
            }
            //干活
            for (int i=0;i<15;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            num=1;
            condition1.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class ThreadOrderAccess {
    public static void main(String[] args) {
        ShareResource shareResource=new ShareResource();
        new Thread(()->{
            shareResource.print5();
        },"A").start();
        new Thread(()->{
            shareResource.print10();
        },"B").start();
        new Thread(()->{
            shareResource.print15();
        },"C").start();



    }

}
