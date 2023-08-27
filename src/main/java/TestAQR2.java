import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestAQR2 {


    public static void main(String[] args) {

    }

//    Node head, tail;
//    HashMap<Integer, Integer> map;
//
//
//    private int capacity;
//    int count=0;
//
//    public TestAQR2(int capacity) {
//        map = new HashMap<>();
//        this.capacity = capacity;
//    }
//
//
//    int put(int key, int value){
//
//
//       Integer val= map.get(key);
//
//       if(val==null) {
//           if (count >= capacity) {
//               evict();
//           }
//           map.put(key,value);
//       }
//       else {
//
//       }
//
//      Node temp=new Node(key);
//
//       temp.next=head;
//       head=temp;
//
//
//    }
//
//    int get(int key){
//
//
//
//
//
//
//    }

//    int evict(){
//
//
//       Node temp= tail.prev;
//       temp.next=null;
//       tail=temp;
//       map.remove(temp.val);
//    }


    class Node {


        Node(int val){
            val=val;
        }

        int val;
        Node next;
        Node prev;

    }

}


/*

put(3)

3->1->2-null;
3->1->null;


1->2->null
 */