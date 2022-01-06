package algo.twopointers;

public class ContainerWithMostHeight {
    public static void main(String[] args) {

       // System.out.println(new ContainerWithMostHeight().maxArea2(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(new ContainerWithMostHeight().maxArea2(new int[]{4,3,2,1,4}));

    }

    //naive approach
    int maxArea(int[] arr){
        int area=0;
        for(int i=0;i<arr.length;i++){
            int a=arr[i];

            for(int j=i+1;j<arr.length;j++){
                int b=arr[j];
                int s=Math.min(a,b)*(j-i);
                if(s>area){
                    area=s;
                }
            }
        }

        return area;

    }
    int maxArea2(int[]arr){
        int area=0;

        int i=0,j=arr.length-1;
        while (i<j){

            int temp=Math.min(arr[i],arr[j])*(j-i);
            if(temp>area){
                area=temp;
            }
            if(arr[i]<arr[j]){
                i++;
            }
            else j--;
        }
        return area;
    }
}
