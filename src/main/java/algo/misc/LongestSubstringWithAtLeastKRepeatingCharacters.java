package algo.misc;
//https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/


import java.util.*;
import java.util.stream.Collectors;

public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public static void main(String[] args) {
        String s="abbacbaabcdaaa";

        System.out.println(findLongestSubstring(s,3)); //3
         s="abbacbaabcc";
        System.out.println(findLongestSubstring(s,3));//11
        s="bbaaacbd";
        System.out.println(findLongestSubstring(s,3)); //3
        s="ababacb";
        System.out.println(findLongestSubstring(s,3)); //0


    }

    static   int findLongestSubstring(String s,int k){
      return findLongestSubstring(s,k,0);
    }

  static   int findLongestSubstring(String s,int k,int max){
        HashMap<Character, Integer> map=new HashMap();
        for(Character c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

       Set<Character> lessThanK= map.keySet().stream().filter(c-> map.get(c)<k).collect(Collectors.toSet());
        if(lessThanK.size()>0){
            return   find(s,lessThanK,0,k);
        }
        else {
            return Math.max(s.length(),max);
        }

    }

  static   int find(String s, Set<Character>set,int max,int k){
        if(set.size()>0) {
            Character toRemove=set.iterator().next();
         String [] splitted=   s.split(toRemove.toString());
         set.remove(toRemove);
         for(String temp:splitted){
             if(temp.length()>0) {
                 int ans = find(temp, set, max, k);
                 max = Math.max(max, ans);
             }
         }
         set.add(toRemove);

        }else if(s.length()>0) {
//            HashMap<Character,Integer> map=new HashMap<>();
//            for(Character c:s.toCharArray()){
//                map.put(c,map.getOrDefault(c,0)+1);
//            }
//           Set<Character> lessThanK= map.keySet().stream().filter(key-> map.get(key)<k).collect(Collectors.toSet());
//            if(lessThanK.size()==0) {
//                max = Math.max(max, s.length());
//            }else {
//                for(Character c:lessThanK){
//                    s=s.replaceAll(c.toString(),"");
//                }
//                s=s.trim();
//                max = Math.max(max, s.length());


          //  }

            return findLongestSubstring(s,k,max);
        }
        return max;
    }
}
