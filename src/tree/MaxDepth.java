package tree;

public class MaxDepth {
    public static void main(String[] args) {

    }

   int find(TreeNode root){

        if(root!=null){

           int leftDepth= find(root.left);
           int rightDepth=find(root.right);
           return Math.max(leftDepth,rightDepth)+1;
        }
        return 0;
   }
}
