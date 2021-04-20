/**
 * Created by YinHU on 2019-11-26.
 */

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * java多线程中，第三种获得多线程的方式
 * 1.get方法一般放在最后一行
 */

/**
 * callable接口和runnable接口的区别？
 * 1.是否有返回值
 * 2.是否抛异常
 * 3.落地方法不一样，一个是run，一个是call
 */

/**
 * 思考：面向接口编程的好处
 * 要懂callable底层原理以及实现细节
 */
class MyThread implements Callable<Integer>{
    public Integer call() throws Exception{
        System.out.println("*******come in here");
        //暂停一会线程
        try{
            TimeUnit.SECONDS.sleep(4);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return 1024;
    }
}
public class CallableDemo {
    public static void main(String[] args) throws Exception{
        FutureTask futureTask=new FutureTask(new MyThread()) ;
        new Thread(futureTask,"A").start();
        System.out.println(futureTask.get());
    }
}
