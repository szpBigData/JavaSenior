package JUClianxi;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunzhipeng
 * @create 2021-04-16 8:37
 */
class sale{
    private int num=30;
    private Lock lock=new ReentrantLock();
    public void sale(){
        lock.lock();
        try {
            if (num>0){
                System.out.println(Thread.currentThread().getName()+"\t卖出第：" + (num--) + "\t 还剩下：" + num);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class Ticket {
    public static void main(String[] args) {
            sale sale =new sale();
            new Thread(()->{for (int i=1;i<=30;i++) sale.sale();},"a").start();
        new Thread(()->{for (int i=1;i<=30;i++) sale.sale();},"b").start();
        new Thread(()->{for (int i=1;i<=30;i++) sale.sale();},"c").start();
    }
}
