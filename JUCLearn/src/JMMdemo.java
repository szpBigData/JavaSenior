/**
 * Created by YinHU on 2019-12-03.
 */
class MyNumber{
    volatile  int number=10;
    public void addTo1021(){
        this.number=1021;
    }
}
public class JMMdemo {
    public static void main(String[] args) {
        MyNumber myNumber=new MyNumber();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"**********come in");
             try {
                 Thread.sleep(3000);
                 myNumber.addTo1021();//将10修改为1021
                 System.out.println(Thread.currentThread().getName()+"\t A update number,number value:"+myNumber.number);
             }catch (InterruptedException e){
                 e.printStackTrace();
             }
        },"AAA").start();
        while (myNumber.number==10){
            //需要有一种通知机制告诉main线程，number已经修改到1021，跳出while
            
        }
        System.out.println(Thread.currentThread().getName()+"mission is over");
    }
}
