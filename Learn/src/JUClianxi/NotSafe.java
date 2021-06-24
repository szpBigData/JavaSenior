package JUClianxi;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sunzhipeng
 * @create 2021-05-11 11:07
 */
public class NotSafe {
    public static void main(String[] args) {
        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
        for (int i=0;i<30;i++){
            new Thread(()->{
                concurrentHashMap.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(concurrentHashMap);
            },String.valueOf(i)).start();
        }
    }
}
