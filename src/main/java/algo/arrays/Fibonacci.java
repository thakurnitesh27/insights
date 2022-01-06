package algo.arrays;

import java.util.*;

public class Fibonacci {
//1,1,2,3,5,8
   // private static Map<Integer,Integer> map=new HashMap<>();
    public static void main(String[] args) {
        ///fib(5);
        System.out.println(findMax("helloworld"));
        System.out.println(deviceNames(Arrays.asList("switch","tv","switch","tv","switch","tv")));
        System.out.println(palindrome("bab"));
    }

//    private static int fib(int num){
////
////        if(map.get(num)==null) {
////            int val=0;
////            if(num==0|| num==1){
////                val=1;
////               // return 1;
////            } else {
////                val = fib(num - 1) + fib(num - 2);
////            }
////            map.put(num,val);
////            System.out.println(val);
////            return val;
////        }
////        else {
////            return map.get(num);
////        }
////
////    }

   static char findMax(String text){
        Map<Character, Integer> countMap=new HashMap<>();
        for(int i=0;i<text.length();i++){

            char c=text.charAt(i);
            Integer count=0;
            if(countMap.get(c)==null){

               count++;
            }
            else {
               count= countMap.get(c);
               count++;
            }
            countMap.put(c,count);
        }

        int maxLength=0;
        Character result=null;
        for(int i=0;i<text.length();i++){
            Integer count=countMap.get(text.charAt(i));
            if(count>maxLength){
                maxLength=count;
                result=text.charAt(i);
            }
        }

        return result;

    }

    static List<String> deviceNames(List<String> deviceNames){
        Map<String, Integer> map=new HashMap<>();
        List<String> result=new ArrayList<>();
        for(int i=0;i<deviceNames.size();i++)
        {
            int count=0;
            String s=deviceNames.get(i);
            if(map.get(s)==null){
                result.add(s);
                map.put(s,++count);
            }
            else {
               count= map.get(s);
               result.add(s+count);
               map.put(s,++count);

            }
        }
        return result;

    }

    static String palindrome(String palindromeStr){

       // if(palindromeStr.length()%2!=0)
           // return "IMPOSSIBLE";

        int mid=palindromeStr.length()/2;
        Character s1=palindromeStr.charAt(mid);
        Character s2=null;
       // checkPalindrome(palindromeStr);
        if(mid>1) {
             s2 = palindromeStr.charAt(mid - 2);
        }
        else {
            //s2=palindromeStr.charAt();
            if(s1.charValue()<=97){
                s2='a';
            }
            else
            {
                s2=new Character((char)(s1.charValue()-1));
            }
        }
        if(s1<s2){
            return palindromeStr.substring(0,mid-1)+s1+palindromeStr.substring(mid);
        }
        else
        {
            return palindromeStr.substring(0,mid-1)+s2+palindromeStr.substring(mid);
        }

    }

//    private static boolean checkPalindrome(String palindromeStr) {
//
//        int i=0;
//        int l=palindromeStr.length()/2;
//        while (i<l){
//
//        }
//    }
}
