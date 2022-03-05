package algo.misc;
//https://leetcode.com/problems/max-consecutive-ones-iii/submissions/
public class MaxContinuousSeries {
    public static void main(String[] args) {
       // int arr[]=new int[]{1,1,1,0,0,0,1,1,1,1,0};
        // int k=2;
        int arr[]=new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k=3;

        System.out.println(new MaxContinuousSeries().findNew(arr,k));
    }

   int  find(int[]arr,int k){

        int count=0;
        int indexBegin=0;
        int max=Integer.MIN_VALUE;
        int maxIndex=0;
        for(int i=0;i<arr.length;i++){

            if(arr[i]==1){

                if(i>0 && arr[i-1]==0){
                    indexBegin=i;
                    count=0;
                }
                count++;
                if(count>max){
                    max=count;
                    maxIndex=i;
                }

            }
            else if(i>0 && arr[i-1]==1) {//first zero after 1.

                for(int j=indexBegin;j<i;j++){
                    arr[j]=count;
                }

            }


        }

        int ascCount=max,descCount=max;

        int k1=k;
      for(int i=maxIndex+1;i<arr.length;i++){
          if(k1<=0){
              break;
          }
          if( arr[i]==0){
              ascCount++;
                  k1--;
          }else if(arr[i-1]==0){
              ascCount+=(arr[i]);
          }
      }

      int k2=k;

      for(int i=maxIndex-1;i>=0;i--){
          if(k2<=0){
              break;
          }

          if( arr[i]==0){
              descCount++;
              k2--;
          }else if(arr[i+1]==0){
              descCount+=(arr[i]);
          }
      }



      return Math.max(ascCount,descCount);

    }


    int findNew(int[]arr,int k){

        int wl=0,wr=0;
        int zerCount=0;
        int maxWindow=Integer.MIN_VALUE;

        //for(int i=1;i<arr.length;i++){
        while (wr<arr.length){

            if(arr[wr]==1){
                wr++;
            }
            else if(arr[wr]==0){

                if(zerCount<k){
                    zerCount++;
                    wr++;
                }
                else {
                    if(arr[wl]==0){
                        zerCount--;
                    }
                    wl++;
                }
            }
            maxWindow=Math.max(maxWindow,wr-wl);
        }

        return maxWindow;
    }
}
