package algo.arrays;

import java.util.Arrays;
/*
https://www.interviewbit.com/problems/sorted-permutation-rank/

It involves permutation logic.
Consider the string "string". If we sort it, it will be "ginrst".
If we place s at 0 place, all characters smaller than s, will come first lexicographically. So g,i,n,r will comes first.
t will not come. So 5 places are vacant after 1st place and they will be placed in permutation = 5!.
For 4 characters, it will be 4*5!.
For details see explanation: https://www.geeksforgeeks.org/lexicographic-rank-of-a-string/

findIndex returns the number of characters which are smaller than current character. For s, 4 characters namely, g,i,n,r
are smaller, so index will be 4. Since java stores array with 0 as starting index, we simply return the index.
If the permutation of any character is computed via calling findIndex, that character is marked null. , is used to denote null character
here.
So once s is permuted, for t 4 will be the index because s is marked null. Else it would have returned 5.
Also 4 characters are smaller than t- g,i,n,r.
The factorial and response can be very large and so modulus with 1000003 is done to truncate the result.(interviewbit condition.)
 */

public class SortedPermutationRank {

    public static void main(String[] args) {

        System.out.println(new SortedPermutationRank().findPermutationRank("ZCSFLVHXRYJQKWABGT"));
        System.out.println(new SortedPermutationRank().findPermutationRank("gTFAMYjxCewRlftmGOKJHUuhSBVDZnbqyoPQadEkLrpNsv"));
    }

   int findPermutationRank(String  s){
        char[] sorted=s.toCharArray();
       Arrays.sort(sorted);

       long response=0;
       long length=s.length()-1;
       int processed=0;

       for(char c: s.toCharArray()){

         int index=  findIndex(c,sorted);
        // int charsPlacedBeforeCurrentChar=index-processed<1?1:index-processed;
          long val= index*factorial(length);
           System.out.println(val);
          response+=val;
          length--;
          processed++;
          response=response%1000003;
           System.out.println("Resp: "+response);
       }
       response++;

       return (int)(response%1000003);

    }

    private int findIndex(char c, char[] arr){

        int index=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==c){
                arr[i]=',';
                return index;
            }
            else if(arr[i]!=','){
                index++;
            }
        }

        return -1;
    }

    private long factorial(long num){
        if(num>1){
             long num1=factorial(num-1);
            num1= num1%1000003;
            return num*num1;
        }
        return num;
    }
}
