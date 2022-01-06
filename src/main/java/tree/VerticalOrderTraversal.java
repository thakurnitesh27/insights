package tree;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VerticalOrderTraversal {
    public static void main(String[] args) {

        /*
        43 460 3871 4698 8399 504 4421 7515 -1 4167 5727 -1 -1 3096
         434 7389 2667 5661 1969 7815 4292 3006 9750 6693 -1 6906
         -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
         */

//        TreeNode node = new TreeNode(6, new TreeNode(3,
//                new TreeNode(2), new TreeNode(5)),
//                new TreeNode(7, null, new TreeNode(9)));

//        TreeNode node = new TreeNode(818, null, new TreeNode(2510,
//                new TreeNode(212, null, new TreeNode(9881)),null));

        TreeNode node=new TreeNode(43,
                new TreeNode(460,new TreeNode(4698,new TreeNode(7515,new TreeNode(7389,new TreeNode(6906),null),null),null),
                        new TreeNode(8399,new TreeNode(4167,new TreeNode(5661),new TreeNode(1969)),new TreeNode(5727,new TreeNode(1969),new TreeNode(4292)))),
                new TreeNode(3871,new TreeNode(504),new TreeNode(4421,
                        new TreeNode(3096,new TreeNode(3006),
                                new TreeNode(9750)) ,new TreeNode(434,new TreeNode(6693),null))));

      ArrayList<ArrayList<Integer>> response=  new VerticalOrderTraversal().traverse(node);
        System.out.println(response);


    }

    ArrayList<ArrayList<Integer>> traverse(TreeNode node) {

        HashMap<Integer, ArrayList<Integer>> map = new HashMap();

        int[] range = traverse(node, map, (0), Integer.MIN_VALUE, Integer.MAX_VALUE);

        int min = range[0], max = range[1];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = max; i >= min; i--) {
            list.add(map.get(i));
        }

        for(Map.Entry<Integer,ArrayList<Integer>> m:map.entrySet()){
            list.add(m.getValue());

        }

        return list;


    }

    int[] traverse(TreeNode node, HashMap<Integer, ArrayList<Integer>> map, Integer counter, int maxCount, int minCount) {

        if (node != null) {

            if (maxCount < counter) {
                maxCount = counter;
            }
            if (minCount > counter) {
                minCount = counter;
            }




            if (map.get(counter) != null) {

                map.get(counter).add(node.val);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(node.val);
                map.put(counter, list);
            }
            int[] leftCounterDetails = traverse(node.left, map, counter + 1, maxCount, minCount);

            int[] rightCounterDetails = traverse(node.right, map, counter - 1, maxCount, minCount);

            return new int[]{Math.min(leftCounterDetails[0], rightCounterDetails[0]), Math.max(leftCounterDetails[1], rightCounterDetails[1])};
        }
        return new int[]{minCount, maxCount};
    }

    class IntegerAsReference {
        private Integer i;

        IntegerAsReference(Integer i) {
            this.i = i;
        }

        public IntegerAsReference increment() {
            ++i;
            return this;
        }

        public Integer incrementAndGet() {
            i++;
            return i;
        }

        public Integer get() {
            return i;
        }

        public IntegerAsReference decrement() {
            i--;
            return this;
        }
    }
}
