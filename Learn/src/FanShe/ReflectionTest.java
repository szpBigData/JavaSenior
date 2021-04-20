package FanShe;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by YinHU on 2019-11-23.
 */
public class ReflectionTest {
    //反射之前，对于person的操作
    @Test
    public void test(){
        //创建Person类对象
        Person p1=new Person("Tom",12);
        //通过对象，调用其内部的属性、方法
        p1.age=10;
        System.out.println(p1.toString());

        p1.show();

        //在Person类外部，不可以通过Person类的对象 调用其内部的私有结构
        //eg:name/showNation()以及私有的构造器
    }
   @Test
    public void test2() throws Exception {
       Class clazz=Person.class;
       //1.通过反射创建person类的对象
       Constructor cons=clazz.getConstructor(String.class,int.class);
       Object obj= cons.newInstance("Tom",12);
       Person p=(Person)obj;
       System.out.println(p.toString());
       //2.通过反射，调用独享指定的属性和方法
       Field age = clazz.getDeclaredField("age");
       age.set(p,10);
       System.out.println(p.toString());
       //调用方法
       Method show=clazz.getDeclaredMethod("show");
       show.invoke(p);
       //通过反射，可以调用Person 类的私有结构的，比如私有的构造器、方法、属性
       //调用私有的构造器
       Constructor con1 = clazz.getDeclaredConstructor(String.class);
       con1.setAccessible(true);
       Person p1=(Person)con1.newInstance("Jerry");
       System.out.println(p1);
       //调用私有的属性
       
   }


}
