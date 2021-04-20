/**
 * Created by YinHU on 2019-11-27.
 */
class Person{
    private Integer id;
    private String personName;
    public Person(String personName){
        this.personName=personName;
    }
    public Person(){}
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
public class TestTransferValue {
    public void changeValue(int age){
        age=30;
    }
    public void changeValue2(Person person){
        person.setPersonName("XXX");
    }
    public void changeValue3(String str){
        str="xxx";
    }

    public static void main(String[] args) {
        TestTransferValue test=new TestTransferValue();
        int age=20;
        test.changeValue(age);
        System.out.println("age----"+age);

        Person person=new Person("abc");
        test.changeValue2(person);
        System.out.println("personName---"+person.getPersonName());

        String str="abc";
        test.changeValue3(str);
        System.out.println("String----"+str);

    }
}
