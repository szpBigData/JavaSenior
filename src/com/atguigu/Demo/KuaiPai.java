package com.atguigu.Demo;

/**
 * @author sunzhipeng
 * @create 2021-06-16 21:09
 */
public class KuaiPai {
    public static void main(String[] args) {
        int [] arr={7,6,8,5,9,4,20,1,3,42};
        System.out.println("排序前");
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        System.out.println("=======================================================");
        QuickSort(arr,0,arr.length-1);
        System.out.println("排序后");
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static void QuickSort(int[] arr,int left,int right){
        int l=left;
        int r=right;
        int mid=arr[(left+right)/2];
        int temp=0;
        while (l<r){
            while (arr[l]<mid){
                l++;
            }
            while (arr[r]>mid){
                r--;
            }
            if (l>=r){
                break;
            }
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            if (arr[l]==mid){
                r=r-1;
            }
            if (arr[r]==mid){
                l=l+1;
            }
            if (l==r){
                l=l+1;
                r=r-1;
            }
            if (left<r){
                QuickSort(arr,left,r);
            }
            if (right>l){
                QuickSort(arr,l,right);
            }
        }

    }
}
