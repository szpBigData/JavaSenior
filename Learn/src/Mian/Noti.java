package Mian;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @author sunzhipeng
 * @create 2020-05-21 17:49
 */
class Zi{
    private int number=1;
    private Lock lock=new ReentrantLock();
    private Condition condition1=lock.newCondition();
    private Condition condition2=lock.newCondition();
    private Condition condition3=lock.newCondition();
    public void print5(){
        lock.lock();
        try {
            while (number!=1){
                condition1.await();
            }
            for(int i=0;i<=5;i++){
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
    public void print10(){
        lock.lock();
        try {
            while (number!=2){
                condition2.await();
            }
            for(int i=0;i<10;i++){
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
    public void print8(){
        lock.lock();
        try {
            while (number!=3){
                condition3.await();
            }
            for(int i=0;i<8;i++){
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
}

public class Noti {
    public static void main(String[] args) {
       Zi a=new Zi();
       new Thread(()->{
           for (int i=0;i<10;i++){
               a.print5();
           }
       },"A").start();
        new Thread(()->{
            for (int i=0;i<10;i++){
                a.print10();
            }
        },"B").start();
        new Thread(()->{
            for (int i=0;i<10;i++){
                a.print8();
            }
        },"C").start();

    }
}
