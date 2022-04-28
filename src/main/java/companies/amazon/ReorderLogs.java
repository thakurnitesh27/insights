package companies.amazon;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/reorder-data-in-log-files/
public class ReorderLogs {
    public static void main(String[] args) {

        String [] arr=new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        System.out.println(new ReorderLogs().reorderLogFiles(arr));
    }

    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs,getComparator());
        return logs;

    }

    public Comparator<String> getComparator(){
        return (String s1,String s2)->{
           int spaceIndex= s1.indexOf(" ");
            String id1=s1.substring(0,spaceIndex);
            String content1=s1.substring(spaceIndex+1);
            spaceIndex=s2.indexOf(" ");
            String id2=s2.substring(0,spaceIndex);
            String content2=s2.substring(spaceIndex+1);
            if(content1.matches("^[a-z].+") &&  content2.matches("^[a-z].+")){
                int compare= content1.compareTo(content2);
                if(compare==0){
                    return id1.compareTo(id2);
                }
                return compare;
            } else if(content1.matches("^[a-z].+"))
            {
                return -1;
            } else if(content2.matches("^[a-z].+")){
                return 1;
            }
            else if(content1.matches("[0-9].+") &&  content2.matches("[0-9].+"))
            {
               return 0;
            }
            return 0;
        };

    }
}
