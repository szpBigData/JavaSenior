package com.atguigu.Demo;

/**
 * @author sunzhipeng
 * @create 2021-06-20 22:28
 * MergeSort  5行码    外边if别越界   定义mid    递归递归合并
 * Merge   3变量    while 小于等于半边界   挪值
 *
 * t归零    定义templeft   临时合并到正式
 * 归并条件都有等
 *
 *
 *
 */
public class A3 {
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
    public static void Merge(int[] arr,int left,int mid,int right,int[] temp){
        int i=left;
        int j=mid+1;
        int t=0;

        while (i<=mid&&j<=right){
            if (arr[i]<arr[j]){
                temp[t]=arr[i];
                t++;
                i++;
            }else {
                temp[t]=arr[j];
                t++;
                j++;
            }
        }
        while (i<=mid){
            temp[t]=arr[i];
            t++;
            i++;
        }
        while (j<=right){
            temp[t]=arr[j];
            t++;
            j++;
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
