package com.atguigu.string;

import javax.jws.soap.SOAPBinding;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by YinHU on 2019-11-14.
 */
public class JDK8DateTimeTest {
    public static void main(String[] args) {
//    String str="asdfghjklss";
//    String str2="zxcvb";
//        System.out.println(str.substring(1,6));
//        System.out.println(str.compareTo(str2));
//        int i=str.indexOf('g');
//        int j=str.lastIndexOf('s',5);
//        System.out.println(i);
//        System.out.println(str.length());
//        System.out.println(j);
//        System.out.println(str.replace("fgh","sunzhipeng"));
//        System.out.println(str.replace('k','K'));
        String a="123";
        int i=Integer.parseInt(a);
        System.out.println(i);
        int q=256;
        String as=String.valueOf(q);
        System.out.println(as);
        String b="qwer";
        char[] c=b.toCharArray();
        for(int k=0;k<c.length;k++){
            System.out.println(c[k]);
        }
        char [] spring={'S','p','r','i','n','g'};
        String test=new String(spring);
        System.out.println(test);



    }
}
