package com.atguigu.string;

/**
 * Created by YinHU on 2019-11-14.
 */
public class Test4 {
    public static void main(String[] args) {
        String  str="asdfghjkl";
        String result=reverse2(str,2,5)     ;
        System.out.println(result);
    }
      //方式一
    public static String reverse(String str,int startIndex,int endIndex) {
        char[] arr = str.toCharArray();
        for (int x = startIndex, y = endIndex; x < y; x++, y--) {
            char temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }
        return new String(arr);
    }
    //方式二
    public static String reverse1(String str,int startIndex,int endIndex){
        if(str!=null){
             //第一部分
            String reverseStr=str.substring(0,startIndex);
            //第二部分
            for (int i=endIndex;i>=startIndex;i--){
                reverseStr=reverseStr+str.charAt(i);
            }
            //第三部分
            reverseStr+=str.substring(endIndex+1);
            return reverseStr;
        }
            return null;
    }
    //方式3 使用stringBuffer和StringBuilder来替换
    public static String reverse2(String str,int startIndex,int endIndex){
        if(str!=null){
            //第一部分
            StringBuilder builder=new StringBuilder(str.length());
            //第二部分
            builder.append(str.substring(0,startIndex));
            for (int i=endIndex;i>=startIndex;i--){
                builder.append(str.charAt(i));
            }
            //第三部分
            builder.append(str.substring(endIndex+1));
            return builder.toString();
        }
        return null;
    }
    
    
    
}
