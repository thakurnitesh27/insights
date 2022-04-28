package algo.dp;

//https://leetcode.com/problems/longest-common-subsequence/
public class LongestCommonSubsequence
{

    public static void main(String[] args) {

        String x="abcde",y="ace";
       // String x="abc",y="abc";

        System.out.println(new LongestCommonSubsequence().findLongestCommonSubsequence(x,y));

    }
    public int findLongestCommonSubsequence(String x, String y){

        int [][]c=new int[x.length()+1][y.length()+1];
        for(int i=0;i<=x.length();i++){
            c[i][0]=0;
        }
        for(int i=0;i<=y.length();i++){
            c[0][i]=0;
        }
        for(int i=1;i<=x.length();i++){

            for(int j=1;j<=y.length();j++){

                if(x.charAt(i-1)==y.charAt(j-1)){
                    c[i][j]=c[i-1][j-1]+1;
                }
                else {
                    if(c[i-1][j]<c[i][j-1]){
                        c[i][j]=c[i][j-1];
                    }
                    else{
                        c[i][j]=c[i-1][j];
                    }
                }
            }
        }

        return c[x.length()][y.length()];
    }
}
