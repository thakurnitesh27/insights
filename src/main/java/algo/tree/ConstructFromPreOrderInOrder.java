package algo.tree;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ConstructFromPreOrderInOrder {

    public static void main(String[] args) {

        int[] inOrder=new int[]{4,2,5,1,6,3};
        int[] preOrder=new int[]{1,2,4,5,3,6};

        new ConstructFromPreOrderInOrder().buildTree(preOrder,inOrder);


    }

    public TreeNode buildTree(int[] preorder, int[] inOrder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inOrder.length;i++){

            map.put(inOrder[i],i);
        }

        return build(preorder,inOrder,new AtomicInteger(0),0,inOrder.length,map);

    }

    TreeNode build(int[] preOrder, int[] inOrder, AtomicInteger preOrderIndex, int startInOrderIndex, int endInOrderIndex, HashMap<Integer, Integer> inOrderNodeToIndexMap) {

        if (preOrderIndex.get() < preOrder.length) {
            TreeNode node = new TreeNode(preOrder[preOrderIndex.get()]);
            int inOrderIndex = inOrderNodeToIndexMap.get(preOrder[preOrderIndex.get()]);



            if (startInOrderIndex < inOrderIndex) {
                preOrderIndex.getAndIncrement();
                node.left = build(preOrder, inOrder, preOrderIndex, startInOrderIndex, inOrderIndex - 1, inOrderNodeToIndexMap);
            }

            if (inOrderIndex < endInOrderIndex) {
                preOrderIndex.getAndIncrement();
                node.right = build(preOrder, inOrder, preOrderIndex, inOrderIndex + 1, endInOrderIndex, inOrderNodeToIndexMap);
            }
            return node;
        }
        return null;

    }



    TreeNode construct(int[] preOrder, int[] inOrder){

        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inOrder.length;i++){

            map.put(inOrder[i],i);
        }

        TreeNode node=construct(preOrder,inOrder,new IntegerAsReference(0),0,inOrder.length,map);
        return node;
    }

    TreeNode construct(int[] preOrder, int[] inOrder, IntegerAsReference index,int startInIndex,int endInIndex,HashMap<Integer,Integer> map){
        if(index.get()<preOrder.length) {
            int nodeVal = preOrder[index.get()];

            TreeNode node = new TreeNode(nodeVal);
            int inIndex = map.get(nodeVal);
            if(startInIndex<inIndex) {
                node.left = construct(preOrder, inOrder, index.increment(), startInIndex, inIndex - 1, map);
            }
            if(inIndex<endInIndex) {
                node.right = construct(preOrder, inOrder, index.increment(), inIndex + 1, endInIndex, map);
            }
            return node;

        }
        return null;
    }

    class IntegerAsReference{
        private  Integer i;

        IntegerAsReference(Integer i) {
            this.i = i;
        }

        public IntegerAsReference increment(){
            ++i;
            return this;
        }

        public Integer incrementAndGet(){
            i++;
            return i;
        }

        public Integer get(){
            return i;
        }
    }
}
