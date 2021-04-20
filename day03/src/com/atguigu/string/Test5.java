package com.atguigu.string;

/**
 * Created by YinHU on 2019-11-14.
 */
public class Test5 {
    public static void main(String[] args) {
           String mainStr="abkkcadkabkebfkaabkskab";
           String substr="ab";
           int count=getCount(mainStr,substr);
        System.out.println(count);
    }

    public static int getCount(String mainStr, String subStr) {
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;
        if(mainLength>=subLength){
//                while((index=mainStr.indexOf(subStr))!=-1){
//                    count++;
//                    mainStr=mainStr.substring(index+subStr.length());
//                }
            //改进
            while ((index=mainStr.indexOf(subStr,index))!=-1){
                count++;
                index+=subLength;

            }
            return count;
        } else{
            return 0;
        }


    }
}
