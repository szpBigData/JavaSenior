/**
 * Created by YinHU on 2019-11-29.
 */

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 分支合并框架
 *
 */
class Mytask extends RecursiveTask<Integer>{
    private  static final Integer ADJUST_VALUE=10;
    private int begin;
    private int end;
    private int result;

    public Mytask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    protected Integer compute(){
        if((end-begin)<=ADJUST_VALUE){
            for(int i=begin;i<=end;i++){
                result=result+i;
            }
        }else{
            int middle=(end+begin)/2;
            Mytask mytask01=new Mytask(begin,middle);
            Mytask mytask02=new Mytask(middle+1,end);
            mytask01.fork();
            mytask02.fork();
            result=mytask01.join()+mytask02.join();
        }
        return result;
    }
}
public class ForkJoinDemo {
    public static void main(String[] args) throws Exception{
         Mytask mytask=new Mytask(0,100);
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask=forkJoinPool.submit(mytask);
        System.out.println(forkJoinTask.get());
        forkJoinPool.shutdown();
    }
}
