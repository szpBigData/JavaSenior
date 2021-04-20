package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by YinHU on 2019-11-15.
 */
public class WindowTest {
    public static void main(String[] args) {
        int [] arr={2,65,18,49,34,51,22,10,161,-4,-42};
        quickSort(arr);
    }
    public static void quickSort(int [] arr){
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

        for(int m=0;m<arr.length;m++){
            System.out.print(" "+arr[m]);
        }
    }

}
