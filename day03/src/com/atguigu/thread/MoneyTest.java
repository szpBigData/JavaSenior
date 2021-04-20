package com.atguigu.thread;


/**
 * Created by YinHU on 2019-11-15.
 */
class HelloThread extends Thread{
    public void run(){
          for (int i=0;i<=100;i++){
              if(i%2==0){
                  System.out.println(Thread.currentThread().getName()+" : "+Thread.currentThread().getPriority()+" --" +i);
              }

          }
    }
}
public class MoneyTest {
    public static void main(String[] args) {
             HelloThread helloThread=new HelloThread();
             helloThread.setName("孙志鹏");
             helloThread.setPriority(10);
             helloThread.start();
             Thread.currentThread().setName("杨晓宇");
             for (int i=0;i<=100;i++){
                if(i%2==0){
                    System.out.println(Thread.currentThread().getName()+" : "+Thread.currentThread().getPriority() +" -- "+i);
            }
        }
    }
}
