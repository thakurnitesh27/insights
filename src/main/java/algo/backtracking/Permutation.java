package algo.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {
    public static void main(String[] args) {
        System.out.println(new Permutation().permute(new int[]{1,2,3}));
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans=new ArrayList<>();

        permute(ans,new ArrayList<>(),nums,0);
        return ans;
    }

    public void permute(List<List<Integer>> ans, List<Integer> list,int[] nums, int index){
        if(list.size()==nums.length){
           // ans.add(new ArrayList(list));
           if (new HashSet<>(list).size()==nums.length){
               ans.add(new ArrayList(list));
            }
            return;
        }
        if(index>nums.length-1){
            return;
        }

        for(int i=0;i<nums.length;i++){
           // list.set(i,nums[i]);
          //  List<Integer> newList=new ArrayList<>(list);
            if(list.size()<=index){
                list.add(nums[i]);
            }else {
                list.set(index,nums[i]);
            }
            permute(ans,list,nums,index+1);
            if(index<list.size())
            list.remove(index);
            // list.s
        }

    }
}
