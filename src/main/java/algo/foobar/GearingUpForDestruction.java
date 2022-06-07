package algo.foobar;

public class GearingUpForDestruction {

    public static void main(String[] args) {
        print(find(new int[]{4,17,50}));
        print(find(new int[]{4,30,50}));
        print(find(new int[]{4,30}));
    }

    private static void print(int[] ints) {

        System.out.println(ints[0] +" "+ints[1]);
    }


    static int[] find(int [] arr){

        int length=arr.length;

        if(length<2){
            return new int[]{-1,-1};
        }

        int sum=0;
        boolean negative=false;

        for(int i=1;i<arr.length-1;i++){
            if(negative){
                int num= -arr[i];
                sum+=num;
                negative=false;
            }
            else {
                sum+=arr[i];
                negative=true;
            }
        }
        int p0=-arr[0];
        int pN=arr[arr.length-1];
        int ans=-1,den=-1;

        if(length%2==0){ //even
             ans=2*(p0+2*sum+pN);
             den=3;
            if(ans%den==0){
                ans=ans/den;
                den=1;
            }
            if((ans/den)<2)
            {
                return new int[]{-1,-1};
            }

        } else { //odd
             ans=2*(p0+2*sum-pN);
             den=1;
            if((ans/den)<2)
            {
                return new int[]{-1,-1};
            }
        }

        double radius= (double) ans/den;

        for(int i=1;i<arr.length-1;i++){
            int distance=arr[i+1]-arr[i];
            double newRadius=distance-radius;

            if(newRadius<1 || radius<1){
                return new int[]{-1,-1};
            }
            radius=newRadius;
        }

        return new int[]{ans,den};

    }
}
