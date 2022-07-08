package algo.tree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
public class DirectionsBetweenNodes {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(5, new TreeNode(1, new TreeNode(3), null),
                new TreeNode(2, new TreeNode(6), new TreeNode(4)));

        System.out.println(new DirectionsBetweenNodes().getDirections(root,5,6));

        root=new TreeNode(2,new TreeNode(1),null);
        System.out.println(new DirectionsBetweenNodes().getDirections(root,2,1));

    }

    public String getDirections(TreeNode root, int startValue, int destValue) {

        List<TreeNode> path1=new ArrayList<>();
        List<TreeNode> path2=new ArrayList<>();
        getPath(root,startValue,path1);
        getPath(root,destValue,path2);
        System.out.println(path1);
        System.out.println(path2);

        String ans="";
        TreeNode lcaNode=null;
        int lcaIndex1=0;
        int lcaIndex2=0;

        for(int i=0;i<path1.size();i++){
            for(int j=0;j<path2.size();j++){

                if(path1.get(i).val==path2.get(j).val){
                    lcaNode=path1.get(i);
                    lcaIndex1=i;
                    lcaIndex2=j;
                    break;
                }
            }
        }

        if(lcaNode!=null){
            for(int i=path1.size()-1;i>lcaIndex1;i--){
                ans+="U";
            }
            TreeNode node=lcaNode;
            for(int i=lcaIndex2+1;i<path2.size();i++){
                if(node.left.val==path2.get(i).val){
                    ans+="L";
                    node=path2.get(i);
                }else if(node.right.val==path2.get(i).val){
                    ans+="R";
                    node=path2.get(i);
                }
            }
        }

        return ans;

    }

    boolean getPath(TreeNode node, int val, List<TreeNode> pathList) {
        if(node!=null) {
            if (node.val == val) {
                pathList.add(0, node);
                return true;
            }

             boolean leftContains=   getPath(node.left,val,pathList);
             boolean rightContains=   getPath(node.right,val,pathList);

             if(leftContains || rightContains) {
                 pathList.add(0, node);
                 return true;
             }

        }
        return false;


    }
}


