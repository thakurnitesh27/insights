package algo.graph;

import algo.tree.TreeNode;

import java.util.*;

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class SerializeandDeserializeBinaryTree {


    public static void main(String[] args) {

        TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(6), new TreeNode(7)), new TreeNode(4)),
                new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        node=new TreeNode(3,new TreeNode(2,new TreeNode(4),new TreeNode(3)),null);
        String s = new SerializeandDeserializeBinaryTree().serialize(node);
        System.out.println(s);
        TreeNode root = new SerializeandDeserializeBinaryTree().deserialize(s);
        print(root);


    }

    private static void print(TreeNode node) {
        if (node != null) {
            System.out.println(node.val);
            print(node.left);
            print(node.right);
        }

    }

    public String serialize(TreeNode root) {

        LinkedHashMap<String, TreeNode[]> adjacencyList = new LinkedHashMap<>();

        Queue<TreeNode> queue = new LinkedList<>();
        ((LinkedList<TreeNode>) queue).add(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            if (node != null) {
                TreeNode[] children = getChildren(node);
                if (children != null && children.length != 0) {
                    //adjacencyList.pu(children);
                    int count = 0;
                    String valAsString = String.valueOf(node.val);
                    String key = valAsString + "," + count;
                    while (adjacencyList.containsKey(key)) {
                        count++;
                        key = valAsString + "," + count;
                    }
                    adjacencyList.put(key, children);
                    if (children[0] != null)
                        ((LinkedList<TreeNode>) queue).add(children[0]);
                    if (children[1] != null)
                        ((LinkedList<TreeNode>) queue).add(children[1]);
                }
            }

        }
        StringBuilder builder = new StringBuilder();
        for (String key : adjacencyList.keySet()) {
            builder.append(key + "->{");
            for (TreeNode node : adjacencyList.get(key)) {
                builder.append(node != null ? node.val + "," : null + ",");
            }
            builder.replace(builder.length() - 1, builder.length(), "");
            builder.append("};");
        }
        if(builder.length()>0)
        builder.replace(builder.length() - 1, builder.length(), "");
        return builder.toString();


    }

    TreeNode[] getChildren(TreeNode node) {
        return new TreeNode[]{node.left, node.right};
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.length()==0){
            return null;
        }
        String[] strings = data.split(";");
        TreeMap<String, String[]> map = new TreeMap();
        TreeNode root = new TreeNode();
        String[] rootChildren = null;

        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            String[] d = s.split("->");
            String key = d[0];
            String[] splittedKey = key.split(",");
            d[1] = d[1].substring(1, d[1].length() - 1);
            String[] values = d[1].split(",");

            if (i == 0) {

                if (splittedKey != null && splittedKey[0] != null) {
                   // map.remove(key);
                    root = new TreeNode(Integer.parseInt(key.split(",")[0]));
                    rootChildren = values;
                }
            }else
            map.put(key, values);
        }

        Queue<Pair> queue = new LinkedList<>();
        ((LinkedList<Pair>) queue).add(new Pair(root, rootChildren));

        while (!queue.isEmpty()) {

            Pair pair = queue.poll();
            TreeNode node = pair.node;
            String[] children = pair.children;
            if (children[0] != null && !children[0].equals("null")) {
                Pair leftNode = fetchNode(children[0], map);
                node.left = leftNode.node;
                ((LinkedList<Pair>) queue).add(leftNode);
            }
            if (children[1] != null && !children[1].equals("null")) {
                Pair rightNode = fetchNode(children[1], map);
                node.right = rightNode.node;
                ((LinkedList<Pair>) queue).add(rightNode);
            }
        }

        return root;

    }

    private Pair fetchNode(String key, TreeMap<String, String[]> map) {
        String foundKey = map.keySet().stream().filter(s -> s.startsWith(key + ",")).findFirst().get();
        String[] children = map.get(foundKey);
        map.remove(foundKey);

        return new Pair(new TreeNode(Integer.parseInt(foundKey.split(",")[0])), children);

    }

    class Pair {
        TreeNode node;
        String[] children;

        public Pair(TreeNode node, String[] children) {
            this.node = node;
            this.children = children;
        }
    }

//    TreeNode createTree(TreeMap<String, String[]> map, Queue<TreeNode> queue, TreeNode parentNode, TreeNode root) {
//
//        if (parentNode == null) {
//            String key = root.val + "";
//            String foundKey = map.keySet().stream().filter(s -> s.startsWith(key + ",")).findFirst().get();
//            String[] children = map.get(foundKey);
//            map.remove(foundKey);
//
//            if (children[0] != null && !children[0].equals("null")) {
//                // queue.add(children[0]);
//                String leftKey = children[0];
//                foundKey = map.keySet().stream().filter(s -> s.startsWith(leftKey + ",")).findFirst().get();
//                root.left = new TreeNode(Integer.parseInt(foundKey.split(",")[0]));
//                queue.add(root.left);
//                map.remove(foundKey);
//                createTree(map, queue, root.left, root);
//            }
//
//            if (children[1] != null && !children[1].equals("null")) {
//                String rightKey = children[1];
//                foundKey = map.keySet().stream().filter(s -> s.startsWith(rightKey + ",")).findFirst().get();
//                root.right = new TreeNode(Integer.parseInt(foundKey.split(",")[0]));
//                queue.add(root.right);
//                map.remove(foundKey);
//                createTree(map, queue, root.right, root);
//            }
//
//            return root;
//        } else if (!queue.isEmpty()) {
//            // TreeNode parentNodeKey = queue.poll();
//            String foundKey = map.keySet().stream().filter(s -> s.startsWith(key.val + ",")).findFirst().get();
//            String[] children = map.get(foundKey);
//            map.remove(foundKey);
//
//            TreeNode node = new TreeNode(Integer.parseInt(foundKey.split(",")[0]));
//            if (children[0] != null && !children[0].equals("null"))
//                queue.add(children[0]);
//            if (children[1] != null && !children[1].equals("null"))
//                queue.add(children[1]);
//            if (children[0] != null && !children[0].equals("null"))
//                node.left = createTree(map, queue, node, root);
//            if (children[1] != null && !children[1].equals("null"))
//                node.right = createTree(map, queue, node, root);
//            return node;
//        }
//
//        return null;
//    }
}



