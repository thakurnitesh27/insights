package algo.tree;

//https://leetcode.com/problems/insert-into-a-binary-search-tree/

public class InsertIntoBST {

    public static void main(String[] args) {
      TreeNode n=  new TreeNode(4, new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(7));
      insertIntoBST(n,5);
    }

    public static TreeNode insertIntoBST(TreeNode root,int val){

        TreeNode n=root;
        TreeNode lastNode=null;
        while (n!=null){

            if(val<n.val){
                lastNode=n;
                n=n.left;
            }
            else {
                lastNode=n;
               n= n.right;
            }
        }

        if(lastNode==null){
            root=new TreeNode(val);
        }

        if(val<lastNode.val){
            lastNode.left=new TreeNode(val);
        }
        else {
            lastNode.right=new TreeNode(val);
        }

        return root;


    }
}
