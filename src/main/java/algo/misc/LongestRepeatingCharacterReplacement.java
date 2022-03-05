package algo.misc;

//
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {

       // System.out.println(new LongestRepeatingCharacterReplacement().find("AABABBA",1));
      //  System.out.println(new LongestRepeatingCharacterReplacement().find("ABCDE",1));
        System.out.println(new LongestRepeatingCharacterReplacement().find(
                "IMNJJTRMJEGMSOLSCCQICIHLQIOGBJAEHQOCRAJQMBIBATGLJDTBNCPIFRDLRIJHRABBJGQAOLIKRLHDRIGERENNMJSDSSMESSTR",
                2));
//        System.out.println(new LongestRepeatingCharacterReplacement().find(
//                "KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF",4));


    }

    int find(String s,int k){

        char[] chars=s.toCharArray();
        char maxOccurredChar='q';
        int maxCount=Integer.MIN_VALUE;
        HashMap<Character,Integer> map=new HashMap();
       // TreeMap<Character,Integer> treeMap=new TreeMap<>();
        //treeMap.pu
        for(int i=0;i<chars.length;i++){
            Character key=chars[i];
            int count=0;
            if(map.containsKey(key)){
                 count=map.get(key);
                ++count;
                map.put(key,count);

            }
            else {
                count=1;
                map.put(key,count);
            }
            if(count>maxCount){
                maxCount=count;
                maxOccurredChar=key;
            }
        }

        ArrayList<Character> maxOccurredCharList=new ArrayList<>();

//        for(Character c: map.keySet()){
//           Integer tmp= map.get(c);
//           if(tmp==maxCount){
//               maxOccurredCharList.add(c);
//           }
//        }

        maxOccurredCharList.addAll(map.keySet());

        int maxAnswer=Integer.MIN_VALUE;
        for(int i=0;i<maxOccurredCharList.size();i++) {
            maxOccurredChar=maxOccurredCharList.get(i);
            int wl = 0, wr = 0;
            int permissibleCount = 0;

            while (wr < chars.length) {

                if (chars[wr] == maxOccurredChar) {
                    wr++;
                } else {
                    if (permissibleCount < k) {
                        permissibleCount++;
                        wr++;
                    } else {
                        if (chars[wl] != maxOccurredChar) {
                            permissibleCount--;
                        }
                        wl++;
                    }
                }

                if (maxAnswer < (wr - wl)) {
                    maxAnswer = wr - wl;
                }
            }
        }

        return  maxAnswer;

    }
}
