//package com.atguigu.Demo;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author sunzhipeng
// * @create 2021-06-18 22:33
// */
//public class Test4 {
//    public static void main(String[] args) {
//
//    }
//    public static List<Integer> binarySearch(int [] arr, int left, int right, int findValue){
//        if (left>right){
//            return new ArrayList<Integer>();
//        }
//        int mid=(left+right)/2;
//        int midValue=arr[mid];
//
//        if (findValue>midValue){
//            return binarySearch(arr,mid+1,right,findValue);
//        }else if (findValue<midValue){
//            return binarySearch(arr,left,mid,findValue);
//        }else {
//            List<Integer> resIndexlist=new ArrayList<>();
//        }
//    }
//}
