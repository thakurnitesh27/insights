package algo.list;


//https://leetcode.com/problems/remove-nth-node-from-end-of-list/?envType=featured-list&envId=top-interview-questions
public class RemoveNthFromList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        print(new RemoveNthFromList().removeNthFromEnd(head, 2));
        // print(head);


        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        print(new RemoveNthFromList().removeNthFromEnd(head, 3));
        // print(head);

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        print(new RemoveNthFromList().removeNthFromEnd(head, 5));

    }

    private static void print(ListNode node) {
        if (node != null) {
            System.out.print(node.val + "->");
            print(node.next);
        } else
            System.out.println();

    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        Pair<Integer, Pair<Boolean, ListNode>> ans = traverseAndRemove(null, head, head, 1, n);
        return ans.snd.snd;
    }

    private Pair<Integer, Pair<Boolean, ListNode>> traverseAndRemove(ListNode prevNode, ListNode node, ListNode headNode, int count, int indexToRemove) {

        if (node != null) {
            Pair<Integer, Pair<Boolean, ListNode>> pair = traverseAndRemove(node, node.next, headNode, count + 1, indexToRemove);
            if (pair.snd.fst) {
                return pair;
            } else {
                if (pair.fst == count) {
                    if (prevNode == null) {
                        headNode = headNode.next;
                        return Pair.of(pair.fst, Pair.of(true, headNode));
                    } else {
                        prevNode.next = node.next;
                        return Pair.of(pair.fst, Pair.of(true, pair.snd.snd));
                    }

                } else {
                    return Pair.of(pair.fst, Pair.of(false, pair.snd.snd));
                }
            }
        } else {
            int size = count;
            indexToRemove = size - indexToRemove;
            return Pair.of(indexToRemove, Pair.of(false, headNode));
        }
    }


}

class Pair<T, K> {
    T fst;
    K snd;

  static   <A, B> Pair<A, B> of(A var0, B var1) {
        Pair<A, B> pair = new Pair<>();
        pair.fst = var0;
        pair.snd = var1;
        return pair;
    }
}
