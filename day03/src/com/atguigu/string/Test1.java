package com.atguigu.string;

/**
 * Created by YinHU on 2019-11-13.
 */
public class Test1 {
    public static void main(String[] args) {
        String str="asdfgHJkl";
        String str3="ASDFGHJKL";
        System.out.println(str.length());
        System.out.println(str.charAt(4));
        System.out.println(str.isEmpty());
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());
        String str2="   kkfsd  fsf  er   ";
        String str4="孙志鹏";
        System.out.println(str2.trim());
        System.out.println(str.equals(str3));
        System.out.println(str.equalsIgnoreCase(str3));
        System.out.println(str.concat(str4));
        System.out.println(str.substring(2));
        System.out.println(str3.substring(3,7));  //注意这里是左闭右开
        System.out.println(str.startsWith("as"));
        System.out.println(str.startsWith("HU"));
        System.out.println(str.endsWith("kl"));
        System.out.println(str.startsWith("gH",4));//注意这里是指定索引
        System.out.println(str.contains("HJ"));
        System.out.println(str.indexOf("fg"));
        System.out.println(str.indexOf("fg",1));


    }
}
                               