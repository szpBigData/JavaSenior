package Mian;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author sunzhipeng
 * @create 2020-05-23 16:56
 */
public class Fenzhi  {
    public static void main(String[] args) throws Exception{
        MyTask myTask=new MyTask(0,100);
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinTask<Integer>forkJoinTask=forkJoinPool.submit(myTask);
        System.out.println(forkJoinTask.get());
        forkJoinPool.shutdown();
    }
}
class MyTask extends RecursiveTask<Integer>{
    private static final Integer ADJUST_VALUE=10;
    private int begin;
    private int end;
    private int result;
    public MyTask(int begin,int end){
        this.begin=begin;
        this.end=end;
    }
    protected Integer compute(){
        if((end-begin)<=ADJUST_VALUE){
            for(int i=begin;i<=end;i++){
                result=result+i;
            }
        }else {
            int middle=(begin+end)/2;
            MyTask task1=new MyTask(begin,middle);
            MyTask task2=new MyTask(middle+1,end);
            task1.fork();
            task2.fork();
            result=task1.join()+task2.join();
        }
        return  result;
    }
}