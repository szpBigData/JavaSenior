package Mian;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author sunzhipeng
 * @create 2020-05-22 9:00
 */
public class XCC {
    public static void main(String[] args) {
        Executor executor=Executors.newFixedThreadPool(5);
        try {
            for(int i=1;i<=10;i++){
                executor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t"+"办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
