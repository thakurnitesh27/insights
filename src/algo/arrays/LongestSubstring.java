package algo.arrays;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstring {

    public static void main(String[] args) {
       // String s="abcabcbb";
        String s="aab";

        System.out.println(findLength1(s));
    }

    private static int findLength(String s)
    {

        int max_length=0;
        int len=0;
        int temp=-1;

        for(int i=0;i<s.length();i++)
        {

            char t=s.charAt(i);
            if((t^temp)==0)
            {
                if(max_length<len)
                {
                    max_length=len;
                }
                len=0;
                temp=-1;
            }
            else {
                len++;
                temp=temp^t;

            }
        }
        return max_length;
    }


    private static int findLength1(String s)
    {

        HashMap<Character, List> map=new HashMap();

        for(int i=0;i<s.length();i++)
        {
            if(map.get(s.charAt(i))==null)
            {
              List l=  new ArrayList<Integer>();
              l.add(i);
                map.put(s.charAt(i), l);
            }
            else {
               List<Integer>indexes= map.get(s.charAt(i));
               indexes.add(i) ;
          //  map.put(s.charAt(i),indexes);
            }
        }
        String dupStr="";
        List<Integer> indexes=null;

        for(Character c:map.keySet())
        {
            if(map.get(c).size()>1)
            {
               dupStr=c+"";
               indexes=map.get(c);
               break;
            }
        }
        if(indexes==null)
        {
            return 0;
        }

        int max_length=indexes.get(0)-0;

        for(int i=1;i<indexes.size();i++)
        {
            if(max_length<(indexes.get(i)-indexes.get(i-1)))
            {
                max_length=indexes.get(i)-indexes.get(i-1);
            }
        }

        if(max_length<((s.length())-indexes.get(indexes.size()-1)))
        {
            if(map.get(s.charAt(s.length()-1)).size()==1) {
                max_length = (s.length()) - indexes.get(indexes.size() - 1);
            }
        }

        return max_length;
    }
}
