package algo.binarysearch;

public class BitonicArray {

    /*
    https://www.interviewbit.com/problems/search-in-bitonic-array/

    Logic involved: First find the pivot point(P) from where the element previous to it is smaller to it and
    element next to it is smaller. Now we have 2 subarray [0-P],[P+1,N]. And now find the B in both array using binary search.
    Pivot can also be find using binary search.
     */
    public static void main(String[] args) {

       // int A[]=new int[]{3, 9, 10, 20, 17, 5, 4,2,1};//B=20
        //int A[]=new int[]{5, 6, 7, 8, 9, 10, 3, 2, 1};//B= 30
        int A[]=new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11};
        System.out.println(new BitonicArray().solve(A,12));
    }
   int solve(int[] A, int B){


       int pivotIndex= findPivot(A,0,A.length);
         int index= binarySearch(A,B,0,pivotIndex);
         if(index==-1){
             index=binarySearch(A,B,pivotIndex,A.length);
         }
         return index;
    }

    int findPivot(int A[],int startIndex, int endIndex)
    {
        if(startIndex<=endIndex){
            int midIndex=startIndex+(endIndex-startIndex)/2;
            if(midIndex>0 && A[midIndex-1]<A[midIndex] && midIndex<A.length-1 && A[midIndex]>A[midIndex+1]){
                return midIndex;
            }
            else if(midIndex>0 && A[midIndex-1]<A[midIndex] && midIndex<A.length-1 && A[midIndex]<A[midIndex+1])
            {
                return findPivot(A,midIndex+1,endIndex);
            }
            else if(midIndex>0 && A[midIndex-1]>A[midIndex] && midIndex<A.length-1 && A[midIndex]>A[midIndex+1]){
                return findPivot(A,startIndex,midIndex-1);
            }

        }
        return -1;
    }
   int binarySearch(int[]A,int B,int startIndex,int endIndex){

        if(startIndex<=endIndex){
            int midIndex=startIndex+((endIndex-startIndex)/2);
            if(midIndex<A.length ){

                int midItem=A[midIndex];
                if(midIndex>0 && A[midIndex-1]<A[midIndex]){
                    if(B==midItem){
                        return midIndex;
                    }
                    else if(B<midItem){
                        return binarySearch(A,B,startIndex,midIndex-1);
                    }
                    else if(B>midItem){
                        return binarySearch(A,B,midIndex+1,endIndex);
                    }
                }
                else {
                    if(B==midItem){
                        return midIndex;
                    }
                    else if(B<midItem){
                        return binarySearch(A,B,midIndex+1,endIndex);
                    }
                    else if(B>midItem){
                        return binarySearch(A,B,startIndex,midIndex-1);
                    }
                }
            }
        }
        return -1;
    }
}
