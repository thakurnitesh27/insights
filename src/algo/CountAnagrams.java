package algo;

import java.util.*;

public class CountAnagrams {

    public static List<Long> countSentences(List<String> wordSet, List<String> sentences) {
        // Write your code here
        HashMap<String, HashSet<String>> map=new HashMap<>();
        int [] characters;
     out:   for(int i=0;i<wordSet.size();i++)
        {
            String word=wordSet.get(i);

            Iterator<String> iterator=  map.keySet().iterator();
//        while (iterator.hasNext())
//        {
//            String key=iterator.next();
//            if(key.hashCode()==word.hashCode()&&key.length()==word.length())
//            {
//                HashSet<String> set=map.get(key);
//                set.add(word);
//                map.put(word,set);
//                continue out;
//            }
//        }
        characters= new int[122];
            HashSet<String> set=map.get(word);
            if(set==null)
            {
                set=new HashSet<>();
                set.add(word);
            }
            char[] chars=word.toCharArray();
            for(int k=0;k<chars.length;k++)
            {
                characters[chars[k]]++;
            }


          outer:  for(int j=0;j<wordSet.size();j++)
            {
                if(i==j||wordSet.get(j).length()!=word.length())
                    continue;




                int[] tmpChar=new int[characters.length];
//                for(int l=0;l<tmpChar.length;l++)
//                    tmpChar[l]=characters[l];
                char [] chars1=wordSet.get(j).toCharArray();

                for(int l=0;l<chars1.length;l++)
                    tmpChar[chars1[l]]++;

                boolean skip=false;
                for(int l=0;l<tmpChar.length;l++)
                {
                    if(tmpChar[l]!=characters[l])
                    {
                        skip=true;
                        break ;
                    }
                }

                if(!skip)
               set.add(wordSet.get(j));



            }

            if(set.size()>1)
                map.put(word,set);

        }

        List<Long> ans=new ArrayList<>();

        for(int i=0;i<sentences.size();i++)
        {
String[] words=sentences.get(i).trim().split(" ");

long count=1;
for(int j=0;j<words.length;j++)
{
    if(map.get(words[j])!=null)
    {
        count*=(map.get(words[j])).size();
    }

}
ans.add(count);
        }


        return ans;

    }

    public static void main(String[] args) {
       // CountAnagrams countAnagrams=new CountAnagrams();
        List<String> wordsSet=new ArrayList<>();
        wordsSet.add("the");
        wordsSet.add("bats");
        wordsSet.add("tabs");
        wordsSet.add("in");
        wordsSet.add("cat");
        wordsSet.add("act");


        List<String> sentences=new ArrayList<>();
        sentences.add("cat the bats");
        sentences.add("in the act");
        sentences.add("act tabs in");
       // sentences.add("");
      List<Long> ans=  CountAnagrams.countSentences(wordsSet,sentences);

    }
}
