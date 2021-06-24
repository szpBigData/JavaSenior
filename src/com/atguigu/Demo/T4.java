//package com.atguigu.Demo;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author sunzhipeng
// * @create 2021-06-22 22:25
// */
//public class T4 {
//    public static void main(String[] args) {
//
//    }
//
//    public static List<Integer> binSearch(int[] arr, int left, int right, int targetValue) {
//        if (left > right) {
//            return new ArrayList<Integer>();
//        }
//        int mid = (left + right) / 2;
//        int midVal = arr[mid];
//
//        if (targetValue > midVal) {
//            binSearch(arr, mid + 1, right, targetValue);
//        } else if (targetValue < midVal) {
//            binSearch(arr, left, mid - 1, targetValue);
//        } else {
//            ArrayList<Integer> resIndexlist = new ArrayList<Integer>();
//            int temp = mid - 1;
//            while (true) {
//                if (temp < 0 || arr[temp] != targetValue) {
//                    break;
//                }
//                resIndexlist.add(temp);
//                temp = temp - 1;
//            }
//            resIndexlist.add(mid);
//            temp = mid + 1;
//            while (true) {
//                if (temp > arr.length - 1 || arr[temp] != targetValue) {
//                    break;
//                }
//                resIndexlist.add(temp);
//                temp = temp + 1;
//            }
//            return resIndexlist;
//        }
//
//}
