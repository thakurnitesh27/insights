package algo.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MaximumLengthOfConcatenatedString {

    public static void main(String[] args) {

        String[] arr = new String[]{"ana", "un", "iq", "ue"};
        System.out.println(new MaximumLengthOfConcatenatedString().maxLength(Arrays.asList(arr)));

        arr = new String[]{"abcdefghijklmnopqrstuvwxyz"};
        System.out.println(new MaximumLengthOfConcatenatedString().maxLength(Arrays.asList(arr)));

        arr = new String[]{"aa", "bb"};
        System.out.println(new MaximumLengthOfConcatenatedString().maxLength(Arrays.asList(arr)));

        arr = new String[]{"ab", "cd", "cde", "cdef", "efg", "fgh", "abxyz"};
        System.out.println(new MaximumLengthOfConcatenatedString().maxLength(Arrays.asList(arr)));

        arr = new String[]{"a", "abc", "d", "de", "def"};
        System.out.println(new MaximumLengthOfConcatenatedString().maxLength(Arrays.asList(arr)));


    }

    int max = 0;

    int maxLength(List<String> arr) {
        max = 0;
        String s = maximumLength(arr, "", 0);
        max = Math.max(s.length(), max);
        return max;
    }

    String maximumLength(List<String> arr, String concatenated, int iIndex) {

        for (int i = iIndex; i < arr.size(); i++) {

            //HashSet<Character> set=new HashSet<>();
            String lastConcatenated = concatenated;
            String currentString = concatenated + arr.get(i);
            Boolean isIthElementUnique = areElementsUnique(currentString);


            if (!isIthElementUnique) {
                continue;
            }
            int count = currentString.length();
            if (max < count) {
                max = count;
            }
            concatenated = maximumLength(arr, currentString, i + 1);

            if (concatenated.length() > max) {
                max = concatenated.length();
            }
            concatenated = lastConcatenated;
        }


        return concatenated;

    }

    boolean areElementsUnique(String s) {
        HashSet<Character> set = new HashSet<>();
        Boolean areElementsUnique = true;
        for (Character c : s.toCharArray()) {
            if (set.contains(c)) {
                areElementsUnique = false;
                break;
            }
            set.add(c);

        }

        return areElementsUnique;
    }
}
