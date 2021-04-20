package com.atguigu.java;
import java.util.ArrayList;

/**
 * Created by YinHU on 2019-11-16.
 */
public class Jihe {
    public static void main(String[] args) {
        ArrayList arrayList=new ArrayList();
        arrayList.add(15);
        arrayList.add(20);
        arrayList.add(44);
        arrayList.add(26);
       // arrayList.add(60);
        System.out.println(arrayList.isEmpty());
        System.out.println(arrayList.contains(25));
        System.out.println(arrayList.size());
        arrayList.iterator();
//        arrayList.clear();
//        System.out.println(arrayList.size());
//        System.out.println(arrayList.isEmpty());
        Object [] arr=arrayList.toArray();
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        }
}

