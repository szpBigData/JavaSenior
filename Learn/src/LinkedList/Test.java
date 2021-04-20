package LinkedList;

/**
 * Created by YinHU on 2019-11-22.
 */
public class Test {
    public static void main(String[] args) {
      //  HeroNode head=new HeroNode();
               new Thread(()->{
                   for (int i=0;i<10;i++){
                       System.out.println(Thread.currentThread().getName()+" "+i);
                   }
               },"AA").start();
               for(int j=0;j<10;j++){
                   System.out.println(Thread.currentThread().getName()+" "+j);
               }

    }
}
