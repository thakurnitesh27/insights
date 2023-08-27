package algo.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/?envType=study-plan-v2&envId=top-interview-150
public class ConstructFromInorderPostOrder {
    public static void main(String[] args) {
        new ConstructFromInorderPostOrder().buildTree(new int[]
                        {9, 3, 15, 20, 7},
                new int[]
                        {9, 15, 7, 20, 3});
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(new AtomicInteger(inorder.length-1), 0, inorder.length-1, postorder, map);

    }

    TreeNode build(AtomicInteger postOrderIndex, int inorderStartIndex, int inorderEndIndex, int[] postorder, Map<Integer, Integer> inorderValueToIndexMap) {
        if (postOrderIndex.get() >= 0) {

            int val = postorder[postOrderIndex.get()];
            int inorderIndex = inorderValueToIndexMap.get(val);
            TreeNode node = new TreeNode(val);

            if (inorderIndex < inorderEndIndex) {
                postOrderIndex.getAndDecrement();
                node.right = build(postOrderIndex, inorderIndex + 1, inorderEndIndex, postorder, inorderValueToIndexMap);
            }
            if (inorderStartIndex < inorderIndex) {
                postOrderIndex.getAndDecrement();
                node.left = build(postOrderIndex, inorderStartIndex, inorderIndex - 1, postorder, inorderValueToIndexMap);
            }
            return node;
        }
        return null;

    }

}
