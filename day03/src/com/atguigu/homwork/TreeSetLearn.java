package com.atguigu.homwork;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by YinHU on 2019-11-19.
 */
public class TreeSetLearn {
    public static void main(String[] args) {
        TreeSet<Car> set=new TreeSet(new Comparator<Car>(){
            public int compare(Car c1,Car c2){
                return    c2.getPrice()-c1.getPrice();
            }
        });
        set.add(new Car("BYD",5000));
        set.add(new Car("BMW",2000)) ;
        set.add(new Car("Audi",6000));
        System.out.println("元素个数："+set.size());
          for(Car c:set){
              System.out.println(c);
          }
    }

    
}
