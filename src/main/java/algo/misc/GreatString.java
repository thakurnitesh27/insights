package algo.misc;

import java.util.*;

public class GreatString {
    public static void main(String[] args) {
        System.out.println(goodString(8,3,"abbabaab",new int[]{6,3,5,1,4,2,7,8},new int[][]{
                {1,3},
                {4,7},
                {3,5}
        }));
 System.out.println(goodString(5,2,"aaaaa",new int[]{2,4,1,3,5},new int[][]{
                {1,2},
                {4,5}
        }));

    }

    static int goodString(int N, int Q, String S, int[] arr, int[][] ranges) {
        Map<Character, Integer>[] maps = new HashMap[Q];

        char[] chars = new char[S.length() + 1];

        chars[0] = ' ';
        for (int i = 0; i < S.length(); i++) {
            chars[i + 1] = S.charAt(i);
        }
        int setIndex = 0;
        for (int i = 0; i < ranges.length; i++) {
            int startIndex = ranges[i][0];
            int endIndex = ranges[i][1];

            Map<Character, Integer> map = new HashMap();

            for (int j = startIndex; j <= endIndex; j++) {
                map.put(chars[j], map.getOrDefault(chars[j], 0) + 1);
            }

            maps[setIndex] = map;
            setIndex++;

        }

        int count=0;
        if(checkUniqueMaps(maps)){
            return count;
        }

        for(int i=0;i<arr.length;i++) {
            List<Integer> indexes = findRange(ranges, arr[i]);
            for (int index : indexes) {
                Map<Character, Integer> currentMap = maps[index];

                if (currentMap.get(chars[arr[i]]) > 1) {
                    currentMap.put(chars[arr[i]], currentMap.get(chars[arr[i]]) - 1);
                } else {
                    currentMap.remove(chars[arr[i]]);
                }


            }
            count++;
            if (checkUniqueMaps(maps)) {
                return count;
            }
        }
        return count;
    }

    private static boolean checkUniqueMaps(Map<Character, Integer>[] maps) {
        for(int i=0;i<maps.length;i++){
            if(maps[i].keySet().isEmpty()){
                continue;
            }
            if(maps[i].values().stream().filter(k->k>1).findAny().isPresent()){
                return false;
            }
        }
        return true;

    }

    static List<Integer> findRange(int[][] range, int index){
        List<Integer> ranges=new ArrayList<>();
        for(int i=0;i<range.length;i++){
            if(range[i][0]<=index && index<=range[i][1]){
               ranges.add(i);
            }
        }
        return ranges;


    }
}
