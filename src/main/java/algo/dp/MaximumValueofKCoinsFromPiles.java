package algo.dp;
//https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/

import java.util.*;

public class MaximumValueofKCoinsFromPiles {

    public static void main(String[] args) {
        List<List<Integer>> list=new ArrayList<>();
       list.add( Arrays.asList(new Integer[]{100,100,100}));
        list.add(Arrays.asList(new Integer[]{100,200}));
        list.add(Arrays.asList(new Integer[]{1,1,300}));

        System.out.println(new MaximumValueofKCoinsFromPiles().maxValueOfCoins(list,3));
    }

    public int maxValueOfCoins(List<List<Integer>> piles, int k){


        for(int i=0;i<piles.size();i++) {
            List<Integer> currentPile = piles.get(i);
            int j = 1;
            for (; j < currentPile.size(); j++) {
                currentPile.set(j, currentPile.get(j) + currentPile.get(j - 1));
            }
        }

        int count=0;

        Set<Integer> excludeSet=new HashSet<>();
        int ans=0;
        while (count<=k){
            excludeSet=new HashSet<>();
            int ans1=0,ans2=0;
            if(count>0)
            ans1= findMax(piles,count,excludeSet);
            if(k-count>0)
            ans2= findMax(piles,k-count,excludeSet);
            ans=Math.max(ans1+ans2,ans);

        }
        return ans;
    }

    int findMax(List<List<Integer>> pile,int depth,Set<Integer> excludeSet){

        return 0;
    }

//    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
//        Integer[][] memo = new Integer[piles.size() + 1][k + 1];
//
//        return dp(piles, memo, 0, k);
//    }
//    public int dp(List<List<Integer>> piles, Integer[][] memo, int i, int k) {
//        if (k == 0 || i == piles.size()) return 0;
//        if (memo[i][k] != null) return memo[i][k];
//
//        int res = dp(piles, memo, i + 1, k);
//        int cur = 0;
//
//        for (int j = 0; j < Math.min(piles.get(i).size(), k); ++j) {
//            cur += piles.get(i).get(j);
//            res = Math.max(res, cur + dp(piles, memo, i + 1, k - j - 1));
//        }
//        return memo[i][k] = res;
//    }

    public int maxValueOfCoinsOld(List<List<Integer>> piles, int k) {

        int maxSize=0;

        for(int i=0;i<piles.size();i++){
            maxSize=Math.max(maxSize,piles.get(i).size());
        }

        for(int i=0;i<piles.size();i++){
           List<Integer> currentPile=piles.get(i);
            int j=1;
            for(;j<currentPile.size();j++){
                currentPile.set(j,currentPile.get(j)+currentPile.get(j-1));
            }

           //  j=maxSize-currentPile.size();
//          for(;j<maxSize;j++){
//              currentPile.add(0);
//          }
        }

        int count=k;

        int max=0;

        int dp[][]=new int[k+1][];
        int indexes[]=new int[piles.size()];


        for(int i=1;i<dp.length;i++){
            int t=i;

            for(;t>0;t--){

            }
        }
        for(int i=1;i<=count;i++){
          //  findMaximum()
        }

        while (count>0){

          int ans[]= findMaximum(piles,count);
          max=Math.max(ans[0],max);
            Set<Integer> set=new HashSet<>();

            for(int i=1;i<count;i++){
              ans=  findMaximum(piles, count-i);
              set.add(ans[1]);

            //  findMaximum(piles,)
            }


          //count

        }



        return 0;

    }

    int[] findMaximum(List<List<Integer>> piles,Integer k){
        if(k<1){
            return new int[]{0,-1};
        }
        int max=0;
        int index=0;
        for(int i=0;i<piles.size();i++){

            if(k>piles.get(i).size()){
                continue;
            }
           // max=Math.max(piles.get(i).get(k-1),max);
            if(piles.get(i).get(k-1)>max){
                max=piles.get(i).get(k-1);
                index=i;
            }
        }

        return new int[]{max,index};

    }
}
