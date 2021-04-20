import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by YinHU on 2019-11-30.
 */
class TicketL{
    private int num=40;
    Lock lock=new ReentrantLock();
    public void sell(){
        lock.lock();
        try {
            if(num>0){
                num--;
                System.out.println(Thread.currentThread().getName()+" 购买票，还剩下 "+num+" 张");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class sellTicket {
    
    public static void main(String[] args) {
           TicketL ticket=new TicketL();
           new Thread(()->{for(int i=1;i<=40;i++){ticket.sell();}},"A").start();
           new Thread(()->{for(int i=1;i<=40;i++){ticket.sell();}},"B").start();
           new Thread(()->{for(int i=1;i<=40;i++){ticket.sell();}},"C").start();
           new Thread(()->{for(int i=1;i<=40;i++){ticket.sell();}},"D").start();
    }
}
