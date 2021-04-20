package com.atguigu.java;

/**
 * Created by YinHU on 2019-11-13.
 */
public class xiancheng {
    public static void main(String[] args) {
        new Thread(()->{
            for (int i=0;i<100;i++){
                System.out.println("你好，孙志鹏"+i);
            }
        },"Sunzhipeng").start();
        new Thread(()->{
            for(int j=0;j<100;j++) {
                System.out.println("你好，杨晓宇"+j);
            }
        },"Yangxiaoyu").start();
        new Thread(()->{
                 for(int m=0;m<=100;m++){
                     if(m%2==0){
                         System.out.print(m+" ");
                         System.out.println("-------------");
                     }
                     
                 }
            
        },"oushu").start();

        new Thread(()->{
            for(int n=0;n<=100;n++){
                if(n%2!=0){
                    System.out.print(n+" ");
                    System.out.println("*************");
                }
            }
        },"jishu").start();
    }
}
