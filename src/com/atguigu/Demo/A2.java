package com.atguigu.Demo;

/**
 * @author sunzhipeng
 * @create 2021-06-19 17:39
 * 归并排序
 */
public class A2 {
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
    public static void MergeSort(int []arr,int left,int right,int [] temp){
        if (left<right){
            int mid=(left+right)/2;
            MergeSort(arr,left,mid,temp);
            MergeSort(arr,mid+1,right,temp);
            Merge(arr,left,mid,right,temp);
        }
    }
    public static void Merge(int[]arr,int left,int mid,int right,int[] temp){
        int i=left;
        int j=mid+1;
        int t=0;
        while (i<=mid&&j<=right){
            if (arr[i]<arr[j]){
                temp[t]=arr[i];
                i++;
                t++;
            }else {
                temp[t]=arr[j];
                j++;
                t++;
            }
        }

        while (i<=mid){
            temp[t]=arr[i];
            i++;
            t++;
        }

        while (j<=right){
            temp[t]=arr[j];
            j++;
            t++;
        }
        t=0;
        int tempLeft=left;
        while (tempLeft<=right){
            arr[tempLeft]=temp[t];
            tempLeft++;
            t++;
        }
    }
}
