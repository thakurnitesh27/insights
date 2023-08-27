package sorting;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

//https://leetcode.com/problems/find-median-from-data-stream/

//Image here :https://www.programcreek.com/2015/01/leetcode-find-median-from-data-stream-java/
//https://leetcode.com/problems/find-median-from-data-stream/solutions/74047/java-python-two-heap-solution-o-log-n-add-o-1-find/
public class FindMedianFromDataStream {

    public static void main(String[] args) {

        FindMedianFromDataStream findMedianFromDataStream=new FindMedianFromDataStream();
        findMedianFromDataStream.addNum(6);
        System.out.println(findMedianFromDataStream.findMedian());
        findMedianFromDataStream.addNum(10);
        System.out.println(findMedianFromDataStream.findMedian());
        findMedianFromDataStream.addNum(2);
        System.out.println(findMedianFromDataStream.findMedian());
        findMedianFromDataStream.addNum(6);
        System.out.println(findMedianFromDataStream.findMedian());
        findMedianFromDataStream.addNum(5);
        System.out.println(findMedianFromDataStream.findMedian());
        findMedianFromDataStream.addNum(0);
        System.out.println(findMedianFromDataStream.findMedian());
    }

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    boolean even=true;
    public FindMedianFromDataStream() {
        maxHeap=new PriorityQueue<>(Comparator.reverseOrder());
        minHeap=new PriorityQueue<>(); //Priorityqueue is min-heap by default.


    }
    public void addNum(int num){

        if(even){
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        even=!even;
    }

    public double findMedian(){
       if(even){
           return (double)(maxHeap.peek()+minHeap.peek())/2;
       }
       else return maxHeap.peek();

    }

//    private PriorityQueue<Integer> priorityQueue;
//    private TreeMap<Integer,Integer> map;
//    private int size=0;
//
//
//
//    public FindMedianFromDataStream() {
//       // priorityQueue=new PriorityQueue<>((o1,o2)->  Integer.compare(o1,o2) );
//        map=new TreeMap<>();
//
//    }
//
//    public void addNum(int num) {
//       map.put(num,map.getOrDefault(num,0)+1);
//       size++;
//
//    }
//
//    public double findMedian(){
//       int count=0;
//       if(size%2==0){
//           int num1=Integer.MIN_VALUE;
//           int num2=Integer.MIN_VALUE;
//           for(Integer key: map.keySet()) {
//             //  if (count <= size / 2) {
//               int lastCount=count;
//                   count+=map.get(key);
//                   if(lastCount<size/2 && count>=size/2+1){
//                       num1=num2=key;
//                       break;
//                   }
//                   else if(count==size/2){
//                       num1=key;
//                   }
//                   else if(count>=size/2+1){
//                       num2=key;
//                   }
//
//                   if(num1!=Integer.MIN_VALUE && num2!=Integer.MIN_VALUE){
//                       break;
//                   }
//              // }
//           }
//
//           return (double)(num1+num2)/2;
//       }
//       else {
//           for(Integer key: map.keySet()) {
//               count+=map.get(key);
//               if(count>=size/2+1){
//                   return key;
//               }
//           }
//       }
//       return -1;
//    }


}
