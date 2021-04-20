package com.atguigu.HashLearn;

import java.io.*;

/**
 * Created by YinHU on 2019-11-20.
 */
public class StreamLearn {
    public static void main(String[] args) throws IOException {
        FileReader fr=null;
        try {
            fr=new FileReader(new File("D:\\杨晓宇\\szp\\hahha.txt"));
            char[] ch=new char[1024];
            int length;
            while ((length=fr.read(ch))!=-1){
                System.out.println(new String(ch,0,length));
            }
        } catch(IOException e){
            e.printStackTrace();
        } finally {
            if(fr!=null){
                 try{
                     fr.close();
                 }catch (IOException e){
                     System.out.println("close-Exception:"+e.getMessage());
                 }
            }
        }

    }
}
