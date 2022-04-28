package algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParathesis {

    public static void main(String[] args) {
        System.out.println(new GenerateParathesis().generate(3));
        System.out.println(new GenerateParathesis().generate(4));
        System.out.println(new GenerateParathesis().generate(5));
        System.out.println(new GenerateParathesis().generate(6));
       // System.out.println(compare("(()())(),((()())),()(()()),(())()(),((())()),()(())(),((()))(),(((()))),()((())),()(())(),(()(())),()()(())",
            //    "(((()))),((()())),((())()),((()))(),(()(())),(()())(),(())(()),(())()(),()((())),()(()()),()(())(),()()(())"));

    }
    List<String> generate(int n){

        //String dp[List<String>]=new String[];
        List<List<String>> list=new ArrayList<>();
        list.add(0,null);
        list.add(1, Arrays.asList("()"));

        for(int i=2;i<=n;i++){
            List<String> result=new ArrayList<>();

            for(int j=0;j<list.get(i-1).size();j++){
                String lastResult=list.get(i-1).get(j);
                result.add(lastResult+"()");
                result.add("("+lastResult+")");
                if(j>0){
                    result.add("()"+lastResult);
                }
            }
            list.add(i,result);
        }

        return list.get(list.size()-1);
    }
/*
Actual:     [""(()())()","((()()))","()(()())","(())()()","((())())","()(())()","((()))()","(((())))","()((()))","()(())()","(()(()))","()()(())"]
Expected:   ["(((())))","((()()))","((())())","((()))()","(()(()))","","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())"]
 */


static boolean compare(String s1,String s2){
    
    String [] s1s=s1.split(",");
    String [] s2s=s2.split(",");
    System.out.println("S1");
    for(String t:s1s){
        if(!s2.contains(t)){
            System.out.println(t);
           return false;
        }
    }
    System.out.println("S2");
    for(String t:s2s){
        if(!s1.contains(t)){
            System.out.println(t);
           return false;
        }
    }

    return true;
}
}
