package algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RemoveDuplicatesFromSortedArray2 {

    public int remove(ArrayList<Integer> list)
    {


        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<list.size();i++)
        {
            int num=list.get(i);
            if(map.get(num)!=null)
            {
                int count=map.get(num);
                if(count<2)
                {
                    count++;
                    map.put(num,count);
                }

            }
            else
                map.put(num,1);
        }

        list.clear();
        int totalCount=0;
        while (map.size()>0)
        {
            Map.Entry<Integer,Integer> entry=map.pollFirstEntry();

            int count=entry.getValue();
            totalCount+=count;

            for(int i=0;i<count;i++)
            {
                list.add(entry.getKey());
            }


        }
return totalCount;

    }
}
