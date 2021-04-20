package com.atguigu.HashLearn;

import java.io.File;

/**
 * Created by YinHU on 2019-11-20.
 */
public class FileLearn {
    public static void main(String[] args) {

        File file=new File("D:/abc");
        if(!file.exists()) {
            file.mkdir();
        }
        File file2=new File(file,"szp");
        if(!file2.exists()) {
            file2.mkdir();
        }
        System.out.println(file2.getName());
        System.out.println(file2.getPath());
        System.out.println(file.renameTo(new File("D:/杨晓宇")));
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file2.getParent());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(file.isHidden());

    }
}
