package algo.tree;

//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/submissions/
public class FlatternBinaryTreeToLinkedList {
    public static void main(String[] args) {

        TreeNode node=new TreeNode(1,new TreeNode(2,new TreeNode(3,null,null),new TreeNode(4)),
                new TreeNode(5,null,new TreeNode(6)));
        new FlatternBinaryTreeToLinkedList().flatten(node);

         node=new TreeNode(1,null,
                new TreeNode(2,new TreeNode(3),null));

        new FlatternBinaryTreeToLinkedList().flatten(node);

    }

    void flatten(TreeNode node){

        TreeNode parentNode=node;
        doFlatten(node,node);

        System.out.println(parentNode);


    }

    void doFlatten(TreeNode node,TreeNode parentNode){
//        if(node!=null) {
//
            if(node!=null && node.left!=null) {
                TreeNode rightNode = node.right;
                node.right = node.left;
                // node.left = null;
                doFlatten(node.left, parentNode);
                node.left=null;
                node = node.right;

                if (node != null) {
                   // node.left = null;

                    if (rightNode != null) {

                        while (node.right != null) {
                            node = node.right;
                        }
                        node.right = rightNode;
                        doFlatten(rightNode, parentNode);
                    }
                }
            }
            else if(node!=null && node.right!=null) { //case where node contains only right node. And this right subtree may contain left subtrees  Eg: [1,null,2,3,null]
                doFlatten(node.right,parentNode);
            }
       // }
       // return node;
    }
}
