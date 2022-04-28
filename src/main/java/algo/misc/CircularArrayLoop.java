package algo.misc;

import java.util.HashSet;

public class CircularArrayLoop {
    public static void main(String[] args) {

       // System.out.println(new CircularArrayLoop().circularArrayLoopNewer(new int[]{2,-1,1,2,2}));
        System.out.println(new CircularArrayLoop().circularArrayLoopNewer(new int[]{-2,-3,-9}));
        System.out.println(new CircularArrayLoop().circularArrayLoopNewer(new int[]{-2,1,-1,-2,-2}));
        System.out.println(new CircularArrayLoop().circularArrayLoopNewer(new int[]{-1,2}));
        System.out.println(new CircularArrayLoop().circularArrayLoopNewer(new int[]{1,2,3,4,5}));
        System.out.println(new CircularArrayLoop().circularArrayLoopNewer(new int[]{-1,-2,-3,-4,-5}));
        System.out.println(new CircularArrayLoop().circularArrayLoopNewer(new int[]{1,-2}));
        System.out.println(new CircularArrayLoop().circularArrayLoopNewer(new int[]{3,1,2}));
        System.out.println(new CircularArrayLoop().circularArrayLoopNewer(new int[]{1,1}));
        /*
true
false
false
true
false
false
true
         */
    }

    public boolean circularArrayLoop(int[] arr){

        int length=arr.length;
        boolean loopExists=false;

        int loopCount=0;
        int loopLength=0;

        int wl=0;
        int wr=0;
        int lastIndex=0;
        boolean allPositive=true;

        if(arr[wl]<0){
            allPositive=false;
        }

        if(length<=2){
            return false;
        }

        while (wl<length){

            int nextIndex=lastIndex+wr;

            if(nextIndex>=length){
                nextIndex=nextIndex%length;
                loopCount++;
            }
            if(nextIndex<0){

                nextIndex=length+nextIndex; //(5,-2+1)= 5+(-2)+1=4th Index.
                if(nextIndex<=lastIndex){
                    loopCount++;
                }
            }

            wr=arr[nextIndex];
            lastIndex=nextIndex;


            if(loopCount>0){

                if(lastIndex==wl && loopLength>1){
                    loopExists=true;
                    break;
                }
                if(lastIndex>=wl && loopCount>1 ||(loopLength<=1 && loopCount==1))
                break;
            }
             if(lastIndex>wl && loopCount>1 || (allPositive && wr<0  ||!allPositive && wr>0)){
                wl++;
                lastIndex=0;
                wr=wl;
                loopCount=0;
                loopLength=0;
                if( wl<arr.length && arr[wl]<0){
                    allPositive=false;
                }
                else {
                    allPositive=true;
                }

            }
            else {
                loopLength++;
            }

        }

        return loopExists;

    }

    public  boolean circularArrayLoopNew(int[] arr){

        int i=0;
        int index=0;
        int loopCount=0;
        boolean  allPositive=true;
        HashSet<Integer> set=new HashSet<>();
        int lastIndex=0;

//        if (arr.length <= 2) {
//            return false;
//        }

        if(arr[0]<0){
            allPositive=false;
        }

        while (i<arr.length){


            index+=lastIndex;

              if(index<0){
                  loopCount++;
                index=(arr.length+index);
            }
            if(index>arr.length){
                loopCount++;
            }
            index=index%arr.length;

            if(index==lastIndex && loopCount>0){
                return false;
            }
              int element=arr[index];

              if( loopCount>1  ||(element<0 && allPositive)||(element>0 && !allPositive))
              {
                  i++;
                  set=new HashSet<>();
                  lastIndex=0;
                  loopCount=0;
                  index=i;
              } else
              {
                  if(set.contains(index)){


                      return true;
                  }
                  set.add(index);
                  lastIndex=index;
                  index=element;


                  if(index<0){
                      loopCount++;
                      index=(arr.length+index);
                  }

                  if(index>arr.length){
                      loopCount++;
                  }
                  index=index%arr.length;
              }

        }

        return false;

    }
    //https://leetcode.com/problems/circular-array-loop/discuss/232417/Python-simple-solution-beats-100-with-O(1)-space

    public  boolean circularArrayLoopNewer(int[] arr){

        int index=0;
        int loopLength=0;
        boolean  allPositive=true;
        int lastIndex=0;

        for(int k=0;k<arr.length;k++) {

            loopLength = 0;
            lastIndex = 0;
            index=k;
            allPositive=arr[index]>0?true:false;

            while (true) {



               // index += lastIndex;
                lastIndex=index;
                int num=arr[lastIndex];
                if ((num < 0 && allPositive) || (num > 0 && !allPositive)) {
                    break;
                }

                index = lastIndex+num;

                while (index < 0) {
                    index = (arr.length + index);
                }
                index = index % arr.length;

                if (index == lastIndex) {
                    break;
                }



                loopLength++;

                if(loopLength>arr.length){
                    return true;
                }

            }
        }
        return false;



    }
}
