package algo.list;

import java.util.Stack;

//https://leetcode.com/problems/reverse-linked-list-ii/
public class ReverseLinkedList2 {

    public static void main(String[] args) {
       // ListNode a = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5,new ListNode(6,null))))));

       // new ReverseLinkedList2().reverseList(a,2,4);

        ListNode b= new ListNode(3,new ListNode(5,null));
        new ReverseLinkedList2().reverseList(b,1,2);

    }

    ListNode reverseList(ListNode head, int left, int right){

        if(head!=null){

            ListNode lastNodes=null;
            ListNode node=head;
            ListNode firstNodeBeforeReverse=null;

            for(int i=1;i<left && node!=null;i++){
                firstNodeBeforeReverse=node;
                if(node!=null)
                node=node.next;
            }

            ListNode newHead=node;
            ListNode lastVisitedNode=null;
            int i=left;
            while (node.next!=null){

                if(i>=left && i<=right){
                    lastVisitedNode=node;
                    node=node.next;
                    i++;
                }

                if(i==right+1){
                    lastVisitedNode.next=null;
                    lastNodes=node;
                    break;
                }
            }

           ListNode[] response= reverse(newHead,newHead);
            ListNode reversedList=response[1];
            if(firstNodeBeforeReverse!=null){
                firstNodeBeforeReverse.next=reversedList;
            }
            response[0].next=lastNodes;
            return firstNodeBeforeReverse!=null?head:response[1];

        }
        return null;



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

//    ListNode[] reverse(ListNode node, ListNode head, int index ,int left, int right){
//
//        if(node.next!=null){
//
//            ListNode[] ans= reverse(node.next,head,index+1,left,right);
//            if(index>=left && index<=right){
//                ListNode nextNode=node.next;
//
//
//                ans[0].next=node;
//                if(index==right){
//                    node.next=nextNode;
//                }else {
//                    node.next = null;
//                }
//                return new ListNode[]{node,ans[1]};
//            }
//            else {
//                return new ListNode[]{node,head};
//            }
//
//
////            else {
////
////            }
//
//        }
//        else {
//            return new ListNode[]{node,head};
//        }
//
//    }


}
