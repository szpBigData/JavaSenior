package Mian;

import java.util.concurrent.CyclicBarrier;

/**
 * @author sunzhipeng
 * @create 2020-05-23 16:38
 */
public class Zhalan {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,()->{
            System.out.println("集齐七颗龙珠召唤神龙");
        });

            for (int i=0;i<7;i++){
                new Thread(()->{
                    try {
                        System.out.println(Thread.currentThread().getName() + "\t" + "已完成");
                        cyclicBarrier.await();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }).start();
            }

    }
}
