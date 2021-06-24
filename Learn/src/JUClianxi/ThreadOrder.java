package JUClianxi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunzhipeng
 * @create 2021-05-11 10:18
 */
class Resource{
    private int num=1;
    Lock lock=new ReentrantLock();
    Condition condition1=lock.newCondition();
    Condition condition2=lock.newCondition();
    Condition condition3=lock.newCondition();
    public void print5(){
        lock.lock();
        try {
            while (num!=1){
                condition1.await();
            }
            //2.干活
            for(int i=1;i<=5;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
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
            while (num!=2){
                condition2.await();
            }
            //2.干活
            for(int i=1;i<=10;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
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
            while (num!=3){
                condition3.await();
            }
            //2.干活
            for(int i=1;i<=15;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            num=1;
            condition1.signalAll();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class ThreadOrder {
    public static void main(String[] args) {
        Resource resource=new Resource();
        new Thread(()->{
            for (int i=1;i<=10;i++){
                resource.print5();
            }
        },"A").start();
        new Thread(()->{
            for (int i=1;i<=10;i++){
                resource.print10();
            }
        },"B").start();
        new Thread(()->{
            for (int i=1;i<=10;i++){
                resource.print15();
            }
        },"C").start();
    }

}
