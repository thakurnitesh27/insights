package tree;

import java.util.concurrent.atomic.AtomicInteger;

public class KthSmallestElement {
    public static void main(String[] args) {

       // TreeNode node=new TreeNode(2,new TreeNode(1),new TreeNode(3));
        TreeNode node=new TreeNode(10,
                new TreeNode(5,new TreeNode(3,null,new TreeNode(4)),
                new TreeNode(9)),new TreeNode(20));
        System.out.println(new KthSmallestElement().find(node,4));
    }

   int find(TreeNode root, int B){
      Object[] obj= inorder(root,0,B);

      if(obj[0]!=null){
         return  ((TreeNode)obj[0]).val;
      }
       return -1;

    }

    Object[] inorder(TreeNode node, Integer i, int B){

        TreeNode ans=null;
        if(node!=null){

            if(node.left!=null) {
                Object[] o= inorder(node.left, i, B);
                ans= (TreeNode) o[0];
                i= (Integer) o[1];
            }

            i++;
            if(i==B){
                return new Object[]{node,i};
            }


               if( node.right!=null && ans==null) {
                   Object[] o= inorder(node.right, i, B);
                       ans = (TreeNode) o[0];
                   i= (Integer) o[1];

                }

            }


        return new Object[]{ans,i};

    }
}
