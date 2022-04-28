package algo.dp;

public class JumpGame2 {

    public static void main(String[] args) {
      //  int[]arr=new int[]{2,3,1,4};
        int[]ar5=new int[]{10,9,8,7,6,5,4,3,2,1,1,0};
        System.out.println(findMinJumps(ar5));
        int[]ar4=new int[]{1,2,1,1,1};
        System.out.println(findMinJumps(ar4));
        int[]arr=new int[]{3,2,1};
        System.out.println(findMinJumps(arr));
        int[]arr2=new int[]{2,2,1,4};
        System.out.println(findMinJumps(arr2));
        int[]arr3=new int[]{1,1,1,4,5};
        System.out.println(findMinJumps(arr3));
    }

    static int findMinJumps(int[]arr){
        int dp[]=new int[arr.length];
        dp[arr.length-1]=0;

        for(int i=arr.length-2;i>=0;i--){
           int d1= 1+dp[i+1];
           int jumps=arr[i];
          // int d2=0;
           for(int j=i+1;j<=i+jumps;j++){
               if(j>=arr.length-1){
                  // dp[i]=1;
                   d1=1;
                   break;
               }

               d1=Math.min(d1,1+dp[j]);

           }

           dp[i]=d1;

        }

        return dp[0];

    }


    static int findMinJumpsNormal(int []arr){
        int count=0;
       int index=0;
       while (index<arr.length){
           if(index==arr.length-1){
              // count++;
               break;
           }
           int jump=arr[index];
           if(index+jump>=arr.length-1){
               count++;
               return count;

           }
           int maxJump=jump;
           int newIndex=index;
           for(int i=index+1;i<=Math.min(arr.length-1,index+jump);i++){
              if(maxJump<=arr[i]){
                  maxJump=arr[i];
                  newIndex=i;
              }
           }
           count++;
           if(newIndex==index){
               newIndex=index+arr[index];
           }
           index=newIndex;
       }
       if(index>=arr.length){
           count++;
       }
       return count;
    }
}
