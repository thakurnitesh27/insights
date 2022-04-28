package algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximizeNumberOfSubsequence {
    public static void main(String[] args) {

//        String text="abdcdbc";
//        String pattern="ac";
//        String text="aabb";
//        String pattern="ab";
//        String text="gkdbwhiys";
//        String pattern="th";
        String text="k";
        String pattern="jk";

        System.out.println(new MaximizeNumberOfSubsequence().process(text,pattern));
    }

    long process(String text, String pattern){

        char[] chars=text.toCharArray();
        ArrayList<Character> list=new ArrayList<>();
        for(Character c:chars){
            list.add(c);
        }
       return getMaxCount(list,pattern);
    }

    long getMaxCount(List<Character> list, String pattern){

        long maxCount=0;
        for(int i=0;i<=list.size();i++){
            if(i>0 && (list.get(i-1)==pattern.charAt(0) ||list.get(i-1)==pattern.charAt(1))) {
                list.add(i, pattern.charAt(0));
                maxCount=Math.max(maxCount,findMax(list,pattern));
                list.remove(i);
            }
            if(i<list.size()-1 &&(list.get(i+1)==pattern.charAt(0) ||list.get(i+1)==pattern.charAt(1)))
            {
                list.add(i, pattern.charAt(0));
                maxCount=Math.max(maxCount,findMax(list,pattern));
                list.remove(i);
            }
        }
        for(int i=0;i<=list.size();i++){
            if(i>0 && (list.get(i-1)==pattern.charAt(0) ||list.get(i-1)==pattern.charAt(1))) {
                list.add(i, pattern.charAt(1));
                maxCount=Math.max(maxCount,findMax(list,pattern));
                list.remove(i);
            }
            if(i<list.size()-1 &&(list.get(i+1)==pattern.charAt(0) ||list.get(i+1)==pattern.charAt(1)))
            {
                list.add(i, pattern.charAt(1));
                maxCount=Math.max(maxCount,findMax(list,pattern));
                list.remove(i);
            }
        }






        return maxCount;

    }
    long findMax(List<Character> list,String pattern){
        int count=0;
        for(int i=0;i<list.size();i++){

            if(list.get(i)==pattern.charAt(0)){

                for(int j=i+1;j<list.size();j++){
                    if(list.get(j)==pattern.charAt(1)){
                        count++;
                    }
                }
            }

        }

        return count;


    }
}
