package FanShe;

/**
 * Created by YinHU on 2019-11-23.
 */
public class Person {
    private String name;
    public  int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
    private Person(String name){
        this.name=name;
    }
    public void show(){
        System.out.println("你好，我是一个人");
    }
    private String showNation(String nation){
        System.out.println("我的国籍是："+nation);
        return nation;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
