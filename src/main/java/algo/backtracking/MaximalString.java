package algo.backtracking;

//https://www.interviewbit.com/problems/maximal-string/
public class MaximalString {
    public static void main(String[] args) {


       // System.out.println(new MaximalString().solve("254",1));
        System.out.println(new MaximalString().solveNew("129814999".toCharArray(),4,"129814999"));
       // System.out.println(new MaximalString().solve("254",3));
    }

    public String solveNew(char[]chars, int B,String maxFound){

        if(B<=0){
            return maxFound;
        }

        for(int i=0;i<chars.length;i++){
            for(int j=i+1;j<chars.length;j++){

                if(chars[i]<chars[j]){
                    swap(chars,i,j);

                    if(new String(chars).compareTo(maxFound)>0){
                        maxFound=new String(chars);
                    }
                  maxFound=  solveNew(chars,B-1,maxFound);
                    //backtrack
                    swap(chars,j,i);
                }


            }

        }
        return maxFound;
    }

    //wrong solution
    public String solve(String A, int B) {
        int count=0;
        char[] chars=A.toCharArray();

        while (count<B){
           int index= findMaxIndex(chars,count);

           swap(chars,count,index);
           count++;
        }

        return new String(chars);

    }

    private int findMaxIndex(char[]chars,int startIndex){
        int max=Integer.MIN_VALUE;
        int maxIndex=startIndex;

        for(int i=startIndex;i<chars.length;i++){

            if(chars[i]>max){
                max=chars[i];
                maxIndex=i;
            }
        }
        return maxIndex;
    }

    void swap(char[]chars,int i,int j){
        char temp=chars[i];
        chars[i]=chars[j];
        chars[j]=temp;

    }
    void swap(String s,int i,int j){
        char[] chars=s.toCharArray();
        char temp=chars[i];
        chars[i]=chars[j];
        chars[j]=temp;

    }
}
