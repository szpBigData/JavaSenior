/**
 * Created by YinHU on 2019-11-22.
 */
public class SortTest {
    public static void main(String[] args) {
             int [] a1={26,1,-8,-66,52,42,58,4,88};
             int [] a2={14,0,-8,55,12,36,59,64,28,-5,22};
             int [] a3={-8,-26,7,0,66,53,84,58,74,15,77};
             int result=select(a1,42);
        System.out.println(result);

              bubbleSort(a1);

              selectSort(a2);

              quickSort(a3,0,a3.length-1);
              for (int i=0;i<a1.length;i++){
                  System.out.print(" "+a1[i]);
              }
        System.out.println();
              for (int i=0;i<a2.length;i++){
                    System.out.print(" "+a2[i]);
              }
        System.out.println();
        for (int i=0;i<a3.length;i++){
            System.out.print(" "+a3[i]);
        }
        System.out.println();
          int erfen=erFenSearch(a3,7);
        System.out.println(erfen);


    }
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
    public static void selectSort(int [] arr){
        for(int i=0;i<arr.length-1;i++){
            int min=arr[i];
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(min>arr[j]){
                    min=arr[j];
                    minIndex=j;
                }
            }
            if(minIndex!=i){

               arr[minIndex]=arr[i];
                arr[i]=min;
            }
        }
    }
    public static void quickSort(int [] arr,int left,int right){
        int l=left;
        int r=right;
        int temp=0;
        int pivor=arr[(left+right)/2];
        while (l<r){
            while (arr[l]<pivor){
                l=l+1;
            }
            while(arr[r]>pivor){
                r=r-1;
            }
            if(l>=r){
                break;
            }

            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;

            if(arr[l]==pivor){
                r=r-1;
            }
            if(arr[r]==pivor){
                l=l+1;
            }
        }
        if(l==r){
            l=l+1;
            r=r-1;
        }
        if(left<r){
            quickSort(arr,left,r);
        }
        if(l<right){
            quickSort(arr,l,right);
        }

    }
    public static void insertSort(int [] arr,int value){
        
    }
    public static int  select(int [] arr,int value){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==value){
                return i;
            }
        }
        return -1;
    }
    //二分查找，非递归
    public static int binarySearch(int [] arr,int target){
        int left=0;
        int right=arr.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==target){
                return mid;
            }  else if(arr[mid]>target){
                right=mid-1;
            } else{
                left=mid+1;
            }
        }
        return -1;
    }
    public static int erFenSearch(int [] arr,int value){
        int left=0;
        int right=arr.length-1;
        while (left<=right){
            int mid =(left+right)/2;
            if(arr[mid]==value){
                return mid;
            } else if(arr[mid]>value){
                right=right-1;
            } else {
                left =left+1;
            }

        }
        return -1;
    }
}
