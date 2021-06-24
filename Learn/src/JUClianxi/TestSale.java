package JUClianxi;

import java.util.Calendar;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunzhipeng
 * @create 2021-05-10 20:42
 */
class Ticket1{
    private int num=30;
    Lock lock=new ReentrantLock();
    public void sale(){
        try {
            lock.lock();
            if (num>0){
                System.out.println(Thread.currentThread().getName()+"\t卖出第：" + (num--) + "\t 还剩下：" + num);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class TestSale {
    public static void main(String[] args) {
        Ticket1 t1=new Ticket1();
        new Thread(()->{for (int i=0;i<30;i++){t1.sale();}},"a").start();
        new Thread(()->{for (int i=0;i<30;i++){t1.sale();}},"b").start();
        new Thread(()->{for (int i=0;i<30;i++){t1.sale();}},"c").start();
    }
}
