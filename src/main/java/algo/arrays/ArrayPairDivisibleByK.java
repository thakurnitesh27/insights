package algo.arrays;

import java.util.*;

//https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
public class ArrayPairDivisibleByK {

    //Inspiration: https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/solutions/1642745/java-hashmap-easy/
    public static void main(String[] args) {

        System.out.println(new ArrayPairDivisibleByK().canArrange(new int[]{-1,1,-2,2,-3,3,-4,4},3));
        System.out.println(new ArrayPairDivisibleByK().canArrange(new int[]{1,2,3,4,5,10,6,7,8,9},5));
        System.out.println(new ArrayPairDivisibleByK().canArrange(new int[]{1,2,3,4,5,6},7));
        System.out.println(new ArrayPairDivisibleByK().canArrange(new int[]{1,2,3,4,5,6},10));
        System.out.println(new ArrayPairDivisibleByK().canArrange(new int[]{1},10));
        System.out.println(new ArrayPairDivisibleByK().canArrange(new int[]{2,2},2));

    }

    public boolean canArrange(int[] arr, int k) {

            Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
           // int key = arr[i] % k;
                int key=((arr[i]%k)+k)%k;
                map.put(key,map.getOrDefault(key,0)+1);
//            if (map.get(key) == null) {
//                List<Integer> list=new ArrayList<>();
//                list.add(arr[i]);
//                map.put(key, list);
//            } else {
//                map.get(key).add(arr[i]);
//            }
        }


        for(int key:map.keySet()){

            if(key==0){
                if(map.get(key)%2!=0){
                    return false;
                }
            } else{
                if(!map.get(key).equals(map.get(k-key))){
                    return false;
                }
            }


        }
        return true;

//        int index=0;
//
//        for (int i = 0; i < arr.length; i++) {
//
//            int pair1 = arr[i] % k;
//
//            int pair2 = k - pair1;
//
//            if(pair2>=k){
//                pair2=pair2%k;
//            }
//
//            if (map.get(pair1) != null && map.get(pair2) != null) {
//                map.get(pair1).remove(0);
//                if (map.get(pair1).size() == 0) {
//                    map.remove(pair1);
//                }
//
//                map.get(pair2).remove(0);
//                if (map.get(pair2).size() == 0) {
//                    map.remove(pair2);
//                }
//                index+=2;
//                if(index>=arr.length){
//                    return true;
//                }
//            }
//            else {
//                return false;
//            }
//        }
//        return true;
    }
}
