package Mian;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author sunzhipeng
 * @create 2020-05-21 20:05
 */
public class NotSafe {
    public static void main(String[] args) {
        List<String> list= new CopyOnWriteArrayList<>();
        for(int i=0;i<30;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
