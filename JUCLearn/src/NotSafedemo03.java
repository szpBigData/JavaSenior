import java.util.*;

/**
 * Created by YinHU on 2019-11-19.
 */
public class NotSafedemo03 {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}