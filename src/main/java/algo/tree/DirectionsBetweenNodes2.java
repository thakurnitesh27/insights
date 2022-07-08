package algo.tree;

import java.util.ArrayList;
import java.util.List;

public class DirectionsBetweenNodes2 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5, new TreeNode(1, new TreeNode(3), null),
                new TreeNode(2, new TreeNode(6), new TreeNode(4)));

        System.out.println(new DirectionsBetweenNodes2().getDirections(root, 3, 6));

        root = new TreeNode(2, new TreeNode(1), null);
        System.out.println(new DirectionsBetweenNodes2().getDirections(root, 2, 1));

    }

    public String getDirections(TreeNode root, int startValue, int destValue) {

        TreeNode lcaNode=  findLCA(root,startValue,destValue);
        StringBuilder pathBuilder1=new StringBuilder();
        StringBuilder pathBuilder2=new StringBuilder();
        getPath(lcaNode,startValue,pathBuilder1);
        getPath(lcaNode,destValue,pathBuilder2);

        String path1=pathBuilder1.toString();
        String path2=pathBuilder2.toString();

        String ans="U";
        //ans+="U";
       // ans=ans.repeat(path1.length()); //java 8 doesn't support this. java11 has this support.
        ans+=path2;
        return ans;

    }

    boolean getPath(TreeNode node, int val,StringBuilder path) {
        if (node != null) {
            if (node.val == val) {
                return true;
            }

            boolean leftContains = getPath(node.left, val, path);
            if (leftContains) {
                path.insert(0,"L");
                return true;
            }else {
                boolean rightContains = getPath(node.right, val, path);
                if (rightContains) {
                    path.insert(0,"R");
                    return true;
                }
            }


        }
        return false;


    }




    TreeNode findLCA(TreeNode node, int startValue, int destValue) {

        if (node == null) {
            return null;
        }
        if (node.val == startValue || node.val == destValue) {
            return node;
        }
        TreeNode leftNode = findLCA(node.left, startValue, destValue);
        TreeNode rightNode = findLCA(node.right, startValue, destValue);

        if (leftNode != null && rightNode != null) {
            return node;
        }
        return leftNode != null ? leftNode : rightNode;

    }

    class StringHolder {
        String s;
    }
}
