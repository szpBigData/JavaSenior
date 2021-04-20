package com.atguigu.HashLearn;

import java.io.File;
import java.io.FileWriter;

/**
 * Created by YinHU on 2019-11-20.
 */
public class WriterLearn {
    public static void main(String[] args) {
        FileWriter fw=null;
        try{
              fw=new FileWriter(new File("D:/杨晓宇/Test.txt"));
              fw.write("三十年河西，三十年河东，莫欺少年穷");

        }catch(Exception e){
                    e.printStackTrace();
        }finally{
              if(fw!=null){
                  try{
                      fw.close();
                  } catch (Exception e){
                      e.printStackTrace();
                  }
              }
        }
    }
}
