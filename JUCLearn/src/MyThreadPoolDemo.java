/**
 * Created by YinHU on 2019-11-27.
 */

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 例子：10年前单核CPU电脑，假的多线程，像马戏团小丑玩多个球，CPU需要来回切换。 例子：10年前单核CPU电脑，假的多线程，像马戏团小丑玩多个球，CPU需要来回切换。
 现在是多核电脑，多个线程各自跑在独立的CPU上，不用切换效率高。
 线程池的优势：
 线程池做的工作只要是控制运行的线程数量，处理过程中将任务放入队列，然后在线程创建后启动这些任务，如果线程数量超过了最大数量，超出数量的线程排队等候，等其他线程执行完毕，再从队列中取出任务来执行。
 它的主要特点为：线程复用;控制最大并发数;管理线程。
 第一：降低资源消耗。通过重复利用已创建的线程降低线程创建和销毁造成的销耗。
 第二：提高响应速度。当任务到达时，任务可以不需要等待线程创建就能立即执行。
 第三：提高线程的可管理性。线程是稀缺资源，如果无限制的创建，不仅会销耗系统资源，还会降低系统的稳定性，使用线程池可以进行统一的分配，调优和监控。
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
      //  ExecutorService threadPool= Executors.newFixedThreadPool(5);//一池受理5个线程 ，类似于一个银行有5个窗口
      //  ExecutorService threadPool=Executors.newSingleThreadExecutor();//一池1个工作线程，类似一个银行有1个受理窗口
        ExecutorService    threadPool=Executors.newCachedThreadPool();  // 一池n个工作线程，类似一个银行有n个受理窗口
        try {
            //模拟有10个顾客过来银行办理业务，目前池子里面有5个工作人员提供服务
              for(int i=1;i<=10;i++){
                  threadPool.execute(()->{
                      System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                  });
              }

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }
}
