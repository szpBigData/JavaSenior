//package com.atguigu.HashLearn;
//
//import java.util.Map;
//
///**
// * Created by YinHU on 2019-11-19.
// */
//public class MyHashMap<K,V> implements Map<K,V>{
//    private Entry<K,V>[] table;
//    private static Integer CAPACITRY=8;
//    public MyHashMap(){
//          this.table=new Entry[CAPACITRY];
//    }
//    public int size(){
//        return 0;
//    }
//    public Object get(Object key){
//        return null;
//    }
//    public Object put(K key,V value){
//         Entry entry=new Entry(key,value,null);
//         Integer hash=key.hashCode();
//         Integer index=hash%table.length;
//         table[index]=entry;
//         return null;
//    }
//
//
//
//      class Entry<K,V>{
//          private K k;
//          private V v;
//          private Entry<K,V> next;
//          public Entry<K k,V v,Entry<K,V> next>{
//                this.k=k;
//                this.v=v;
//                this.next=next;
//          }
//      }
//}
//