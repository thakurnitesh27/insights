package algo.list;

public class PartitionList {
    public static void main(String[] args) {

       // ListNode a= new ListNode(1,new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(5,new ListNode(2))))));
        ListNode a= new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(2))))));
        ListNode r=new PartitionList().partition(a,1);
    }
     ListNode partition(ListNode a,int B){
        ListNode currentInNewNode=null;
        ListNode prevNode=null;
        ListNode currentNode=a;
        ListNode parentNode=a;
        ListNode newParentNode=null;
        while (currentNode!=null){

            if(currentNode.val>=B){
                ListNode[] nodes=moveToNewList(currentInNewNode,prevNode,currentNode,parentNode,newParentNode);
                parentNode=nodes[0];
                newParentNode=nodes[1];
                currentInNewNode=nodes[2];
            }
            else {
                prevNode=currentNode;
            }

            currentNode=currentNode.next;
        }
       // currentNode=newParentNode;
         if(parentNode!=null) {
             prevNode.next = newParentNode;
         }
         else return newParentNode;

        return parentNode;
    }
   ListNode[] moveToNewList(ListNode currentInNewNode,ListNode prevNode,ListNode currentNode,ListNode parentNode,ListNode newParentNode){
        if(prevNode!=null){
            prevNode.next=currentNode.next; //removed from oldList
        }
        else {
            parentNode=currentNode.next;

        }

       if(currentInNewNode==null){
           currentInNewNode=new ListNode(currentNode.val);
           newParentNode=currentInNewNode;
       }
       else {
           currentInNewNode.next=new ListNode(currentNode.val);
           currentInNewNode=currentInNewNode.next;
       }
       return new ListNode[]{parentNode,newParentNode,currentInNewNode};

    }
}
