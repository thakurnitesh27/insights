package algo.list;


//https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseNodesInkGroup {

    public static void main(String[] args) {

        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        print(new ReverseNodesInkGroup().reverseKGroup(node, 1));

        node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        print(new ReverseNodesInkGroup().reverseKGroup(node, 2));

        node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        print(new ReverseNodesInkGroup().reverseKGroup(node, 3));

        node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        print(new ReverseNodesInkGroup().reverseKGroup(node, 4));

        node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        print(new ReverseNodesInkGroup().reverseKGroup(node, 5));
        //print(new ReverseNodesInkGroup().reverseKGroup(node, 4));
        //  print(new ReverseNodesInkGroup().reverseKGroup(node,5));
    }

    static void print(ListNode node) {
        if (node != null) {
            System.out.print(node.val + "->");
            print(node.next);
        }
        System.out.println();
    }

    public ListNode reverseKGroup(ListNode head, int k) {


        ListNode newHead = null;
        ListNode lastTail = null;
        ListNode node = head;

        outerloop:
        while (node != null) {
            int count = 1;
            ListNode tmpHead = node;
            ListNode lastNode = node.next;

            while (count < k) {
                if (node.next != null) {
                    node = node.next;
                    count++;
                    if (count == k) {
                        lastNode = node.next;
                    }
                } else {
                    break;
                }
            }

            if (count < k) {
                lastTail.next = tmpHead;
                break outerloop;
            }
            node.next = null;

            ListNode[] reversedNode = reverse(tmpHead, null); // 1-> parentNode, 0-> tailNode

            if (newHead == null) {
                newHead = reversedNode[1];
                lastTail = reversedNode[0];
            } else {
                lastTail.next = reversedNode[1];
                lastTail = reversedNode[0];

            }
            // reversedNode[1].next = lastNode;
            node = lastNode;

        }

        return newHead;

    }

    ListNode[] reverse(ListNode node, ListNode parentNode) {

        if (node.next != null) {
            ListNode[] nodes = reverse(node.next, parentNode);
            //  if (nodes[0] != null) {
            nodes[0].next = node;
            node.next = null;
            return new ListNode[]{node, nodes[1]};


        } else {
            return new ListNode[]{node, node};
        }

    }
}
