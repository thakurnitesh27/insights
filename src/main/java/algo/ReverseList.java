package algo;

import java.util.function.Consumer;

public class ReverseList {
    Node rootNode;
    private Node currentNode;
   class Node{
      int val;
      Node next;

       @Override
       public String toString() {
           return "Node{" +
                   "val=" + val +
                   ", next=" +  +
                   '}';
       }
   }


    Node creatLinkedList(Integer... integers)
    {
        for(int i=0;i<integers.length;i++)
        {
            Node node=new Node();
            node.val=integers[i];
            if(rootNode==null)
            {
                rootNode=node;
                currentNode=node;
            }
            else {
                currentNode.next=node;
                currentNode=node;
            }
        }

        return rootNode;
    }

public static Node reverse(Node rootNode)
{
    Node currentNode=rootNode;
    Node prevNode=null;
    Node nextNode=currentNode.next;
Node firstNode=rootNode;
    while (nextNode!=null)
    {

        prevNode=currentNode;
        currentNode=nextNode;
        nextNode=currentNode.next;
        currentNode.next=prevNode;


    }
    firstNode.next=null;
    rootNode=currentNode;
    return rootNode;
}

public static void processList(Node rootNode, Consumer<Node> consumer)
{
    Node currentNode=rootNode;
    while (currentNode.next!=null)
    {
        consumer.accept(currentNode);
        currentNode=currentNode.next;
    }
}
    public static void main(String[] args) {
ReverseList reverseList=new ReverseList();
Node rootNode=null;
ReverseList.processList(rootNode=reverseList.creatLinkedList(1,2,3,4,5),System.out::print);
        System.out.println("reversing...");

       ReverseList.processList(ReverseList.reverse(rootNode),System.out::print);
    }


}
