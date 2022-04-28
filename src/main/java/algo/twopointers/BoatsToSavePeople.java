package algo.twopointers;

import java.util.Arrays;

//https://leetcode.com/problems/boats-to-save-people/submissions/
public class BoatsToSavePeople {
    public static void main(String[] args) {
        int []arr=new int[]{2,49,10,7,11,41,47,2,22,6,13,12,33,18,10,26,2,6,50,10};
        System.out.println(new BoatsToSavePeople().minimumBoats(arr,50));
         arr=new int[]{445,597,385,576,291,190,187,613,657,477};
        System.out.println(new BoatsToSavePeople().minimumBoats(arr,1000));
       arr=new int[]{3,2,2,2,3}; //1,2,2,3,4
        System.out.println(new BoatsToSavePeople().minimumBoats(arr,6));
       arr=new int[]{3,5,3,4};
        System.out.println(new BoatsToSavePeople().minimumBoats(arr,5));
      arr=new int[]{3,8,7,1,4};
        System.out.println(new BoatsToSavePeople().minimumBoats(arr,9));
    }

   int minimumBoats(int []arr, int limit){

        int min=1,max=arr.length;

        return findUsingTwoPointer(arr,limit);
    }

    int findUsingTwoPointer(int [] arr,int limit){

        Arrays.sort(arr);
        int i=0,j=arr.length-1;
        int leftSum=arr[i];
        int rightSum=arr[j];
        int boatCount=0;


        while (i<=j){
            leftSum=arr[i];
            rightSum=arr[j];
            int sum=leftSum+rightSum;
            if(i==j){
                sum=leftSum;
            }
            if(sum<=limit){
               // i++;
               int k=i;
                findOptimal(arr,++k,j,limit);
                boatCount++;
            }
            else if(leftSum+rightSum>limit){
                boatCount++;
                j--;
            }
            while (i<arr.length && arr[i]==-1 )
            {
                i++;
            }

            while (j>0 &&arr[j]==-1){
               j--;
            }


        }
        return boatCount;
    }

    void findOptimal(int []arr,int i,int j,int limit){
        int lastIndex=i;
        boolean optimalFound=false;
        while (i<j){
            while (arr[i]==-1){
                i++;
            }
            if(i==j){
                break;
            }

            if(i<arr.length &&arr[i]+arr[j]<=limit){
                optimalFound=true;
                lastIndex=i;
                i++;
            }
            else {
                break;
            }
        }
        arr[optimalFound?lastIndex:lastIndex-1]=-1;
        arr[j]=-1;
    }

    int find(int[]arr, int min,int max,int ans,int limit){

        if(min<=max){

            int mid= (min+max)/2;

           boolean isFeasible= isFeasible(arr,mid,limit);

           if(isFeasible){
               if(mid<ans){
                   ans=mid;
               }
               return find(arr,min,mid-1,ans,limit);
           }
           return find(arr,mid+1,max,ans,limit);

        }
        return ans;

    }

    boolean isFeasible(int [] arr,int noOfBoats, int limit){

        int boatCount=1;
        int sum=0;
        for(int i=0;i<arr.length;i++){

            sum+=arr[i];
            if(sum>limit){
                boatCount++;
                sum=arr[i];
            }
        }

        if(boatCount<=noOfBoats){
            return true;
        }
        return false;
    }
}
