/**
 * Created by YinHU on 2019-11-29.
 */

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 题目：请按照给出数据，找出同时满足以下条件的用户，也即以下条件全部满足
 * 偶数ID且年龄大于24且用户名转为大写且用户名字母倒排序
 * 只输出一个用户名字
 */
class User{
    private Integer id;
    private String userName;
    private int age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(Integer id, String userName, int age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
public class StreamDemo {
    public static void main(String[] args) {
        User u1=new User(11,"a",23);
        User u2=new User(12,"b",24);
        User u3=new User(13,"c",22);
        User u4=new User(14,"d",28);
        User u5=new User(16,"e",26);

        List<User> list = Arrays.asList(u1,u2,u3,u4,u5);
        list.stream().filter(u->{return u.getId()%2==0;}).filter(t->{return t.getAge()>24;}).
                map(m->{return m.getUserName().toUpperCase();}).
                sorted((o1,o2)->{return o2.compareTo(o1);}).
                limit(1).forEach(System.out::println);






        
        System.out.println("==========================================================================================");
        Function<String,Integer> function=s->{return s.length();};
        System.out.println(function.apply("abc"));
//        Predicate<String> predicate=new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return false;
//            }
//        };
        Predicate<String> predicate=s->{return s.isEmpty();};
        System.out.println(predicate.test("xiass"));
//        Consumer<String> consumer=new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//
//            }
//        } ;
        Consumer<String> consumer=s->{
            System.out.println(s);
        };
        consumer.accept("xiass");


//        Supplier<String> supplier=new Supplier<String>() {
//            @Override
//            public String get() {
//                return null;
//            }
//        } ;
         Supplier<String> supplier=()->{return "bigdata1021";};
        System.out.println(supplier.get());

    }
}
