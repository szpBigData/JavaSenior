import org.junit.Test;

import java.util.SortedMap;

/**
 * Created by YinHU on 2019-11-28.
 */
public class Lianxi {
    @Test
   public void test1(){
         int sum=0;
         for(int i=1;i<=99;i=i+2){
             sum=sum+i;
         }
        System.out.println(sum);
   }
   @Test
   public void test2(){
       int [] arr={5,7,3,9,2};
       bubbleSort(arr);
       for(int i=0;i<arr.length;i++){
           System.out.print(arr[i]+" ");
       }
   }
   @Test
   public void test4(){
         long result= f(10000);
       System.out.println(result);
   }
   @Test
   public void test5(){
       long sum=0;
       for(int i=1;i<=20;i++){
           long temp=1;
           for(int j=1;j<=i;j++){
               temp=temp*j;
           }
           sum=sum+temp;
       }
       System.out.println(sum);
   }
   @Test
   public void test6(){
           printStar(5);
   }
   @Test
   public void test7(){
       String str="hello1234";
       StringBuilder s=new StringBuilder(str);
       s.reverse();
       str=s.toString();
       System.out.println(str);
   }
   @Test
   public void test8(){
       String str=fileExtNameFromUrl("http://localhost:8080/testweb/index.html");
       System.out.println(str);
   }
   public static String fileExtNameFromUrl(String url){
         return url.substring(url.lastIndexOf('.')+1);
   }
   public static void printStar(int n){
            for(int i=1;i<=n;i++){
                for(int j=0;j<n-i;j++){
                    System.out.print(" ");
                }
                for(int j=0;j<2*i-1;j++){
                    System.out.print("*");
                }
                System.out.println();
            }
   }
   public static long f(int n){
       long sum=0;
       for(int i=1;i<=n;i++){
           sum=sum+i;
       }
       return sum;
   }
   public static void bubbleSort(int [] arr){
       for(int i=0;i<arr.length-1;i++){
           for(int j=0;j<arr.length-1-i;j++){
               if(arr[j]>arr[j+1]){
                   int temp=arr[j];
                   arr[j]=arr[j+1];
                   arr[j+1]=temp;
               }
           }
       }
   }
   public static void dayOfYear(int year,int month,int day){
       
   }
}
