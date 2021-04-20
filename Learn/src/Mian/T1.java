package Mian;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunzhipeng
 * @create 2020-05-21 19:26
 * 判断 通知 干活
 */
class Resource{
    private int num=1;
    private int count=1;
    Lock lock=new ReentrantLock();
    Condition condition1=lock.newCondition();
    Condition condition2=lock.newCondition();
    public void print52(){
        lock.lock();
        try {
            while (num!=1){
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+"\t"+(2*count-1));
            System.out.println(Thread.currentThread().getName()+"\t"+(2*count));
            num=2;
            condition2.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void printAZ(){
        lock.lock();
        try {
            while (num!=2){
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+"\t"+(char)(count-1+'A'));
            count++;
            num=1;
            condition1.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class T1 {
    public static void main(String[] args) {
        Resource resource=new Resource();
       new Thread(()->{
           for (int i=1;i<=26;i++){
               resource.print52();
           }
       },"A").start();
       new Thread(()->{
           for (int i=1;i<=26;i++){
               resource.printAZ();
           }
       },"B").start();
    }
}
