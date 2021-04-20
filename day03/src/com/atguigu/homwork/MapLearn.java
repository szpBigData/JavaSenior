package com.atguigu.homwork;

import java.util.*;

/**
 * Created by YinHU on 2019-11-19
 *
 */
public class MapLearn {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("张三",800);
        map.put("李四",1500);
        map.put("王五",3000);


        
         //修改张三的 工资
        
        System.out.println("-------遍历所有员工-----");
        Set<String> name=map.keySet();
        for(String na:name){
            System.out.println(na);
        }
        System.out.println("-------遍历所有员工工资-----");
        Collection <Integer> price=map.values();
          for(Integer i:price){
              System.out.println(i);
          }
    }
}
