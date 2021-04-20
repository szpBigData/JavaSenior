package com.atguigu.java;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by YinHU on 2019-11-19.
 */
public class Test01 {

    public static void main(String[] args) {
            TreeSet<Student> set = new TreeSet(new Comparator<Student>(){

                @Override
                public int compare(Student o1, Student o2) {
                    return o1.getId() - o2.getId();
                }

            });
            set.add(new Student(3,"张三"));
            set.add(new Student(1,"李四"));
            set.add(new Student(2,"王五"));
            set.add(new Student(3,"张三风"));

            System.out.println("元素个数：" + set.size());
            for (Student stu : set) {
                System.out.println(stu);
            }
        }

}
