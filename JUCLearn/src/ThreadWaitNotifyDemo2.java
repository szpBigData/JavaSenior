import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by YinHU on 2019-11-24.
 */
class AirConditioner2{
     private int number=0;
     private Lock lock=new ReentrantLock();
     private Condition condition=lock.newCondition();
     public void increment() throws InterruptedException{
         lock.lock();
         try{
             //1.判断
             while (number!=0){
                  condition.await();
                 //  this.wait();
             }
             //2.干活
             number++;
             System.out.println(Thread.currentThread().getName()+"\t"+number);
             //3.通知
             //this.notifyAll();
             condition.signalAll();
         }catch(Exception e){
             e.printStackTrace();
         } finally {
             lock.unlock();
         }
     }
     public void decrement() throws InterruptedException{
         lock.lock();
         try{
             //1.判断
             while (number==0){
                 condition.await();
             }
             //2.干活
             number--;
             System.out.println(Thread.currentThread().getName()+"\t"+number);
             //3.通知
             condition.signalAll();
             } catch (Exception e){
             e.printStackTrace();
         }   finally {
                 lock.unlock();
         }
     }
}
public class ThreadWaitNotifyDemo2 {
    public static void main(String[] args) {
         AirConditioner2 airConditioner2=new AirConditioner2();
         new Thread(()->{
             for(int i=1;i<=40;i++){
                 
             }
         },"").start();
    }
}
