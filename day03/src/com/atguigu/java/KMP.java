package com.atguigu.java;

/**
 * Created by YinHU on 2019-11-14.
 */
public class KMP {
    public static void main(String[] args) {
        //测试暴力匹配算法
//        String str1="硅硅谷 尚硅谷 你尚硅 尚硅谷你尚硅谷你尚硅你好";
//        String str2="尚硅谷你尚硅谷你";
//        int index=violenceMatch(str1,str2);
//        System.out.println("index="+index);
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";

    }





    //暴力匹配
    public static int violenceMatch(String str1,String str2){
        char[] s1=str1.toCharArray();
        char[] s2=str2.toCharArray();
        int s1Len=s1.length;
        int s2Len=s2.length;
        int i=0;// i索引指向s1
        int j=0;// j索引指向s2
        while (i<s1Len&&j<s2Len){      //保证匹配时不越界
            if(s1[i]==s2[j]){    //匹配OK
                i++;
                j++;
            }   else{      //如果没有匹配成功
                //如果失配（即str1[i]==str2[j]),令i=i-(j-1),j=0
                i=i-(j-1);
                j=0;
            }
            
        }
        //判断是否匹配成功
        if(j==s2Len){
            return i-j;
        }else{
            return -1;
        }
    }
         //获取到一个字符串（子串）的部分匹配值表
    public static int[] kmpNext(String dest){
        //创建一个next数组保存部分匹配值
            int [] next=new int[dest.length()];
            next[0]=0;//如果字符串是长度为1部分匹配值就是0
        for(int i=1,j=0;i<dest.length();i++){
            //当dest.charAt(i)!=dest.charAt(j),我们需要从
            // next[j-1]获取新的j
            //直到我们发现有dest.charAt(i)==dest.charAt(j)成立时才退出
            //
        }
        return next;
    }

    
}
