package com.atguigu.Demo;



/**
 * @author sunzhipeng
 * @create 2021-06-20 22:15
 * 特征：1.定义四个量
 * 2.大while  lr不越界
 * 2个while走循环  l>=r越界退出
 * 交换    2个if   判等挪一步    l==r 挪一步
 * 左右递归   外界参数值总在最左边
 */
public class T2 {
    public static void quickSort(int []arr,int left,int right){
        int l=left;
        int r=right;
        int temp;
        int midValue=arr[(left+right)/2];
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
                r++;
            }
            if (arr[r]==midValue){
                l--;
            }
            if (l==r){
                r++;
                l--;
            }
            if (left<r){
                quickSort(arr,left,r);
            }
            if (right>l){
                quickSort(arr,l,right);
            }
        }

    }
    public static void main(String[] args) {
        int [] arr={7,6,8,5,9,4,20,1,3,42};
        System.out.println("排序前");
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        System.out.println("=======================================================");
        quickSort(arr,0,arr.length-1);
        System.out.println("排序后");
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }
}
