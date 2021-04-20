package com.atguigu.java;

import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by YinHU on 2019-11-13.
 */
public class DemoDate {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
        LocalDateTime date=LocalDateTime.of(2019,2,26,12,46,25);
        System.out.println(date.getDayOfYear());
        System.out.println(date.getMinute());


        
    }                  
}
