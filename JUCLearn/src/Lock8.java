/**
 * Created by YinHU on 2019-11-24.
 */

/**
 *    总结：

 ①一个对象里面如果有多个synchronized方法，某一个时刻内，只要一个线程去调用其中的一个synchronized方法了，其他的线程都只能等待，换句话说，某一时刻内，只能有唯一一个线程去访问这些synchronized方法。

 ②锁的是当前对象this，被锁定后，其他线程都不能进入到当前对象的其他的synchronized方法。

 ③加个普通方法后发现和同步锁无关。

 ④换成静态同步方法后，情况又变化

 ⑤所有的非静态同步方法用的都是同一把锁 -- 实例对象本身，也就是说如果一个实例对象的非静态同步方法获取锁后，该实例对象的其他非静态同步方法必须等待获取锁的方法释放锁后才能获取锁，可是别的实例对象的非静态同步方法因为跟该实例对象的非静态同步方法用的是不同的锁，所以毋须等待该实例对象已经取锁的非静态同步方法释放锁就可以获取他们自己的锁。

 ⑥所有的静态同步方法用的也是同一把锁 -- 类对象本身，这两把锁是两个不同的对象，所以静态同步方法与非静态同步方法之间不会有竞争条件。但是一旦一个静态同步方法获取锁后，其他的静态同步方法都必须等待该方法释放锁后才能获取锁，而不管是同一个实例对象的静态同步方法之间，还是不同的实例对象的静态同步方法之间，只要它们是同一个实例对象
 ————————————————
 版权声明：本文为CSDN博主「kfengqingyangk」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 原文链接：https://blog.csdn.net/kfengqingyangk/article/details/69485858
 */

/**  思路： 线程 操作 共享资源
 1）创建资源类，在资源类中定义线程操作方法，根据需要添加同步锁或同步代码块
 2）创建线程对象，使用线程对象调用响应的同步方法

 对象锁和类锁的定义：
 对象锁：
 1）对象锁也叫方法锁，是针对一个对象实例的，它只在该对象的某个内存位置声明一个标识该对象是否拥有锁，所有它只会锁住当前的对象，而并不会对其他对象实例的锁产生任何影响，不同对象访问同一个被synchronized修饰的方法的时候不会阻塞
 2）synchronized修饰的非静态方法，即非静态同步方法
 3）synchronized(this)，即非静态同步代码块
 类锁：
 1）synchronized static 修饰的静态方法，即静态同步方法
 2）synchronized(类名.class)，即静态同步代码块
 位置：
 对象锁：堆内存中
 类锁：方法区中
 范围：
 对象锁：
 1）同一个线程对象如果有多个synchronized方法，同一时间只能访问一个synchronized方法
 2）锁的是this线程对象本身，不同线程对象之间的锁互不影响
 类锁：
 1）锁的是类名.class，这个对象是类加载对象的唯一，永远只能有一把锁
 执行顺序：判断多个线程对象TA、TB对应的调用方法MA、MB，是对象锁、类锁、没锁
 MA、MB都是对象锁
 判断条件：TA、TB是否是同一个对象
 1）是，依调用顺序，必须等前一个方法释放锁之后，后一个方法才能执行
 2）不是，互不影响
 MA、MB中一个是对象锁另一个是类锁
 判断条件：TA、TB是否是同一个对象
 1）是，互不影响
 2）不是，互不影响
 MA、MB都是类锁
 判断条件：TA、TB是否是同一个对象
 1）是，依调用顺序，必须等前一个方法释放锁之后，后一个方法才能执行
 2）不是，依调用顺序，必须等前一个方法释放锁之后，后一个方法才能执行
 MA、MB中一个是同步方法(对象锁或类锁)另一个是普通方法
 判断条件：TA、TB是否是同一个对象
 1）是，互不影响
 2）不是，互不影响
 3）普通的方法不受对象锁、类锁的约束，只跟调用顺序有关，即在调用普通方法之前，该线程对象在调用了一个synchronize的方法后且没有释放锁时，也不会影响调用该普通方法
 *
 */

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 题目：多线程8锁
 * 1.标准访问：请问先打印邮件还是短信？         email   sms
 * 2.邮件方法暂停4秒钟，先打印邮件还是短信    email   sms
 * 3.新增一个普通方法hello（），请问先打印邮件还是hello？ hello email
 * 4.两部手机，先打印邮件还是短信？      sms email
 * 5.两个静态同步方法，同一部手机，请问先打印邮件还是短信？   email sms
 * 6.两个静态同步方法，两部手机，请问先打印邮件还是短信       email sms
 * 7.1个普通同步方法，1个静态同步方法，1部手机，请问先打印邮件还是短信   sms email
 * 8. 1个普通同步方法，1个静态同步方法，两部手机，请问先打印邮件还是短信   sms email
 * 
 */

