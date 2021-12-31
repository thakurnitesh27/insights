package tree;

import java.util.HashMap;
import java.util.Map;

public class TwoSumBinaryTree {
    public static void main(String[] args) {

        TreeNode  root=new TreeNode(10,new TreeNode(9),new TreeNode(20));
        System.out.println(new TwoSumBinaryTree().find(root,19));

    }

   int find(TreeNode root, int B){

       HashMap<Integer,Object> map=new HashMap<>();

      boolean ans= inOrder(root,19,map);

      return ans?1:0;



    }
   boolean inOrder(TreeNode node, int B, HashMap<Integer,Object> map){

        if(node!=null){

            if(map.get(B-node.val)!=null){
                return true;
            }
            else {
                map.put(node.val,new Object());
            }
          boolean leftResponse= inOrder(node.left,B,map);

            if(!leftResponse){
               return inOrder(node.right,B,map);

           }
           else {
               return leftResponse;
            }

        }
        return false;

    }
}
