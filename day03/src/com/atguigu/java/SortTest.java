package com.atguigu.java;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by YinHU on 2019-11-13.
 */
public class SortTest {
    public static void main(String[] args) {
        int [] arr1={12,2,-7,-36,85,64,34,28};
        int [] arr2={7,28,67,48,36,-8,-36,66};
        int [] arr3={-12,8,24,-9,55,27,68,99};
        bubbleSort(arr1);
        selectSort(arr2);
        qucickSort(arr3,0,arr3.length-1);
        for(int i=0;i<arr1.length;i++){
            System.out.print(arr1[i]+" ");
        }
        System.out.println();
        for(int i=0;i<arr1.length;i++){
            System.out.print(arr2[i]+" ");
        }
        System.out.println();
        for(int i=0;i<arr1.length;i++){
            System.out.print(arr3[i]+" ");
        }

    }
    //冒泡排序
    public static void bubbleSort(int [] arr){
        for(int i=0;i<arr.length-1;i++){
            int temp=0;
            for(int j=0;j<arr.length-1-i;j++){
                        if(arr[j]>arr[j+1]){
                            temp=arr[j];
                            arr[j]=arr[j+1];
                            arr[j+1]=temp;
                        }
            }
        }
    }
    //选择排序
    public static void selectSort(int [] arr){
            for(int i=0;i<arr.length-1;i++){
                int min=arr[i];
                int minIndex=i;
                for(int j=i+1;j<arr.length;j++){
                    if(min>arr[j]){
                        min=arr[j];
                        minIndex=j;
                    }
                }
                 if(minIndex!=i){
                        arr[minIndex]=arr[i];
                        arr[i]=min;
                     
                 }
            }
    }

    //快速排序
    public static void qucickSort(int [] arr,int left,int right){
           int l=left;
           int r=right;
           int pivor=arr[(left+right)/2];
           int temp=0;
           while(l<r){
               while(arr[l]<pivor){
                   l=l+1;
               }
               while(arr[r]>pivor){
                   r=r-1;
               }
               if(l>=r){
                   break;
               }
               temp=arr[l];
               arr[l]=arr[r];
               arr[r]=temp;

               if(arr[l]==pivor){
                   r=r-1;
               }
               if(arr[r]==pivor){
                   l=l+1;
               }

           }
           if(l==r){
               r=r-1;
               l=l+1;
           }
           if(left<r){
               qucickSort(arr,left,r);
           }
           if(l<right){
               qucickSort(arr,l,right);
           }
    }

    //简单选择
    public static int select(int arr[],int value){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==value){
                   return i;
            }
        }
        return -1;
    }
}
