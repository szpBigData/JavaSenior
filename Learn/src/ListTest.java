import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by YinHU on 2019-11-18.
 */

/**
 * Collection接口：单列集合，用来存储一个一个的对象
 *      list接口：存储有序的、可重复的数据-->动态数组，替换原有的数组
 *      ArrayList：作为list接口的             主要实现类                       ，线程不安全，效率高；底层使用Objec[]存储
 *      LinkedList  : 对于频繁的插入、删除操作，使用此类比ArrayList效率高， 底层使用的是双向链表存储
 *      Vector：作为list接口的古老实现类：线程安全的，效率低，底层使用Object[]存储
 *
 *
 *
 * ArrayList/LinkedList/Vector三者的异同？
 * 同：三个类都是实现了list接口，数据存储的特点是相同的：存储有序的、可重复的数据
 *
 */
public class ListTest {
    public static void main(String[] args) {
       
        Collection collection=new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new String("Tom"));
        collection.add(false);

        boolean contains=collection.contains(123);
        System.out.println(contains);
        System.out.println(collection.contains(new String("Tom")));

    }
}
