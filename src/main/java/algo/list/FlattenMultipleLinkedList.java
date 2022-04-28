package algo.list;

public class FlattenMultipleLinkedList {

    public static void main(String[] args) {

        Node head=new Node(1,new Node(2,new Node(3,
                new Node(4,
                        new Node(5,new Node(6,null,null),null),null),
                new Node(7,new Node(8,new Node(9,new Node(10,null,null),null),
                        new Node(11,new Node(12,null,null),null)),null)),null),null);

        new FlattenMultipleLinkedList().flatten(head);
    }

    public Node flatten(Node head) {
        Node parentNode=head;
        doFlatten(head);
        return parentNode;
    }

    Node doFlatten(Node head){
        if(head!=null){
            if(head.child==null){
                if(head.next!=null){
                    // Node prevNode=head;
                    head.next.prev=head;
                    //  System.out.println("nextNode :"+ head.next.val);
                    return doFlatten(head.next);
                }
                // System.out.println("nextNode :"+ head.val);
                return head;
            }
            else {
                // System.out.println("Child Node found: "+ head.child.val);
                Node temp=head.next;
                head.next=head.child;
                head.child=null;

                if(head.next!=null){
                    head.next.prev=head;
                }
                //System.out.println("NextNode is: "+head.next.val);
                Node lastNode= doFlatten(head.next);
                // System.out.println("LastNode is: "+lastNode.val);
                lastNode.next=temp;
                temp.prev=lastNode;
               return doFlatten(lastNode);
            }
        }
        return head;
    }

}
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val, Node next, Node child) {
        this.val = val;
        // this.prev = new Node(prev);
        if(next!=null)
        next.prev=this;
        this.next = next;
        this.child = child;
    }
};
