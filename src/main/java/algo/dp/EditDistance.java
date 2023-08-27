package algo.dp;

//https://leetcode.com/problems/edit-distance/?envType=study-plan-v2&envId=top-interview-150
public class EditDistance {

    public static void main(String[] args) {
        System.out.println(new EditDistance().minDistanceNew("", "a"));
        System.out.println(new EditDistance().minDistanceNew("horse", "ros"));
        System.out.println(new EditDistance().minDistanceNew("intention", "execution"));
    }

    public int minDistanceNew(String word1, String word2) {

        int[][] dp=new int[word1.length()+1][word2.length()+1];
         find(word1.length(),word2.length(),word1,word2,dp);
         return dp[dp.length-1][dp[0].length-1];
    }

    public int find(int i, int j, String word1, String word2,int[][] dp){

        if(i==0){
            dp[i][j]=j;
            return j;
        }
        if(j==0){
            dp[i][j]=i;
            return i;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }

        if(word1.charAt(i-1)==word2.charAt(j-1)){
            int ans= find(i-1,j-1,word1,word2,dp);

            dp[i][j]=ans;
            return ans;
        }
        //insert
       int insert= find(i,j-1,word1,word2,dp);
        //delete
       int delete= find(i-1,j,word1,word2,dp);
        //replace
        int replace=find(i-1,j-1,word1,word2,dp);

       int min= Math.min(insert,Math.min(delete,replace))+1;

       dp[i][j]=min;
       return min;


    }




    public int minDistance(String word1, String word2) {

        int[] dp = new int[word1.length()];
        int max = 0;

        for (int i = word2.length() - 1; i >= 0; i--) {

            int value = 0;
            boolean found = false;
            int index = -1;
            for (int j = 0; j < word1.length(); j++) {
                if (word2.charAt(i) == word1.charAt(j)) {
                    value = 1;

                    for (int k = j + 1; k < word1.length(); k++) {
                        value = Math.max(value, dp[k] + 1);
                    }
                    max = Math.max(max, value);
                    dp[j] = value;
                }

            }


        }
        return word1.length() - max;

    }
}
