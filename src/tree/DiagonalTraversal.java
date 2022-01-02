package tree;

import java.util.ArrayList;
import java.util.TreeMap;

public class DiagonalTraversal {
    public static void main(String[] args) {

        TreeNode node=new TreeNode(1, new TreeNode(4,new TreeNode(8),new TreeNode(5,new TreeNode(9),new TreeNode(7))),
                new TreeNode(2,null, new TreeNode(3,new TreeNode(6),null)));

        new DiagonalTraversal().traverse(node);

    }

   ArrayList<Integer> traverse(TreeNode node){

        TreeMap<Integer,ArrayList<Integer>> map=new TreeMap<>();
        traverse(node,0,map);

        ArrayList<Integer> list=new ArrayList<>();

        for(Integer m:map.keySet()){
            list.addAll(map.get(m));
        }

        return list;


    }

    void traverse(TreeNode node, int index, TreeMap<Integer, ArrayList<Integer>> map){

        if(node!=null){

            if(map.get(index)==null){
                ArrayList<Integer> list=new ArrayList<>();
                list.add(node.val);
                map.put(index,list);
            }
            else {
                map.get(index).add(node.val);
            }

            traverse(node.left,index+1,map);
            traverse(node.right,index,map);
        }

    }
}
