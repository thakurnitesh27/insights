package algo.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BurnTree {
    public static void main(String[] args) {

//        TreeNode root = new TreeNode(1, new TreeNode(2,
//                new TreeNode(4), new TreeNode(5, new TreeNode(7), new TreeNode(8)))
//                , new TreeNode(3, null,
//                new TreeNode(6, null, new TreeNode(9, null, new TreeNode(10)))));
//        System.out.println(new BurnTree().burn(root, 8));

//        TreeNode root = new TreeNode(21, new TreeNode(9,
//                new TreeNode(15,new TreeNode(21),new TreeNode(4,null,new TreeNode(12))),
//                new TreeNode(2,null,new TreeNode(1)))
//                , new TreeNode(6, null,
//                new TreeNode(3, null, new TreeNode(19))));
//
//
//        System.out.println(new BurnTree().burn(root, 12));


        TreeNode root = new TreeNode(13, new TreeNode(10,
                new TreeNode(11),null),
                new TreeNode(3,new TreeNode(13,new TreeNode(4),null),new TreeNode(8)));


        System.out.println(new BurnTree().burn(root, 4));
    }

    int burn(TreeNode root, int B) {

        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode node = findNode(root, B, queue);

        ((LinkedList<TreeNode>) queue).add(0, node);

        int index = 1;
        int time = 1;

        while (index < queue.size()) {

            TreeNode n = ((LinkedList<TreeNode>) queue).get(index);
            // if(n.left!=null)o{
            if (n.left != null && n.left.val == ((LinkedList<TreeNode>) queue).get(index - 1).val) {
                // time+=1;
                int rightDepth = maxDepth(n.right);
               // int d =  Math.max(rightDepth,time+1);
               // time+=d;

                if(rightDepth==0 && index!=1){
                    time++;
                }else {
                    time += rightDepth;
                }

            } else if (n.right != null && n.right.val == ((LinkedList<TreeNode>) queue).get(index - 1).val) {
                //   time+=1;
                int leftDepth = maxDepth(n.left);
              //  int d =Math.max(leftDepth,time+1) ;
               // time+=d;
                if(leftDepth==0 && index!=1){
                   time++;
                }
                else {
                    time += leftDepth;
                }

            }

            index++;
        }
        return time;

    }


    private int maxDepth(TreeNode node) {

        if (node != null) {
            int leftDepth = maxDepth(node.left);
            int rightDepth = maxDepth(node.right);
            int maxDepth = Math.max(leftDepth, rightDepth);
            return maxDepth + 1;
        }
        return 0;
    }

    TreeNode findNode(TreeNode root, int B, Queue<TreeNode> stack) {

        if (root != null) {
            if (root.val == B) {
                return root;
            }

            TreeNode leftSubTree = findNode(root.left, B, stack);
            if (leftSubTree != null) {
                stack.add(root);
                return leftSubTree;
            } else {
                TreeNode rightSubTree = findNode(root.right, B, stack);
                if (rightSubTree != null) {
                    stack.add(root);
                    return rightSubTree;
                }
            }
        }
        return null;

    }
}
