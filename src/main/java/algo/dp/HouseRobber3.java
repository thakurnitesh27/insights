package algo.dp;

import algo.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/house-robber-iii/
public class HouseRobber3 {
    public static void main(String[] args) {
TreeNode node=new TreeNode(3,new TreeNode(2,null, new TreeNode(3)),new TreeNode(3,null,new TreeNode(1)));
        System.out.println(new HouseRobber3().rob(node));
    }
    public int rob(TreeNode root){
        Object[] ans=findMax(root);
      return (int)ans[0];

    }

    public Object[] findMax(TreeNode node){

       int ansLeft=0,ansRight=0;
       boolean usedLeftChild=false, usedRightChild=false;
        if(node.left!=null){
           Object[] temp= findMax(node.left);
           ansLeft=(int)temp[0];
           usedLeftChild=(boolean) temp[1];
        }
        if(node.right!=null){
            Object[] temp= findMax(node.right);
            ansRight=(int)temp[0];
            usedRightChild=(boolean) temp[1];
        }

        if(ansLeft+ansRight<node.val){
            return new Object[]{node.val,true};
        }
        if(usedRightChild || usedLeftChild){
           return new Object[]{ansLeft+ansRight,false};
        }
        else {
            return new Object[]{ansLeft+ansRight+node.val,true};
        }
    }

    public int robOld(TreeNode root) {


        Queue<TreeNode> queue=new LinkedList();
        ArrayList<Integer> list=new ArrayList();
        queue.add(root);
        traverseLevelOrder(queue,list);
        int dp[]=new int[list.size()+1];
        dp[0]=0;
        dp[1]=list.get(0);
        for(int i=1;i<list.size();i++){
            dp[i+1]=Math.max(dp[i],dp[i-1]+list.get(i));
        }

        return dp[dp.length-1];

    }

    void traverseLevelOrder(Queue<TreeNode> queue,ArrayList<Integer> arr){
        ArrayList<TreeNode> newElements=new ArrayList();
        int sum=0;
        while(!queue.isEmpty()){
            TreeNode node= queue.poll();
            sum+=node.val;
            if(node!=null){
                if(node.left!=null){
                    newElements.add(node.left);
                }
                if(node.right!=null){
                    newElements.add(node.right);
                }
            }

        }

        arr.add(sum);
        if(newElements.size()>0){
            queue.addAll(newElements);
            traverseLevelOrder( queue, arr);
        }
    }


}
