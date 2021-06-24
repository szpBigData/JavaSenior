package com.atguigu.java;

/**
 * @author sunzhipeng
 * @create 2021-06-14 21:30
 */
public class BubbleTest {
    public static void main(String[] args) {
        int [] arr={7,6,8,5,9,4,20,1,3,42};
        System.out.println("排序前");
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        System.out.println("=======================================================");
        BubbleSort(arr);
        System.out.println("排序后");
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static void BubbleSort(int [] arr){
        int temp;
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}
