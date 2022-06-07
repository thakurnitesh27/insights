package algo.misc;


import java.util.HashMap;

//https://leetcode.com/problems/permutation-in-string/
public class PermutationInString {

    public static void main(String[] args) {

        System.out.println(new PermutationInString().checkInclusion("ab","eidbaooo"));
        System.out.println(new PermutationInString().checkInclusion("ab","eidboaoo"));
        System.out.println(new PermutationInString().checkInclusion("adc","dcda"));
        System.out.println(new PermutationInString().checkInclusion("hello","ooolleoooleh"));
    }

    public boolean checkInclusion(String s1, String s2) {
        int wl=0,wr=0;
        HashMap<Character,Integer> originalMap=new HashMap();
        HashMap<Character,Integer> map=new HashMap();
        char[] chars=s1.toCharArray();

        for(char c:chars){
            originalMap.put(c,originalMap.getOrDefault(c,0)+1);
        }

        map.putAll(originalMap);

        boolean lastSubStringProcessed=false;

        while(wr<s2.length()){

            if(!map.keySet().contains(s2.charAt(wr))){


               if(s1.contains(s2.charAt(wl)+"")){
                   char c2=s2.charAt(wl);
                   map.put(c2,map.getOrDefault(c2,0)+1);
                   wl++;
               }else {
                   wr++;
                   wl=wr;

               }

            }
            else{
                char c2=s2.charAt(wr);
                if(map.get(c2)>1){
                    map.put(c2,map.get(c2)-1);
                  //  removedMap.put(c2,removedMap.getOrDefault(c2,0)+1);
                }else{
                    map.remove(c2);
                   // removedMap.put(c2,removedMap.getOrDefault(c2,0)+1);
                }

                if(map.size()==0){
                    return true;
                }
                lastSubStringProcessed=true;
                wr++;
            }
           // wr++;

        }
        return false;
    }
}
