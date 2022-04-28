package design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCache {

    private final Map<Integer, LinkedListNode> map;
    private final int size;
    private  LinkedListNode head;
    private LinkedListNode tail;

    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(map.get(key)!=null){
            LinkedListNode node=map.get(key);
            int value=node.val;
            if(node.previous!=null && node.next!=null){
                node.previous.next=node.next;
                node.next.previous=node.previous;
            }
            else if(node.previous!=null){
                tail=node.previous;
                tail.next=null;
            }
            else if(node.next!=null){
                head=node.next;
                head.previous=null;
            }
            map.remove(key);
            LinkedListNode newNode=new LinkedListNode(key,value);
            newNode.next=head;
            head.previous=newNode;
            head=newNode;
            map.put(key,newNode);
            return value;
        }
        return -1;

    }

    public void put(int key, int value) {
      //  if(map.size()>size){
            evict();
       // }
        LinkedListNode node=null;
        if(map.get(key)!=null){
           //map.get(key).val=value;
             node=map.get(key);
            //node.val=value;
            if(node.previous!=null && node.next!=null){
                node.previous.next=node.next;
                node.next.previous=node.previous;
            }
            else if(node.previous!=null){
                tail=node.previous;
                tail.next=null;
            }
            else if(node.next!=null){
                head=node.next;
                head.previous=null;
            }
            map.remove(key);
        }
          //  evict();
            node = new LinkedListNode(key, value);
            map.put(key, node);
       // }
            if(head!=null) {
               node.next= head;
                head.previous=node;
                head=node;
            }
            else {
                tail=head=node;
            }

        }


    private void evict() {
        while (map.size()>size) {
            if (tail != null) {
                map.remove(tail.key);
                if(tail.key==head.key){
                    head=tail=null;
                    map.clear();
                    break;
                }
                    tail=tail.previous;
                    tail.next = null;



            }
        }
    }
}

class LinkedListNode {
    int key;
     int val;
     LinkedListNode next;
     LinkedListNode previous;

    LinkedListNode(int key,int val) {
        this.key=key;
        this.val = val;
    }

    public static void main(String[] args) {
        /*
        ["LRUCache","put","put","get","put","get","put","get","get","get"]
[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
         */


//        LRUCache cache=new LRUCache(2);
//        cache.put(1,1);
//        cache.put(2,2);
//        System.out.println(cache.get(1));
//        cache.put(3,3);
//        System.out.println(cache.get(2));
//        cache.put(4,4);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(4));

//        LRUCache cache=new LRUCache(10);
//        cache.put(10,13);
//        cache.put(3,17);
//        cache.put(6,11);
//        cache.put(10,5);
//        cache.put(9,10);
//        cache.get(13);
//        cache.put(2,19);
//        cache.get(2);
//        cache.get(3);
//        cache.put(5,25);cache.get(8);cache.put(9,22);
//        cache.put(5,5);cache.put(1,30);cache.get(11);
//
//        LRUCache cache=new LRUCache(10);
//        String input="[[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],\n" +
//                "[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],\n" +
//                "[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],\n" +
//                "[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],\n" +
//                "[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],\n" +
//                "[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],\n" +
//                "[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]";
//       String[] items= input.split("],");
//       for(String item:items){
//           if(item.trim().equals("")){
//               continue;
//           }
//           item=item.replaceAll("\\[","");
//           item=item.replaceAll("\\]","");
//           if(item.split(",").length>1){
//
//             String []temp=  item.split(",");
//             cache.put(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
//           }
//           else {
//               System.out.println(cache.get(Integer.parseInt(item.trim())));
//           }
//       }


       // [1],[6],[8],[12,1],[2],[15,11],[5,2],[1,15],[4,2],[5],[15,15]]
        LRUCache cache=new LRUCache(1);
        cache.get(8);
        cache.get(6);
        cache.put(12,1);
        cache.put(15,11);
        cache.put(5,2);
        cache.put(1,15);
        cache.put(4,2);
        cache.get(5);
        cache.put(15,15);
    }
}
/*

 ["LRUCache","put","put","put","put","put","get","put","get","get","put","get","put","put",
 "put","get","put","get","get","get","get","put","put","get","get","get","put","put","get",
 "put","get","put","get","get","get","put","put","put","get","put","get","get","put","put",
 "get","put","put","put","put","get","put","put","get","put","put","get","put","put","put",
 "put","put","get","put","put","get","put","get","get","get","put","get","get","put","put",
 "put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","
 put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","
 put","put","put","put","put","put"]
[[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],
[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],
[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],
[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],
[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],
[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],
[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]
 */

/*
[null,null,null,null,null,null,-1,null,19,17,null,-1,null,
null,null,-1,null,-1,5,-1,12,null,null,3,5,5,null,null,1,
null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,
18,null,null,null,null,-1,null,null,18,null,null,11,null,null,
null,null,null,-1,null,null,24,null,4,-1,30,null,12,11,null,null,
null,null,29,null,null,null,null,17,22,-1,null,null,null,24,null,
null,null,-1,null,null,null,-1,-1,-1,null,null,null,null,-1,null,
null,null,null,null,null,null]


[null,null,null,null,null,null,-1,null,19,17,null,-1,null,
null,null,-1,null,-1,5,-1,12,null,null,3,5,5,null,null,1,
null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,
18,null,null,null,null,-1,null,null,18,null,null,-1,null,null,null,
null,null,18,null,null,-1,null,4,29,30,null,12,-1,null,null,null,null,
29,null,null,null,null,17,22,18,null,null,null,-1,null,null,null,20,null,
null,null,-1,18,18,null,null,null,null,20,null,null,null,null,null,null,null]
*/
