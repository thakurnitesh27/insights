package algo;

//import java8.HashMap;

import java.util.HashMap;
import java.util.Iterator;

public class MaxFrequency {

  char  findMaxFrequency(String str)
    {
        HashMap<Character,Integer> map=new HashMap();

        char[] chars=str.toCharArray();

        for(int i=0;i<chars.length;i++)
        {
            char tmpChar=chars[i];
            if(map.containsKey(tmpChar))
            {
                int count=map.get(tmpChar);
                count++;
                map.put(tmpChar,count);
            }
            else {
                map.put(tmpChar,1);
            }
        }
        Iterator<Character> iterator=map.keySet().iterator();

        int max=0;
        char finalChar=' ';
        while (iterator.hasNext())
        {
            Character character=iterator.next();
            if(max<map.get(character))
            {
                max=map.get(character);
                finalChar=character;
            }

        }

        return finalChar;

    }

    public static void main(String[] args) {
        String str="nitinnitin";
        MaxFrequency maxFrequency=new MaxFrequency();
        System.out.println(maxFrequency.findMaxFrequency(str));
    }
}
