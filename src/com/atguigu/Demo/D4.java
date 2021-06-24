package com.atguigu.Demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunzhipeng
 * @create 2021-06-23 22:17
 * 二分查找：
 * 四个参数：数组 左标  右标    目标值
 *
 * 1.left>right     返回空的数组
 * 2.定义中 坐标  和中值
 * 3.目标值>中值  向右递归    mid+1  right
 *   else if 目标值<中值 向左递归  left mid-1
 *   else
 *      定义一个空的arraylist类型
 *      temp=mid-1   向左递归
 *      while  true时   if    temp<0||arr[temp]!=findValue  break
 *          否则  添加进空数组   temp左移
 *     mid添加到空数组
 *     temp=mid+1   向右递归
 *  *      while  true时   if    temp>arr.length-1||arr[temp]!=findValue  break
 *  *          否则  添加进空数组   temp右移
 *  返回结果
 *
 */
public class D4 {
    public static void main(String[] args) {

    }
public static List<Integer> binSearch(int[]arr,int left,int right,int findValue) {
    if (left > right) {
        return new ArrayList<Integer>();
    }



    int mid = (left + right) / 2;
    int midValue = arr[mid];





    if (findValue > midValue) {
        binSearch(arr, mid + 1, right, findValue);
    } else if (findValue < midValue) {
        binSearch(arr, left, mid - 1, findValue);
    } else {
        List<Integer> resultList = new ArrayList<Integer>();


        int temp=mid-1;
        while (true){
            if (temp<0||arr[temp]!=findValue){
                break;
            }
            resultList.add(temp);
            temp=temp-1;
        }


        resultList.add(mid);



        temp=mid+1;
        while (true){
            if (temp>arr.length-1||arr[temp]!=findValue){
                break;
            }
            resultList.add(temp);
            temp=temp+1;
        }
        return resultList;
    }
   
}
}
