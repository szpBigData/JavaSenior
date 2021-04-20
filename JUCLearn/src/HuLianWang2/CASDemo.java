package HuLianWang2;

/**
 * Created by YinHU on 2019-11-21.
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1. CAS是什么？==>compareAndSet
 * 比较并交换   真实值和期望值相同，则修改成功，真实值和期望值不同，则修改失败
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger(5);
        //main do thing..
        System.out.println(atomicInteger.compareAndSet(5,2019)+"\t current data:"+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5,1024)+"\t current data:"+atomicInteger.get());
     
    }
}
