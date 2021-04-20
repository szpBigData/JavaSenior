package HuLianWang2;

/**
 * Created by YinHU on 2019-11-21.
 */

/**
 * 集合类不安全问题
 * ArrayList
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * 1 故障现象
 *     java.util.ConcurrentMadficationException
 * 2.导致原因
 *
 * 3.解决方案
 *        1.new Vector
 *        2.Collections.synchronizedList(new ArrayList())
 * 4.优化建议（同样的错误不再犯第二次）
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        List<String> list= Collections.synchronizedList(new ArrayList<>());//Constructs an empty list with an initial capacity of ten.
        for(int i=1;i<=30;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }

    }
}
