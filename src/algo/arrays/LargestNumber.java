package algo.arrays;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

    public static void main(String[] args) {

       // Integer arr[]=new Integer[]{3, 30, 34, 5, 9};
      // Integer arr[]=new Integer[]{12,121};
        //Integer arr[]=new Integer[]{472, 663, 964, 722, 485, 852, 635, 4, 368, 676, 319, 412};
        Integer arr[]=new Integer[]{0,0,0,0};
       // System.out.println(new LargestNumber().findLargestNumNew(Arrays.asList(arr)));
        System.out.println(new LargestNumber().findLargestNumUsingHeap(Arrays.asList(arr)));
    }

    /*
    Logic involved:

     */

      String  findLargestNumNew(List<Integer> arr){
        int radix=0;
        ValueHolder [] arrStr=new ValueHolder[arr.size()];
        boolean areAllZeroes=true;
      //  StringBuilder dummyStr=new StringBuilder();
          for(int i=0;i<arr.size();i++){
              if(!arr.get(i).equals(0))
              {
                  areAllZeroes=false;
              }
//              if(arr.get(i).toString().length()>radix)
//              {
//                  radix=arr.get(i).toString().length();
//              }
          }
          if(areAllZeroes){
              return "0";
          }
//       String dummyStr= new String(new char[radix]).replace("\0", "0");
//
//        for(int i=0;i<arr.size();i++){
//            int val=arr.get(i);
//           String radixedValue=val+ String.valueOf(dummyStr.toCharArray(),0,(dummyStr.length()-String.valueOf(val).length()));
//           arrStr[i]=new ValueHolder(radixedValue,val);
//        }
//          Arrays.sort(arrStr, new Comparator<ValueHolder>() {
//              @Override
//              public int compare(ValueHolder o1, ValueHolder o2) {
//                  if(Long.parseLong(o1.radixValue)>Long.parseLong(o2.radixValue)){
//                      return 1;
//                  }
//                  else if(Long.parseLong(o1.radixValue)==Long.parseLong(o2.radixValue)){
//                     String val1= String.valueOf(o1.originalValue)+String.valueOf(o2.originalValue);
//                     String val2= String.valueOf(o2.originalValue)+String.valueOf(o1.originalValue);
//                     if(Integer.parseInt(val1)>Integer.parseInt(val2)){
//                         return 1;
//                     }else return -1;
//                  }
//                  else return -1;
//              }
//          });
          arr.sort( new Comparator<Integer>() {
              @Override
              public int compare(Integer o1, Integer o2) {
                     String val1= String.valueOf(o1)+String.valueOf(o2);
                      String val2= String.valueOf(o2)+String.valueOf(o1);
                      if(Long.parseLong(val1)> Long.parseLong(val2)){
                          return 1;
                      }else return -1;


              }
          });
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=arr.size()-1;i>=0;i--){
            stringBuilder.append(arr.get(i));
        }

        return stringBuilder.toString();
    }
    class ValueHolder{
        String radixValue;
        Integer originalValue;

        public ValueHolder(String radixValue, Integer originalValue) {
            this.radixValue = radixValue;
            this.originalValue = originalValue;
        }
    }

    String findLargestNum(int arr[]) {
        StringBuilder data = new StringBuilder();
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            int tmpLen = String.valueOf(arr[i]).length();
            if (tmpLen > length) {
                length = tmpLen;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            String valAsString = String.valueOf(arr[i]);
            int diff = length - valAsString.length();
            if (diff > 0) {
                String modifiedVal = valAsString;
                int j = 0;
                while (j <= i) {
                    modifiedVal += valAsString.substring(length - 1);
                    j++;
                }
                modifiedVal += diff;


            }
        }

        return "";
    }


    String findLargestNumUsingHeap(List<Integer> arr) {

        boolean areAllZeroes=true;
        for(int i=0;i<arr.size();i++){
            if(!arr.get(i).equals(0))
            {
                areAllZeroes=false;
            }
        }
        if(areAllZeroes){
            return "0";
        }

       heapSort(arr);
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=arr.size()-1;i>=0;i--){
            stringBuilder.append(arr.get(i));
        }

        return stringBuilder.toString();

    }

    private void heapSort(List<Integer> arr){
          buildMaxHeap(arr);
          for(int i=arr.size()-1;i>0;i--){
              swapValues(arr,0,i);
              maxHeapify(arr,0);
          }
    }

    private void buildMaxHeap(List<Integer> arr){

          for(int i = new Double(Math.ceil(arr.size()/2.0)).intValue(); i>=0; i--){
              maxHeapify(arr,i);
          }
    }

    private void maxHeapify(List<Integer> arr, int index) {

        int largest = index;
        int leftIndex = getLeftIndex( index);
        int rightIndex = getRightIndex( index);
        if(leftIndex<arr.size() ){

           String val1= arr.get(index).toString()+arr.get(leftIndex).toString();
           String val2= arr.get(leftIndex).toString()+arr.get(index).toString();
           if(Long.parseLong(val1)<Long.parseLong(val2)) {

               largest = leftIndex;
           }
        }
        if(rightIndex<arr.size()){
            String val1= arr.get(largest).toString()+arr.get(rightIndex).toString();
            String val2= arr.get(rightIndex).toString()+arr.get(largest).toString();
            if(Long.parseLong(val1)<Long.parseLong(val2)){

                largest=rightIndex;
            }

        }
        if(largest!=index){
            swapValues(arr,index,largest);
            maxHeapify(arr,largest);
        }



    }
    private void swapValues(List<Integer> arr,int index1,int index2){
        Integer tempValue=  arr.get(index1);
        arr.set(index1,arr.get(index2));
        arr.set(index2,tempValue);
    }


    private int getLeftIndex( int currentIndex) {
        return currentIndex * 2 + 1;
    }

    private int getRightIndex( int currentIndex) {
        return currentIndex * 2 + 2;
    }
}
