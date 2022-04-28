public class Test4 {
    public static void main(String[] args) {
        int []arr=new int[]{1,2,3,3,4,5,398};
    }
    int find(int[]arr, int k){
        System.out.println("K is: "+k);
       // Integer[]arr= stockPrices.toArray(new Integer[]{1});
        // Write your code here
        int wl=0,wr=1;
        //int currentProfit=0;
        int count=0;
        while(wr<arr.length){

            if(wr-wl<k){
                if(arr[wr]-arr[wr-1]>0){
                    // wr++;

                    wr++;

                }
                else{
                    System.out.println("Setting wl to: "+wr);
                    wl=wr;
                    //k--;
                    // wr++;
                }
            }
            else if(wr-wl==k){
                System.out.println("Found: wr="+wr+"wl="+wl);
                count++;
                wl++;
                // k--;
                // wr++;
            }
            else{
                wl++;
            }
            // wr++;

        }

        return count;
    }
}
