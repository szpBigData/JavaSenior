import java.util.concurrent.CompletableFuture;

/**
 * Created by YinHU on 2019-11-29.
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {
        CompletableFuture<Void> completableFuture=CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName()+"没有返回，update mysql ok");
        });
        completableFuture.get();
        //异步回调
        CompletableFuture<Integer> completableFuture2=CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"\t completableFutures");
           // int age=10/0;
            return 1024;
        });
        completableFuture2.whenComplete((t,u)->{
            System.out.println("****t:"+t);
            System.out.println("****u:"+u);
        }).exceptionally(f->{
            System.out.println("***exception:"+f.getMessage());
            return  4444;
        }).get();
    }
    
}
