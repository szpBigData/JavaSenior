/**
 * Created by YinHU on 2019-12-02.
 */
public class MyObject {
    public static void main(String[] args) {
        MyObject myObject=new MyObject();
        System.out.println(myObject.getClass().getClassLoader());
        System.out.println(myObject.getClass().getClassLoader().getParent());
        System.out.println(myObject.getClass().getClassLoader().getParent().getParent());
        System.out.println("==========================================================");
        Object o=new Object();
        System.out.println(o.getClass().getClassLoader());
    }
}
