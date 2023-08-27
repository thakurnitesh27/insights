package algo.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
public class CombinationSum {

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2,3,6,7},7));
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        combination(candidates,ans,new ArrayList<>(),0,0,target);
        return ans;
    }

    private void combination(int[] candidates, List<List<Integer>> ans, ArrayList<Integer> probableAnswer, int index, int sum, int target) {

        if(sum==target){
            ans.add(probableAnswer);
            return;
        }
        if(sum>target){
            return;
        }
        for(int i=index;i<candidates.length;i++){
            sum+=candidates[i];
            probableAnswer.add(candidates[i]);
            combination(candidates,ans,probableAnswer,i,sum,target);
        }

    }

//    void combination(int[] candidates,List<List<Integer>> ans,List<Integer> probableAnswer,int startIndex, int sum, int target){
//
//        if(sum==target){
//            ans.add(new ArrayList<>(probableAnswer));
//            return;
//        }
//        if(sum>target){
//            return;
//        }
//
//        for(int i=startIndex;i<candidates.length;i++){
//            List<Integer> newList=new ArrayList<>(probableAnswer);
//            newList.add(candidates[i]);
//            combination(candidates,ans,newList,i,sum+candidates[i],target);
//            newList.remove((Integer)candidates[i]);
//        }
//    }
}
