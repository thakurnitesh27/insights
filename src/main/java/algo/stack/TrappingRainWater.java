package algo.stack;

import java.util.Stack;

public class TrappingRainWater {

    public static void main(String[] args) {
       // int []arr=new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int []arr=new int[]{4,2,3};
        System.out.println(new TrappingRainWater().trappingRain(arr));
    }

    int trappingRain(int[] arr){

        int lo=0;int hi=arr.length-1;
        int left_max=0,right_max=0;
        int result=0;

        while (lo<=hi){

            if(arr[lo]<arr[hi]){

                if(arr[lo]>left_max){
                    left_max=arr[lo];
                }
                else {
                    result+=left_max-arr[lo];
                }
                lo++;
            }
            else if(arr[lo]>=arr[hi]){

                if(arr[hi]>right_max){
                    right_max=arr[hi];
                }
                else {
                    result+=right_max-arr[hi];
                }
                hi--;
            }
        }

        return result;

    }

//    int trappingRain(int[] arr){
//
//        int heigth=0;
//        Stack<Integer> s=new Stack<>();
//        s.push(arr[0]);
//        int index=0;
//       Stack<Integer> minimaIndexes=new Stack<>();
//        int minimaCurveFound=0;
//        for(int i=1;i<arr.length;i++){
//            int currElement=arr[i];
//            int stackItem=s.peek();
//            if(stackItem>currElement){
//                s.push(currElement);
//                minimaCurveFound++;
//                minimaIndex.push(i-1);
//                index=i;
//            }
//            else if(stackItem<currElement){
//                if(minimaCurveFound>0){
//
//                    while (index>minimaIndex){
//                        stackItem=s.pop();
//                        index--;
//                    }
//                    stackItem=s.peek();
//                  heigth+=  (i-minimaIndex-1)*Math.min(stackItem,currElement);
//                }
//               minimaCurveFound= minimaCurveFound>0?minimaCurveFound-1:0;
//                s.push(currElement);
//                index=i;
//            }
//        }
//
//        return heigth;
//    }
}
