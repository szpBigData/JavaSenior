package JUClianxi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunzhipeng
 * @create 2021-04-19 9:31
 */
public class ThreadOrderAccess {
    private int number=1;
    private Lock lock=new ReentrantLock();
    private Condition condition1=lock.newCondition();
    private Condition condition2=lock.newCondition();
    private Condition condition3=lock.newCondition();

    public  void print5(){
        lock.lock();
        try {
            while (number !=1){
                condition1.await();
            }
            //2.干活
            for(int i=1;i<=5;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number=2;
            condition2.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public  void print10(){
        lock.lock();
        try {
            while (number !=2){
                condition2.await();
            }
            //2.干活
            for(int i=1;i<=10;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number=3;
            condition3.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public  void print15(){
        lock.lock();
        try {
            while (number !=3){
                condition3.await();
            }
            //2.干活
            for(int i=1;i<=15;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number=1;
            condition1.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        ThreadOrderAccess access=new ThreadOrderAccess();
        new Thread(()->{
            for(int i=1;i<=10;i++){}
            access.print5();
        },"A").start();
        new Thread(()->{
            for(int i=1;i<=10;i++){}
            access.print10();
        },"B").start();
        new Thread(()->{
            for(int i=1;i<=10;i++){}
            access.print15();
        },"C").start();
    }
}
