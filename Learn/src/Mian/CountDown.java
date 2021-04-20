package Mian;

import java.util.concurrent.CountDownLatch;

/**
 * @author sunzhipeng
 * @create 2020-05-23 16:32
 */
public class CountDown {
    public static void main(String[] args) {
        CountDownLatch countDownLatch=new CountDownLatch(5);
        try {
           for(int i=0;i<5;i++){

               new Thread(()->{
                   System.out.println(Thread.currentThread().getName()+"\t"+"完成了");
                   countDownLatch.countDown();
               }).start();
           }
            countDownLatch.await();
            System.out.println("主线程完成");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
