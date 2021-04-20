import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sunzhipeng
 * @create 2020-05-22 15:00
 */
class MyResource{
    private volatile boolean FlAG=true;//默认开启，进行生产+消费
    private AtomicInteger atomicInteger=new AtomicInteger();
    BlockingQueue<String> blockingQueue=null;
    public MyResource(BlockingQueue<String> blockingQueue){
        this.blockingQueue=blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }
    public  void myProd() throws Exception{
        String  data=null;
        boolean retValue;
        while (FlAG){
            data=atomicInteger.incrementAndGet()+"";
            retValue=blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            if(retValue){
                System.out.println(Thread.currentThread().getName()+"\t"+"插入队列"+data+"成功");
            }else {
                System.out.println(Thread.currentThread().getName()+"\t"+"插入队列"+data+"插入失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t"+"大老板叫停了，表示Flag=false,生产动作结束"+data+"成功");
    }
    public void myConsumer()throws Exception{
        String result=null;
        while (FlAG){
            result=blockingQueue.poll(2L,TimeUnit.SECONDS);
            if(null==result||result.equalsIgnoreCase("")){
                FlAG=false;
                System.out.println(Thread.currentThread().getName()+"\t"+"超过2秒钟没有取到蛋糕，消费退出");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t"+"消费队列蛋糕"+result+"成功");
        }

    }
    public void stop() throws Exception{
        this.FlAG=false;
    }
}
public class ProdConsumer_BlockQueueDemo {
    public static void main(String[] args) {
        MyResource myResource=new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t生产线程启动");
            try {
                myResource.myProd();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"Prod").start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 消费线程启动");
            try {
                myResource.myConsumer();
                System.out.println();
                System.out.println();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"Consumer").start();
//暂停一会线程
        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("5s时间到，打咯banmain线程叫停，多动结束");
        try {
            myResource.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
