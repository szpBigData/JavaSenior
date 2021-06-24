package com.atguigu.java;

import com.sun.istack.internal.FinalArrayList;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.omg.CORBA.RepositoryIdHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.UnknownFormatConversionException;

/**
 * @author sunzhipeng
 * @create 2021-06-14 22:33
 * 1.left>right  直接返回空数组列表
 * 2.定义中值指标   定义中值
 * 3.findValue>中值  向右递归
 * 4.finadValue<中值   向左递归
 * 5.其他
 *     --定义数组list存储索引
 *     --temp=中值索引-1
 *        --若果temp<0或者arr[temp]!=要找的值   退出
 *        --把temp加入数组中
 *        --temp=temp-1;
 *     --resIndexlis.add(mid);
 *     --temp=中值索引+1
 *     --若果temp>arr.length-1或者arr[temp]!=要找的值   退出
 *     --把temp加入数组中
 *        --temp=temp+1;
 *6.返回resIndexlis
 */
public class SearchTest {
    public static void main(String[] args) {
        int arr[]={1,8,10,89,1000,1000,1234};
        List<Integer> resIndexList=binarySearch(arr,0,arr.length-1,1000);
        System.out.println("resIndexList="+resIndexList);
    }
    public  static List<Integer> binarySearch(int [] arr, int left, int right, int findValue){
        //当left>right时，说明递归整个数组，但是没有找到
        if (left>right){
            return new ArrayList<Integer>();
        }
        int mid=(left+ right)/2;
        int midValue=arr[mid];
        if (findValue>midValue){
            //向右递归
            return binarySearch(arr,mid+1,right,findValue);
        }else if(findValue<midValue){
            return binarySearch(arr,left,mid-1,findValue);
        }else{
            List<Integer> resIndexlis=new ArrayList<Integer>();
            //向mid索引值的左边扫描，将所有满足条件的元素下标添加到集合中
            int temp=mid-1;
            while (true){
                if (temp<0||arr[temp]!=findValue){
                    //退出
                    break;
                }
                //否则，就temp放入到resindexlist
                resIndexlis.add(temp);
                //temp左移
                temp=temp-1;
            }
            resIndexlis.add(mid);
            //向mid索引值的右边扫描，将所有满足条件的元素下标，加入得到集合ArrayList
            temp=mid+1;
            while (true){
                if (temp>arr.length-1||arr[temp]!=findValue){
                    //退出
                    break;
                }
                //否则，就temp放入到resIndexlist中
                resIndexlis.add(temp);
                temp=temp+1;
            }
            return resIndexlis;
        }
    }
}
