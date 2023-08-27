package algo;


import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/minimum-window-substring/
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("bbabb","baba"));
        System.out.println(new MinimumWindowSubstring().minWindow("aaflslflsldkalskaaa","aaa"));
        System.out.println(new MinimumWindowSubstring().minWindow("acbbaca","aba"));
        System.out.println(new MinimumWindowSubstring().minWindow("ab", "A"));
        System.out.println(new MinimumWindowSubstring().minWindow("a", "b"));
        System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new MinimumWindowSubstring().minWindow("abaaca", "ab"));

    }

    public String minWindow(String s, String t) {

        // Arrays.sort(t.toCharArray());
        String ans = "";
        int wl = 0, wr = 0;
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (Character c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> map = new HashMap<>();

        boolean found=false;
        for (int i = 0; i < s.length(); i++) { //find first substring containing t.
            Character temp = s.charAt(i);
            if (tMap.keySet().contains(temp)) {
                map.put(temp, map.getOrDefault(temp, 0) + 1);
                if (i >= t.length()-1 && check(map, tMap)) {
                    wr = i;
                    ans = s.substring(wl, wr + 1);
                    found=true;
                    break;
                }

            }
        }
        if(!found){
            return "";
        }
        wr++;

        while (wl < s.length()) {
            Character temp = s.charAt(wl);
            if (tMap.containsKey(temp)) {
                if (map.get(temp) > tMap.get(temp)) {
                    map.put(temp, map.get(temp) - 1);
                    wl++;
                } else if (wr < s.length()) {
                    // map.remove(temp);
                    Character removedValue = temp;
                    temp = s.charAt(wr);
                    while (wr < s.length()) {
                        if(removedValue.equals(temp)){
                            break;
                        }else if (tMap.containsKey(temp)) {
                            map.put(temp, map.getOrDefault(temp, 0) + 1);
                        }
                        wr++;
                        if(wr<s.length())
                        temp = s.charAt(wr);

                    }

                    if (tMap.containsKey(temp) && removedValue.equals(temp)) {
                        wl++;
                        wr=Math.min(wr+1,s.length());
                    }

                } else {
                    map.remove(temp);
                    wl++;
                }
            } else {
               while (wl<s.length() && !tMap.containsKey(s.charAt(wl)) && wl<wr){
                   wl++;
                }
            }

            String probableAns = s.substring(wl, wr);
            if (check(map, tMap)) {
                ans = probableAns.length() < ans.length() ? probableAns : ans;
            } else if (wr >= s.length() - 1) {
                break;
            }

        }

        String probableAns = s.substring(wl, wr);
        if (check(map, tMap)) {
            ans = probableAns.length() < ans.length() ? probableAns : ans;
        }
        return ans;

    }

    boolean check(HashMap<Character, Integer> map, HashMap<Character, Integer> tMap) {

        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            if (!map.containsKey(entry.getKey()) || (entry.getValue() > map.get(entry.getKey()))) {
                return false;
            }
        }

        return true;

    }

    boolean check(HashMap<String, Integer> map, String t) {
        return map.keySet().stream().collect(Collectors.joining()).equals(t);
    }
}
