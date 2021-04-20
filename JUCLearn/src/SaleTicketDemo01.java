/**
 * Created by YinHU on 2019-11-17.
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：三个售票员    卖出      30张票
 *
 *
 * 如何编写企业级的多线程代码？
 * 固定的编程套路+模板是什么？
 *
 *
 * 1.高内聚 低耦合的前提下       线程   操作（对外暴露的调用方法）   资源类
 *      1.1 一言不合，先创建一个资源类
 *      1.2 几个 线程要对资源类进行什么样的的操作
 *
 *
 *      线程  操作资源类 main的第一行  就要搞这个资源类
 *      对这个资源类要进行哪些操作 ，全部在资源类身上自己带着
 *
 *
 *      接口也是一种特殊的类，能够new
 */
class Ticket{  //资源类=实例变量+实例方法
    private int number=30;
    //List list=new ArrayList();      左边接口，右边实现类？？？
    private Lock lock=new ReentrantLock();
    public void sale(){
        lock.lock();
        try{
            if(number>0) {
                System.out.println(Thread.currentThread().getName() + "\t卖出第：" + (number--) + "\t 还剩下：" + number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }  finally {
            lock.unlock();
        }
    }
    

}


public class SaleTicketDemo01{
    public static void main(String[] args) {   //主线程，一切程序的入口班
        Ticket ticket=new Ticket();

        new Thread(()->{for(int i=1;i<=30;i++)  ticket.sale();},"A").start();
        new Thread(()->{for(int i=1;i<=30;i++)  ticket.sale();},"B").start();
        new Thread(()->{for(int i=1;i<=30;i++)  ticket.sale();},"C").start();

    }
}
