package com.atguigu.string;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

/**
 * Created by YinHU on 2019-11-13.
 */
public class Test3 {
    public static void main(String[] args) {
        String a="123abc";
        byte[] bytes=a.getBytes();
        System.out.println(Arrays.toString(bytes));
        byte [] bytes1={54,57,42,98,99,68};
        String s=new String(bytes1);
        System.out.println(s);
        

    }
}
