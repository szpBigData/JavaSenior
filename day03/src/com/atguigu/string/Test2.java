package com.atguigu.string;

/**
 * Created by YinHU on 2019-11-13.
 */
public class Test2 {
    public static void main(String[] args) {
        String str="北京尚硅谷教育";
        String str2=str.replace("北京","上海");
        System.out.println(str2);
        String str4="123";
        int i=Integer.parseInt(str4);
        System.out.println(i);
        int m=6;
        String temp=String.valueOf(m);
        System.out.println(temp);

        String sun="1234";
        char[] ch=sun.toCharArray();
        for (int t=0;t<ch.length;t++){
            System.out.print(ch[t]+" ");
        }
        char [] asd={'s','u','n','y','x','y'};
        String ing=new String(asd);
        System.out.println(ing);
        
    }
}
