package algo.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {

    public static void main(String[] args) {
      //List<Integer> output= new NextPermutation().findNextPermutation(Arrays.asList(new Integer[]{1, 2, 3}));
     /* List<Integer> output= new NextPermutation().findNextPermutation(Arrays.asList(new Integer[]{
              153, 856, 701, 319, 695, 52,50}));*/
      //701 695 52 319

        List<Integer> output= new NextPermutation().findNextPermutation(Arrays.asList(new Integer[]{
                        997, 807, 866, 262, 526, 229, 891, 985, 905, 824, 507
                }));
        //807 866 262 526 229 905 507 824 891 985
     /* List<Integer> output= new NextPermutation().findNextPermutation(Arrays.asList(new Integer[]{
              318, 768, 506, 59, 854, 422
      }));*/

    /*
    * 626 436 819 100 382 173 817 581 220 95 814 660 397 852 15 532 564 715 179 872
    * 236 790 223 379 83 924 454 846 742 730 689 112 110 516 85 149 228 202 988 212 69
     * 602 887 445 327 527 347 906 54 460 517 376 395 494 827 448 919 799 133 879 709 184
     * 812 514 976 700 156 568 453 267 547 8 951 326 652 772 213 714 706 972 318 768 506 422 59 854
     */
      //List<Integer> output= new NextPermutation().findNextPermutation(Arrays.asList(new Integer[]{1}));
      // List<Integer> output= new NextPermutation().findNextPermutation(Arrays.asList(new Integer[]{1,2,395,695,52,51}));
        System.out.println(output);

    }

    List<Integer> findNextPermutation(List<Integer> arr){
        boolean nextFound=false;

       int smallestIndex=arr.size()-1;
        for(int i=arr.size()-1;i>0;i--){

            if( arr.get(i)>arr.get(i-1)){
                int tempValue=arr.get(i-1);
                //arr.set(i,arr.get(i-1));
                smallestIndex=i;
              // smallestIndex= arr.get(smallestIndex)>arr.get(i-1)?smallestIndex:i;
                for(int j=i;j<arr.size();j++){
                    if(arr.get(j)>tempValue && arr.get(j)<arr.get(smallestIndex)){
                        smallestIndex=j;
                    }
                }
                arr.set(i-1,arr.get(smallestIndex));
                arr.set(smallestIndex,tempValue);
//                for(int j=i;j<arr.size()-1;j++){
//                    arr.set(j+1,arr.get(j));
//                }
               // arr.set(arr.size()-1,tempValue);
              Collections.sort(arr.subList(i,arr.size()));
                nextFound=true;
                break;
            }
//            if(arr.get(i)>arr.get(smallestIndex)){
//                smallestIndex=i;
//            }
        }

        if(!nextFound){
             Collections.sort(arr);
        }
        return arr;
    }
}


/*
Your submission failed for the following input
A : [ 873, 855, 693, 461, 634, 102, 207, 58, 60, 972, 50, 20, 406, 90, 494, 684, 572, 841, 253, 734, 937, 803, 482, 147, 987, 914, 997, 807, 866, 262, 526, 229, 891, 985, 905, 824, 507 ]

The expected return value:
873 855 693 461 634 102 207 58 60 972 50 20 406 90 494 684 572 841 253 734 937 803 482 147 987 914 997 807 866 262 526 229 905 507 824 891 985
Your function returned the following:
873 855 693 461 634 102 207 58 60 972 50 20 406 90 494 684 572 841 253 734 937 803 482 147 987 914 997 807 866 262 526 229 985 507 824 891 905
 */
