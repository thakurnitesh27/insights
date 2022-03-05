package algo.arrays;

public class ExecutionTime {

    //Thought works problem: Minimum execution time.

    public static void main(String[] args) {

        int []A1=new int[]{23,10,18,43};
        int []A2=new int[]{7};
        int []A3=new int[]{13,42};

        System.out.println(new ExecutionTime().findTimeNew(A1.length,A1,A2.length,A2,A3.length,A3));

    }


    int findTimeNew(int k1,int[]A1, int k2, int[]A2, int k3, int[]A3){

        int arr[]=new int[k1+k2+k3];
        int sum[]=new int[k1+k2+k3];
        int f=0;

        int i=0,j=0,k=0;
        while (f<k1+k2+k3){

            int e1=Integer.MAX_VALUE,e2=Integer.MAX_VALUE,e3=Integer.MAX_VALUE;
            if (i < k1) {

                e1=A1[i];
            }
            if(j<k2){
                e2=A2[j];
            }
            if(k<k3){
                e3=A3[k];
            }

           // int[] res=findMin(e1,i,e2,j,e3,k);
            int min=  Math.min(Math.min(e1,e2),e3);
            int index=min==e1?i++:min==e2?j++:k++;
            arr[f]=min;
            index++;
            if(f>0) {
                sum[f] = sum[f - 1] + arr[f - 1];
            }

            f++;
        }


        int response=0;
        sum[0]=0;

        for(int l=1;l<arr.length;l++){

            response+=sum[l];

        }

        return response;



    }

    int[] findMin(int e1,int i,int e2, int j, int e3, int k){

      int min=  Math.min(Math.min(e1,e2),e3);
      int index=min==e1?i:min==e2?j:k;

      return new int[]{min,index};


    }

    int findTime(int k1,int[]A1, int k2, int[]A2, int k3, int[]A3) {

        int arr[] = new int[k1 + k2 + k3];
        arr[0] = 0;

        if (A1[0] <= A2[0] && A1[0] <= A3[0]) {
            for (int i = 1; i < A1.length; i++) {
                arr[i] = arr[i - 1] + A1[i - 1];
            }
            arr[k1]=arr[k1-1]+A1[k1-1];

            if (A2[0] < A3[0]) {
                add(k2,A2,k3,A3,arr,k1);
            }
            else if(A2[0]>A3[0]){
                add(k3,A3,k2,A2,arr,k1);
            }
            else {
                if(k2<k3){
                    add(k2,A2,k3,A3,arr,k1);
                }else {
                    add(k3,A3,k2,A2,arr,k1);
                }
            }
        }
        if (A2[0] <= A1[0] && A2[0] <= A3[0]) {
            for (int i = 1; i < A2.length; i++) {
                arr[i] = arr[i - 1] + A2[i - 1];
            }
            arr[k2]=arr[k2-1]+A2[k2-1];

            if (A1[0] < A3[0]) {
                add(k1,A1,k3,A3,arr,k2);
            }
            else if(A1[0]>A3[0]){
                add(k3,A3,k1,A1,arr,k2);
            }
            else {
                if(k1<k3){
                    add(k1,A1,k3,A3,arr,k2);
                }else {
                    add(k3,A3,k1,A1,arr,k2);
                }
            }
        }
        if (A3[0] <= A2[0] && A3[0] <= A1[0]) {
            for (int i = 1; i < A3.length; i++) {
                arr[i] = arr[i - 1] + A3[i - 1];
            }
            arr[k3]=arr[k3-1]+A3[k3-1];

            if (A2[0] < A1[0]) {
                add(k2,A2,k1,A1,arr,k3);
            }
            else if(A2[0]>A1[0]){
                add(k1,A1,k2,A2,arr,k3);
            }
            else {
                if(k1<k2){
                    add(k2,A2,k1,A1,arr,k3);
                }else {
                    add(k1,A1,k2,A2,arr,k3);
                }
            }
        }

        int sum=0;

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }

    void add(int k2, int[]A2, int k3, int[]A3, int[]arr,int k1){

        for(int i=1;i<k2;i++){
            arr[k1+i]=arr[k1+i-1]+A2[i-1];
        }
        arr[k1+k2]=arr[k1+k2-1]+A2[k2-1];

        for(int i=1;i<k3;i++){
            arr[k1+k2+i]=arr[k1+k2+i-1]+A3[i-1];
        }
    }
}
