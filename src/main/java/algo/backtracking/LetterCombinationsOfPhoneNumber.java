package algo.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfPhoneNumber().letterCombinations("23"));
        System.out.println(new LetterCombinationsOfPhoneNumber().letterCombinations("2"));

    }

    public List<String> letterCombinations(String digits) {

        if(digits==null || digits.isEmpty()){
            return new ArrayList<>();
        }

        Map<Integer,List<String>> map=new HashMap<>();
        Character character=new Character('a');
        for(int i=2;i<=9;i++){

            List<String> list=new ArrayList<>();
            int length=3;
            if(i==7 || i==9){
                length=4;
            }
            for(int j=0;j<length;j++){
                list.add(character.toString());
                character++;
            }
            map.put(i,list);
        }



        List<String> ans=new ArrayList<>();
        int[] candidates=new int[digits.length()];
        for(int i=0;i<candidates.length;i++){
            candidates[i]=Integer.parseInt(digits.substring(i,i+1));
        }
        combination(ans,"",candidates,map,0,digits.length());
        return ans;

    }

   void combination(List<String> ans, String probableAnswer, int[] candidates,Map<Integer,List<String>> map,int startIndex,int length){
        if(probableAnswer.length()>length){
            return;
        }
        if(probableAnswer.length()==length){
            ans.add(probableAnswer);
            return;
        }
        for(int i=startIndex;i<candidates.length;i++){
           List<String> list= map.get(candidates[i]);
           for(int j=0;j<list.size();j++){
               String s=new String(probableAnswer)+list.get(j);
               combination(ans,s,candidates,map,i+1,length);
           }

        }
   }
}
