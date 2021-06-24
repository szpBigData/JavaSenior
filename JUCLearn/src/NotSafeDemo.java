/**
 * Created by YinHU on 2019-11-26.
 */

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
/**
 * 1.hashSet的底层是由HashMap组成的
 *
 *   public boolean add(E e) {
         return map.put(e, PRESENT)==null;
      }
 * hashSet的add（）调的是hashMap 的put()   ,add里面放入的是put里面的那个key
 * 
 */
/**
 * 题目：请举例说明集合类是不安全的
 */

/**
 * 1.故障现象
 * java.util.ConcurrentModificationException
 * 2.导致原因
 * 3.解决方案 (list)
 *       3.1 Vector
 *       3.2 Collections.synchronizedList(new ArrayList<>())
 *       3.3      new CopyOnWriteArrayList<>()
 *   解决方案（Set）
 *   1.Collections.synchronizedSet
 *   2.CopyOnWriteArraySet()
 *   解决方案（Map）
 *   1.new ConcurrentHashMap()
 *   2.Collections.synchronizedMap()
 * 4.优化建议（同样的错误，不出现第2次）
 */

/**
 * 笔记
 * 写时复制
 *  CopyOnWrite容器即写时复制的容器，往一个容器添加元素的时候，不直接往当前容器Object【】添加，而是先将当前容器
 *  Object【】进行copy，复制出一个新的容器Object【】newElement，然后新的容器Object【】newElements里添加元素，添加完元素之后
 *  再将原容器的引用指向新的容器  setArray(newElements)
 *  这样做的好处是可以对CopyOnWrite容器进行并发的读
 *  而不需要加锁，因为当前容器不会添加任何元素。所以copyOnWrite容器也是一种读写分离的思想，读和写不同的容器
 *     public boolean add(E e) {
         final ReentrantLock lock = this.lock;
         lock.lock();
         try {
         Object[] elements = getArray();
         int len = elements.length;
         Object[] newElements = Arrays.copyOf(elements, len + 1);
         newElements[len] = e;
         setArray(newElements);
         return true;
          } finally {
         lock.unlock();
         }
            }
 */
public class NotSafeDemo {
    public static void main(String[] args) {
//       Map<String,String> map=new ConcurrentHashMap<>();
//        for(int i=1;i<=30;i++){
//            new Thread(()->{
//                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
//                System.out.println(map);
//            },String.valueOf(i)).start();
//        }
//    }
//    public static void listNotSafe(){
        List<String> list=new CopyOnWriteArrayList<>();
        for(int i=1;i<=30;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
//    }
//    public static void setNotSafe(){
//        Set<String> set=new CopyOnWriteArraySet<>();
//        for(int i=1;i<=30;i++){
//            new Thread(()->{
//                set.add(UUID.randomUUID().toString().substring(0,8));
//                System.out.println(set);
//            },String.valueOf(i)).start();
//        }
   }
}
