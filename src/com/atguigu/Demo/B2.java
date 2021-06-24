package com.atguigu.Demo;

/**
 * @author sunzhipeng
 * @create 2021-06-21 22:23
 */
public class B2 {
    public static void main(String[] args) {

    }
    public static void QuickSort(int[] arr,int left,int right){
        int l=left;
        int r=right;
        int midValue=arr[(left+right)/2];
        int temp;
        while (l<r){
            while (arr[l]<midValue){
                l++;
            }
            while (arr[r]>midValue){
                r--;
            }
            if (l>=r){
                break;
            }
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            if (arr[l]==midValue){
                r--;
            }
            if (arr[r]==midValue){
                l--;
            }
            if (arr[l]==arr[r]){
                l--;
                r++;
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
