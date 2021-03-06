import java.util.concurrent.CountDownLatch;

/**
 * Created by YinHU on 2019-11-27.
 */

/**
 *  CountDownLatch主要有两个方法：当一个或者多个线程调用await方法时，这些线程会阻塞
 *  当其他线程调用countDown方法会将计数器减1（调用countDown方法的线程不会阻塞）
 *  当计数器的值变为0的时候，因为await方法阻塞的线程会被唤醒，继续执行
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException{
        CountDownLatch countDownLatch=new CountDownLatch(6);
          for(int i=1;i<=6;i++){
              new Thread(()->{
                  System.out.println(Thread.currentThread().getName()+"\t离开教室");
                  countDownLatch.countDown();
              },String.valueOf(i)).start();
          }
          countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t班长关门走人");
    }
}
