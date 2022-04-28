package algo.misc;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/
public class MinimumNoOfFlips {
    public static void main(String[] args) {

        System.out.println(new MinimumNoOfFlips().minFlipCopied("10001100101000000"));
        System.out.println(new MinimumNoOfFlips().minFlipCopied("01001001101"));
        System.out.println(new MinimumNoOfFlips().minFlipCopied("010"));
        System.out.println(new MinimumNoOfFlips().minFlipCopied("111000"));
    }

//    public int minFlipsNew(String s){
//        int dp[]=new int[s.length()];
//        dp[0]=1;
//        for(int i=1;i<s.length();i++){
//
//        }
 //   }

    //https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/discuss/1253874/C%2B%2B-Solution-sliding-window.-O(N)-Time-O(1)-Space
    public int minFlipCopied(String s){

        int n=s.length();
        String s1=s+s;
        char[] cs1=s1.toCharArray();
        char[] cs2=new char[cs1.length];
        char[] cs3=new char[cs1.length];
        cs2[0]='0';
        cs3[0]='1';

        int ans=Integer.MAX_VALUE,ans1=0,ans2=0;
        for(int i=0;i<s1.length();i++){
            if(i>0) {
                cs2[i] = (char) ('0'+  ('1' -cs2[i - 1]));
                cs3[i] =  (char) ('0'+  ('1' -cs3[i - 1]));
            }

            if(cs1[i]!=cs2[i]) ans1++;
            if(cs1[i]!=cs3[i])ans2++;

            if(i>=n){
                if(cs1[i-n]!=cs2[i-n]) ans1--;
                if(cs1[i-n]!=cs3[i-n]) ans2--;
            }

            if(i>=n-1){
                ans=Math.min(ans,Math.min(ans1,ans2));
            }

        }
        return ans;
    }
   public int minFlipsNew(String s){
        int length=s.length();
        int wl=0,wr=1;
        int count=0;
        int maxCount=Integer.MIN_VALUE;
       List<Pair> list=new ArrayList<>();

        while (wr<=length){
            if(wr<length &&s.charAt(wr-1)!=s.charAt(wr)){
                wr++;
                count++;

            }
            else {
                if(count>maxCount){

                    list=new ArrayList<>();
                    list.add(new Pair(wl,wr-1));
                    maxCount=count;
                }else if(count==maxCount){
                    list.add(new Pair(wl,wr-1));
                }
                count=0;
                wl=wr;
                wr++;
            }

        }
       int minCount = Integer.MAX_VALUE;
       for(Pair p:list) {
           int maxIIndex=p.i,maxJIndex=p.j;

           String s1 = s.substring(maxIIndex) + s.substring(0, maxIIndex);
           count = Integer.MAX_VALUE;
           count = findCount(s1);
           minCount = Math.min(count, minCount);

           int count2 = 0;
           int count3 = 0;
           char c = s1.charAt(s1.length() - 1);
           String s2 = "";
           String s3 = "";
           if (s1.startsWith("1")) {
               count3++;

           } else {
               count2++;
           }
           s2 = '1' + s1.substring(1);
           s3 = '0' + s1.substring(1);

           count2 += findCount(s2);
           count3 += findCount(s3);
           minCount = Math.min(minCount, Math.min(count2, count3));
       }

       return minCount;

    }

    public int minFlips(String s) {

        int minCount=Integer.MAX_VALUE;
        String s1=s;
        int count=findCount(s1);
        minCount=Math.min(count,minCount);


      if(s.startsWith("0")  && s.endsWith("1")) {
           s1 = "1" + s.substring(1, s.length() - 1) + "0";
          count=findCount(s1);
          minCount=Math.min(count,minCount);
      }else if(s.startsWith("1") && s.endsWith("0")){
            s1 = "0" + s.substring(1, s.length() - 1) + "1";
          count=findCount(s1);
          minCount=Math.min(count,minCount);
        }
        else if(s.startsWith("0")) {
          s1 = "1" + s.substring(1, s.length());
          count=findCount(s1);
          minCount=Math.min(count,minCount);
      } else if(s.startsWith("1")){
          s1 = "0" + s.substring(1, s.length());
          count=findCount(s1);
          minCount=Math.min(count,minCount);
      }
        return minCount;

    }

    int findCount(String s){
        int count=0;
        char[]  subChar=s.toCharArray();
        for(int i=1;i<subChar.length;i++){
            if(subChar[i-1]==subChar[i]){
                subChar[i]= subChar[i]=='1'?'0':'1';
                count++;
            }
        }
        return count;
    }

    class Pair{
        int i;
        int j;

        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
}
