package algo.misc;

import java.util.HashSet;

//using sliding window.

//https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
public class LongestSubstringWithoutRepeatingCharacter {

    public static void main(String[] args) {

        String s="pwwkew";
        System.out.println(new LongestSubstringWithoutRepeatingCharacter().length(s));
    }

    int length(String s){

        if(s.isEmpty()){
            return 0;
        }

        int wl=0,wr=0;
        HashSet<Character> set=new HashSet<>();
        //set.add(s.charAt(0));
       // int index=0;

        int maxCount=1;
        while (wr<s.length()){

            if(!set.contains(s.charAt(wr))){
                set.add(s.charAt(wr));
                maxCount=Math.max(maxCount,wr-wl+1);
                wr++;

            }
            else {
                set.remove(s.charAt(wl));
                wl++;
            }
        }

        return maxCount;
    }
}
