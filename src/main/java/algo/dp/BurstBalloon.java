package algo.dp;

public class BurstBalloon {
    public static void main(String[] args) {
        int[] arr=new int[]{3,1,5,8};
       // int[] arr=new int[]{7,9,8,0,7,1,3,5,5,2,3};
        //int[] arr=new int[]{1,2,3,4,5};
        int []arr1=new int[arr.length+2];
        for(int i=0;i<arr.length;i++){
            arr1[i+1]=arr[i];
        }
        arr1[0]=arr1[arr1.length-1]=1;

        System.out.println(new BurstBalloon().getMaxCoins(arr));
      //  System.out.println(new BurstBalloon().getMaxCoins2(arr1,0,0));

    }


    int getMaxCoins2(int []arr,int count,int maxCount){

        for(int i=1;i<arr.length-1;i++){
            int elementRemoved=arr[i];
            if(elementRemoved!=-1) {
                int leftElement=arr[i-1];
                int j=i-1;
                while (j>=0 && leftElement==-1){
                    leftElement=arr[j];
                    j--;
                }
                int rightElement=arr[i+1];
                j=i+1;
                while (j<arr.length && rightElement==-1){
                    rightElement=arr[j];
                    j++;
                }
                int newCount = leftElement * elementRemoved * rightElement;
                newCount += count;
                arr[i] = -1;

                if(maxCount<newCount) {
                    maxCount = newCount;

                    int newMax = getMaxCoins2(arr, newCount, maxCount);
                    if (newMax > maxCount) {
                        maxCount = newMax;
                    }
                    arr[i] = elementRemoved;
                }
            }
        }

        return maxCount;
    }


    int getMaxCoinsNew(int[] arr){
        int count=0;
        int i=arr.length;
       while (i>0)
       {
            int tmp=Integer.MIN_VALUE;
            int index=0;

            for(int j=0;j<arr.length;j++){

                if(arr[j]!=-1) {

                    int leftVal = (j == 0 ? 1 : arr[j - 1] == -1 ? 1 : arr[j - 1]);
                    int rightVal = (j == arr.length - 1 ? 1 : arr[j + 1] == -1 ? 1 : arr[j + 1]);
                    int val = leftVal * arr[j] * rightVal;
                    if (leftVal == -1 && rightVal == -1) {
                        val = 1;

                    }
                    if (val > tmp) {
                        tmp = val;
                        index = j;
                    }
                }
            }
            count+=tmp;
            arr[index]=-1;
            i--;

        }

        return count;


    }

    int getMaxCoins(int[] arr){

        int length=arr.length;
        int[][]m=new int[arr.length+2][arr.length+2];

        int arr1[]=new int[arr.length+2];
        for(int i=0;i<arr.length;i++){
            arr1[i+1]=arr[i];
        }
        arr1[0]=arr1[arr.length+1]=1;

        for(int l=1;l<=length;l++){

            for(int i=1;i<length-l+2;i++){

                int j=i+l-1;
                int q=m[i][j];
                for(int k=i;k<=j;k++){
                    int muliptly=arr1[i-1]*arr1[k]*(arr1[j+1]);

                    if(i-1<0 && j>arr1.length){
                        muliptly=1;
                    }

                    int tmp=m[i][k-1]+m[k+1][j]+ muliptly;
                    if(tmp>q){
                        q=tmp;
                        m[i][j]=q;
                    }

                }




            }
        }

        return m[1][arr.length];


    }
}
