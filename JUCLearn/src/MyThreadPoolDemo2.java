import java.util.concurrent.*;

/**
 * Created by YinHU on 2019-11-29.
 */
public class MyThreadPoolDemo2 {
    public static void main(String[] args) {
        ExecutorService threadPool=new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        try {
               for (int i=1;i<=9;i++)  {
                   threadPool.execute(()->{
                       System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                   });
               }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
        
    }
}
