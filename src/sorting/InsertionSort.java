package sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {


        int arr[]=new int[]{4,2,5,3,1,6,9,7,0,8};

        int j=0;
     outer:   for(int i=1;i<arr.length;i++)
        {
            j=i-1;
int num=arr[i];
            while (j>=0&&arr[j]>num)
            {

                 //   int temp=arr[j];
                    arr[j+1]=arr[j];
                  //  arr[j-1]=temp;
                    j--;
                }
           // if(num<arr[j])

           // {
             //   arr[i]=arr[j];
                arr[j+1]=num;
           // }
            }



        Arrays.stream(arr).forEach(System.out::print);


        }


//    }
}
