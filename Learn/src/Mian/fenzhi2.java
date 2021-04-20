package Mian;

import java.beans.beancontext.BeanContext;
import java.security.Principal;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author sunzhipeng
 * @create 2020-05-23 17:05
 */
public class fenzhi2 {
    public static void main(String[] args) throws Exception {
        Task task=new Task(0,100);
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinTask<Integer>forkJoinTask=forkJoinPool.submit(task);
        System.out.println(forkJoinTask.get());
        forkJoinPool.shutdown();

    }
}
class Task extends RecursiveTask<Integer> {
    private static final Integer NUM=10;
    private int begin;
    private int end;
    private int result;
    public Task(int begin,int end){
        this.begin= begin;
        this.end=end;
    }
   protected Integer compute(){
        if (end-begin<NUM){
            for(int i=begin;i<=end;i++){
                result=result+i;
            }
            return result;
        }else {
            int middle=(begin+end)/2;
            MyTask task=new MyTask(begin,middle);
            MyTask task2=new MyTask(middle+1,end);
            task.fork();
            task2.fork();
            result=task.join()+task2.join();
        }
        return result;
   }

}