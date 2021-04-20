package com.atguigu.HashLearn;

import java.util.HashMap;

/**
 * Created by YinHU on 2019-11-19.
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("周瑜","周瑜");
        hashMap.put("曹操","曹操");
        hashMap.put("刘备","刘备");
        hashMap.put("孙权","孙权");
        hashMap.put("诸葛亮","诸葛亮");
        System.out.println(hashMap.get("诸葛亮"));
        
    }
}
