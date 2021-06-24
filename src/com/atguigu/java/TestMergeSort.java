package com.atguigu.java;

/**
 * @author sunzhipeng
 * @create 2021-06-12 21:28
 */
public class TestMergeSort {
    public static void main(String[] args) {
        int [] arr={7,6,8,5,9,4,20,1,3,42};
        System.out.println("排序前");
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        System.out.println("=======================================================");
        int [] temp=new  int[arr.length];
        MergeSort(arr,0,arr.length-1,temp);
        System.out.println("排序后");
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static void MergeSort(int[] arr,int left,int right,int [] temp){
        if (left<right){
            int mid=(left+right)/2;
            MergeSort(arr,left,mid,temp);
            MergeSort(arr,mid+1,right,temp);
            Merge(arr,left,mid,right,temp);
        }

    }
    public static void Merge(int[] arr,int left,int mid,int right,int[] temp){
        int l=left;
        int r=mid+1;
        int t=0;
        while (l<=mid&&r<=right){
            if (arr[l]<=arr[r]){
                    temp[t]=arr[l];
                    t++;
                    l++;
            }else
            {
                temp[t]=arr[r];
                t++;
                r++;
            }
        }
        while (l<=mid){
            temp[t]=arr[l];
            t++;
            l++;
        }
        while (r<=right){
            temp[t]=arr[r];
            t++;
            r++;
        }
        t=0;
        int tempLeft=left;
        while (tempLeft<=right){
            arr[tempLeft]=temp[t];
            t++;
            tempLeft++;
        }
    }
}
