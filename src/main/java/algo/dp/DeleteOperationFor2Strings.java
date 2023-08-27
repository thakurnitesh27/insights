package algo.dp;
//https://leetcode.com/problems/delete-operation-for-two-strings/description/
public class DeleteOperationFor2Strings {

    public static void main(String[] args) {

        System.out.println(new DeleteOperationFor2Strings().minDistance("sea","eat"));
        System.out.println(new DeleteOperationFor2Strings().minDistance("leetcode","etco"));
        System.out.println(new DeleteOperationFor2Strings().minDistance("a","b"));
        System.out.println(new DeleteOperationFor2Strings().minDistance("oa","ob"));
    }

    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        find(word1.length(),word2.length(),word1,word2,dp);
        return dp[dp.length-1][dp[0].length-1];
    }

    int find(int i, int j, String word1, String word2,int[][] dp){

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

        int delete1=find(i-1,j,word1,word2,dp);


        int delete2=find(i,j-1,word1,word2,dp);


        int deleteBoth=find(i-1,j-1,word1,word2,dp);

        int min=Integer.MAX_VALUE;

        if(deleteBoth<delete1 && deleteBoth<delete2){
            min=deleteBoth+2;
        }
        else {
            min=Math.min(delete1,delete2)+1;
        }

        dp[i][j]=min;

        return min;

    }

    int findOld(int i, int j, String word1, String word2,int[][] dp){

//        if(i==0){
//            dp[i][j]=Integer.MAX_VALUE;
//            return Integer.MAX_VALUE;
//        }
//        if(j==0){
//            dp[i][j]=Integer.MAX_VALUE;
//            return Integer.MAX_VALUE;
//        }

        if(i==0 ||j==0){
          return -1;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }

        if(word1.charAt(i-1)==word2.charAt(j-1)){
           int ans= find(i-1,j-1,word1,word2,dp);
           dp[i][j]=ans;
           return ans;
        }

        int delete1=find(i-1,j,word1,word2,dp);
        if(delete1==-1){
            delete1=Integer.MAX_VALUE;
        }

        int delete2=find(i,j-1,word1,word2,dp);
        if(delete2==-1){
            delete2=Integer.MAX_VALUE;
        }

        int deleteBoth=find(i-1,j-1,word1,word2,dp);

        if(deleteBoth==-1){
            deleteBoth=Integer.MAX_VALUE;
        }

        int min=Math.min(delete1,Math.min(delete2,deleteBoth));

        if(min==Integer.MAX_VALUE){
            min=0;
        }
        else {
            min+=1;
        }

        dp[i][j]=min;

        return min;

    }
}
