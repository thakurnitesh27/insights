package algo.list;

public class ReverseList {


    public static void main(String[] args) {
        ListNode a = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        //  a.next=(new ListNode(2).next=(new ListNode(3).next=
        ListNode p = a;
        ListNode[] r = reverse(a, p);
        //r[1] is parentNode.
        System.out.println(r[1]);

    }

    static ListNode[] reverse(ListNode a, ListNode parentNode) {
        if (a.next != null) {
            ListNode[] nodes = reverse(a.next, parentNode);
            ListNode nextNode = nodes[0];
            parentNode = nodes[1];
            nextNode.next = a;
            a.next = null;
            return new ListNode[]{a, parentNode};
        } else {
            parentNode = a;
            return new ListNode[]{a, parentNode};
        }

    }
}

     class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x, ListNode n) {
            val = x;
            next = n;
        }

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "->" + val + "->";
        }
    }
