package com.atguigu.string;

/**
 * Created by YinHU on 2019-11-14.
 */
public class kuaipai {
    public static void main(String[] args) {
                 int arr[]={7,35,-7,-2,0,9,15,21,55,66}      ;
                 quickSort(arr,0,arr.length-1);
                 for(int i=0;i<arr.length;i++) {
                     System.out.print(arr[i]+" ");
                 }
    }
    public static void quickSort(int [] arr,int left,int right){
        int l=left;
        int r=right;
        int mid=arr[(left+right)/2];
        int temp;
        while (l<r){
            while(arr[l]<mid){
                l=l+1;
            }
            while(arr[r]>mid){
                r=r-1;
            }
            if(l>=r){
                break;
            }
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;

            if(arr[l]==mid){
                r=r-1;
            }
            if(arr[r]==mid){
                l=l+1;
            }
        }
        if(l==r){
            l=l+1;
            r=r-1;

        }
        if(left<r){
            quickSort(arr,left,r);

        }
        if(l<right){
            quickSort(arr,l,right);
        }
        }

}
