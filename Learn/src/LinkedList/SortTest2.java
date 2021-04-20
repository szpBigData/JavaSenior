package LinkedList;

/**
 * Created by YinHU on 2019-11-23.
 */
public class SortTest2 {
    public static void main(String[] args) {




         int [] a1={8,-7,0,25,36,-22,5,33};
         int [] a2={0,-16,5,86,52,-22,13,44};
         int [] a3={16,0,8,15,55,8453,4212,25,-8} ;

         //直接查找
        int result=Directselect(a1,5);
        System.out.println(result);
         bubbleSort(a1);
         selectSort(a2);
         quickSort(a3,0,a3.length-1);
        for(int i=0;i<a1.length;i++){
            System.out.print(a1[i]+" ");
        }

        System.out.println();

        for(int i=0;i<a2.length;i++){
            System.out.print(a2[i]+" ");
        }
        System.out.println();
        for(int i=0;i<a3.length;i++){
            System.out.print(a3[i]+" ");
        }
    }

    //冒泡排序
    public static void bubbleSort(int [] arr){
        for(int i=0;i<arr.length-1;i++){
            int temp=0;
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    //选择排序
    public static void selectSort(int [] arr){
        for (int i=0;i<arr.length-1;i++){
            int min=arr[i];
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(min>arr[j]){
                    min=arr[j];
                    minIndex=j;
                }
            }
            if(minIndex!=i) {
                arr[minIndex]=arr[i];
                arr[i]=min;

            }
        }
    }
    //快速排序
     public static void quickSort(int[] arr,int left,int right){
        int l=left;
        int r=right;
        int pivor=arr[(left+right)/2];
        int temp=0;
        while(l<r){
            while (arr[l]<pivor){
                l=l+1;
            }
            while (arr[r]>pivor){
                r=r-1;
            }
            if(l>=r){
                break;
            }
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            if (arr[l]==pivor){
                r=r-1;
            }
            if(arr[r]==pivor){
                l=l+1;
            }
        }

        if(l==r){
            r=r-1;
            l=l+1;
        }
        if(left<r){
            quickSort(arr,left,r);
        }
        if(l<right){
            quickSort(arr,l,right);
        }
     }
    //直接查找
    public static int  Directselect(int [] arr,int value){
         for(int i=0;i<arr.length;i++){
             
             if(arr[i]==value){
                 return i;
             }
         }
         return -1;
    }
    //二分查找
    public static int binarySelect(int [] arr,int value){
        int left=0;
        int right=arr.length-1;
     
                
        return -1;
    }

}
