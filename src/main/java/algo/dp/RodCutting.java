package algo.dp;

import java.util.stream.IntStream;

public class RodCutting {

    public static void main(String[] args) {

        int arr[]=new int[]{1,5,8,9,10,17,17,20,24,30};

       // System.out.println(new RodCutting().cutRodRecursively(arr,4));
      //  System.out.println(new RodCutting().cutRodTopDown(arr,4));
        System.out.println(new RodCutting().cutRodBottomUp(arr,10));
    }

    int cutRodRecursively(int[]arr, int length){

        if(length==0)
            return 0;

        int max=Integer.MIN_VALUE;

        for(int i=1;i<=length;i++){
            int tmp=cutRodRecursively(arr,length-i);

            max=Math.max(max,arr[i-1]+tmp);
        }

        return max;

    }

    int cutRodTopDown(int[]arr, int length){

        int values[]=new int[arr.length];
        IntStream.range(0,length).forEach(value -> values[value]=-1);

        return cutRodTopDownAux(arr,length,values);

    }

    int cutRodTopDownAux(int[] arr, int length, int[] values){

        if(length==0){
            return 0;
        }
        if(values[length-1]>-1){
            return values[length-1];
        }

        int max= Integer.MIN_VALUE;
        for(int i=1;i<=length;i++){
           max= Math.max(max,arr[i-1]+cutRodTopDownAux(arr,length-i,values));
        }
        values[length-1]=max;

        return max;
    }

    int cutRodBottomUp(int[]arr, int length){

      int []values=new int[arr.length+1];
      values[0]=0;

      for(int i=1;i<=length;i++){

          int max=Integer.MIN_VALUE;
          for(int j=1;j<=i;j++){

               max=Math.max(max,arr[j-1]+values[i-j]);
          }

          values[i]=max;
      }
      return values[length];
    }
}
