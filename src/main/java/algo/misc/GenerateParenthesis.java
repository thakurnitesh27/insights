package algo.misc;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/generate-parentheses/
public class GenerateParenthesis {
    public static void main(String[] args) {

        System.out.println(new GenerateParenthesis().generate(3));

    }

    List<String> generate(int n){

      //  int length=n*2;
        List<String> ans=new ArrayList<>();
        combinations(ans,"",0,0,0,n);
        return ans;
    }

    void combinations(List<String> ans, String probableAns,int openLength,int endLength,int index,int length){

        if(probableAns.length()==length*2){
            ans.add(probableAns);
            return;
        }
//        if(openLength>length|| endLength>length){
//            return;
//        }


       if(openLength<length ){
            String s=probableAns;
            combinations(ans, s+")", openLength + 1, endLength, index, length);
        }
        if(endLength<length){

            String s=probableAns;
            combinations(ans, s+"(", openLength, endLength + 1, index, length);
        }

        }
    }


//}
