package algo.backtracking;

import java.util.*;

//https://leetcode.com/problems/count-number-of-texts/
public class CountNumberOfTexts {
  //  int count=0;

    public static void main(String[] args) {

       // System.out.println(new CountNumberOfTexts().countTexts("222"));
       // System.out.println(new CountNumberOfTexts().countTextsNew("22222"));
        System.out.println(new CountNumberOfTexts().countTextsNew("344644885"));
      //  System.out.println(new CountNumberOfTexts().countTextsNew("222222222222222222222222222222222222"));
    }

    public int countTextsNew(String pressedKeys){
       int MOD= (int) (Math.pow(10,9)+7);
        int []dp=new int[pressedKeys.length()+1];
        dp[0]=1;
        for (int i=1;i<(pressedKeys.length()+1);i++) {

            dp[i] = dp[i - 1] % MOD;
            if (i - 2 >= 0 && pressedKeys.charAt(i - 1)==pressedKeys.charAt(i - 2)) {
                dp[i] = (dp[i] + dp[i - 2]) % MOD;
            }
            else continue;
            if (i - 3 >= 0 && pressedKeys.charAt(i - 1)==pressedKeys.charAt(i - 3) ){
                dp[i] = (dp[i] + dp[i - 3]) % MOD;
            }
            else continue;
            if ((pressedKeys.charAt(i-1)=='7' || pressedKeys.charAt(i-1)=='9') &&
                    i - 4 >= 0 && pressedKeys.charAt(i - 1)==pressedKeys.charAt(i - 4) ){
                dp[i] = (dp[i] + dp[i - 4]) % MOD;
            }
            else continue;

        }
        return dp[dp.length-1];
    }

    public int countTexts(String pressedKeys) {

        Map<Integer, List<String>> map = new HashMap<>();

        Character c = new Character('a');
        int i = 2;

        while (i < 10) {

            int length = 3;
            if (i == 7 | i == 9) {
                length = 4;
            }

            map.put(i, new ArrayList<>());

            for (int j = 0; j < length; j++) {
                map.get(i).add(c.toString());
                c++;
            }
            i++;
        }

        //  Map<Integer,Integer> limitHolder=new HashMap<>();

        Integer[] candidates=new Integer[pressedKeys.length()];

        for(int k=0;k<pressedKeys.length();k++){
            candidates[k]=Integer.parseInt(pressedKeys.charAt(k)+"");
        }

        int[] dp=new int[candidates.length];
        Arrays.fill(dp,-1);

        List<String> ans=new ArrayList<>();
      long count=  combinationsDP(ans,0,"",map,candidates,dp);
        return (int) (count%(Math.pow( 10,9)+7));

    }
    public List<String> printTexts(String pressedKeys) {

        Map<Integer, List<String>> map = new HashMap<>();

        Character c = new Character('a');
        int i = 2;

        while (i < 10) {

            int length = 3;
            if (i == 7 | i == 9) {
                length = 4;
            }

            map.put(i, new ArrayList<>());

            for (int j = 0; j < length; j++) {
                map.get(i).add(c.toString());
                c++;
            }
            i++;
        }

      //  Map<Integer,Integer> limitHolder=new HashMap<>();

        Integer[] candidates=new Integer[pressedKeys.length()];

        for(int k=0;k<pressedKeys.length();k++){
            candidates[k]=Integer.parseInt(pressedKeys.charAt(k)+"");
        }

        List<String> ans=new ArrayList<>();
        combinations(ans,0,"",map,candidates,0);
        return ans;

    }
    int combinations(List<String> ans,int index,String probableAnswer,Map<Integer,List<String>> map,Integer[] chars,int count){

        if(index==chars.length){
          //  ans.add(probableAnswer);
           count++;
        }

        if(index>chars.length){
            return count;
        }

        for(int i=index;i<chars.length;i++){

            if(i!=0 && chars[i-1]==chars[i]){

              List<String> alphabets=  map.get(chars[i]);

            //  for(int j=0;j<=i-probableAnswer.length();j++){
                if(i-index<alphabets.size() ) {
                    String temp = probableAnswer + alphabets.get(i - index);

                   count= combinations(ans, i + 1, temp, map, chars,count);
                }else {
                    break;
                }
//                  if(r==true){
//                      return true;
//                  }
             // }
            }else {
                if(i-index<=0) {
                    List<String> alphabets = map.get(chars[i]);
                 count=   combinations(ans, i + 1, probableAnswer + alphabets.get(0), map, chars,count);
                }
                else {
                    break;
                }
            }
        }
        return count;
    }


    int combinationsDP(List<String> ans,int index,String probableAnswer,Map<Integer,List<String>> map,Integer[] chars,int [] dp){

        if(index==chars.length){
            //  ans.add(probableAnswer);
           return 1;
        }

        if(dp[index]!=-1){
            return dp[index];
        }
        int count=0;

        for(int i=index;i<chars.length;i++){

            if(i!=0 && chars[i-1]==chars[i]){

                List<String> alphabets=  map.get(chars[i]);

                //  for(int j=0;j<=i-probableAnswer.length();j++){
                if(i-index<alphabets.size() ) {
                    String temp = probableAnswer + alphabets.get(i - index);

                    count+= combinationsDP(ans, i + 1, temp, map, chars,dp);
                }else {
                    break;
                }
//                  if(r==true){
//                      return true;
//                  }
                // }
            }else {
                if(i-index<=0) {
                    List<String> alphabets = map.get(chars[i]);
                    count+=   combinationsDP(ans, i + 1, probableAnswer + alphabets.get(0), map, chars,dp);
                }
                else {
                    break;
                }
            }
           count= (int) (count%(Math.pow( 10,9)+7));
        }
        dp[index]=count;
        return count;
    }
}
