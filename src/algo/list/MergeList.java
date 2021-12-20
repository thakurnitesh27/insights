package list;

public class MergeList {
    public static void main(String[] args) {

        ListNode a= new ListNode(5,new ListNode(8,new ListNode(20)));
        ListNode b= new ListNode(4,new ListNode(11,new ListNode(15)));
       ListNode r= new MergeList().mergeTwoLists(a,b);
        System.out.println(r);
    }
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode parentNode=null;
        ListNode currA=A;
        ListNode currB=B;
        ListNode curr=null;

        while (currA!=null && currB!=null){

            if(parentNode==null){
                if(currA.val< currB.val){
                    parentNode=currA;
                    currA=currA.next;
                }
                else {
                    parentNode=currB;
                    currB=currB.next;
                }
                curr=parentNode;
            }
            else {
                if(currA.val< currB.val){
                    curr.next=new ListNode(currA.val);
                    currA=currA.next;
                }
                else {
                    curr.next=new ListNode(currB.val);
                    currB=currB.next;
                }
                curr=curr.next;

            }

        }
        if(currA==null && currB!=null){
            curr.next=currB;
        }
        else if(currB==null && currA!=null){
            curr.next=currA;
        }

        return parentNode;

    }
}