/**
 * 一个对象里面如果有多个synchronized方法，某一时刻内，只要一个线程去调用其中的一个synchronized方法了
 * 其他的线程都只能等待，换句话说，某一个时刻内，只能有唯一一个线程去访问这些synchronized方法
 * 锁定是当前对象this，被锁定后，其他的线程都不能进入到当前对象的其他synchronized方法
 *
 * 加个普通方法后发现与同步锁无关
 * 换成两个对象之后，不是同一把锁，情况立刻发生了变化
 *
 * 都换成静态同步方法后，情况又变化
 * 所有的非静态同步方法用的都是同一把锁--实例对象本身
 *
 * synchronized实现同步的基础：Java中的每一对象都可以作为锁
 * 具体表现为以下三种方式：
 * 对于普通同步方法，锁的是当前实例对象
 * 对于静态同步方法，锁的是当前类的class对象
 * 对于同步方法快，锁的是synchronized括号里配置的对象
 *
 *当一个线程试图访问同步代码块时，他首先必须得到锁，退出或者抛出异常时必须释放锁
 *
 * 也就是说如果一个实例对象的非静态同步方法获取锁后，该实例对象的其他非静态同步方法必须等待获取锁的方法释放后才能获取锁
 * 可是别的实例对象的非静态同步方法因为跟该实例对象的非静态同步方法用的是不同的锁
 * 所以无需等待该实例对象已获取锁的非静态同步方法释放锁就可以获取他们自己的锁
 *
 * 所有的静态同步方法用的也是同一把锁-类对象本身，
 * 这两把锁是两个 不同的对象，所以静态同步方法与非静态同步方法之间是不会有竞态条件的
 * 但是一旦一个静态同步方法获取锁后，其他的 静态同步方法都必须等待该方法释放锁后才能获取锁
 * 而不管是同一个实例对象的静态同步方法之间
 * 还是不同的实例对象的静态同步方法之间，只要他们同一个类的实例对象
 */
class Phone{
  public static synchronized void sendEmail() throws Exception{
      //暂停一会线程
      try {
          TimeUnit.SECONDS.sleep(4);
      }catch (InterruptedException e){
          e.printStackTrace();
      }
      System.out.println("-----sendEmail");
  }
  public  synchronized void sendSms() throws Exception{
      System.out.println("------sendSms");
  }
  public void hello(){
      System.out.println("----hello");
  }
}
public class Lock8 {
    public static void main(String[] args) throws Exception{
        Phone phone=new Phone();
        Phone phone2=new Phone();
         new Thread(()->{
           try{
               phone.sendEmail();
           }catch (Exception e){
               e.printStackTrace();
           }
         },"A").start();
        Thread.sleep(100);
        new Thread(()->{
            try{
               //phone.sendSms();
               // phone.hello();
                phone2.sendSms();
                
            }catch (Exception e){
                e.printStackTrace();
            }
        },"B").start();

        System.out.println();
    }
}
