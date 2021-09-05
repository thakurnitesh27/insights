package sorting;

public class HeapSort {

   // Integer[] arr=new Integer[]{16,15,14,10,11,9,8,7,2,1,12,3,5,13,4,6};
   final Integer[] arr;
    int heapSize;

    public static void main(String[] args) {
        Integer[] arr=new Integer[]{15,16,14,11,10,12,8,7,1,5};
        Integer [] result=sort(arr);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i] +"\t");
        }
    }

    private HeapSort(Integer arr[]){
        this.arr=arr;
        heapSize=arr.length;

    }



    public static Integer[]  sort(final Integer[] arr){
       HeapSort instance= new HeapSort(arr);
       instance.buildMaxHeap();
       for(int i=arr.length-1;i>0;i--){
           instance.swapElementsAtIndex(0,i);
           instance.heapSize--;
           instance.maxHeapify(0);
       }

       return arr;

    }

    private void buildMaxHeap(){
        int startIndex=heapSize/2;
        for(int i=startIndex;i>=0;i--){
            maxHeapify(i);
        }
    }

    private  void maxHeapify(int index)  {
        int largestIndex=index;
        int leftIndex=getLeft(index);
        int rightIndex=getRight(index);
        if(leftIndex<heapSize  && leftIndex!=-1 && arr[leftIndex]>arr[largestIndex]){
            largestIndex=leftIndex;
        }

        if(rightIndex<heapSize && rightIndex!=-1 && arr[rightIndex]>arr[largestIndex]){
            largestIndex=rightIndex;
        }
        if(largestIndex!=index) {
            swapElementsAtIndex(index, largestIndex);
            maxHeapify(largestIndex);
        }

    }


    private  Integer getLeft(int currentIndex) {
        if(currentIndex==0)
            return 1;
        if(currentIndex<arr.length){
            return currentIndex*2+1;
        }
        else return -1;
    }
    private  Integer getRight(int currentIndex) {
        if(currentIndex==0)
            return 2;
        if(currentIndex<arr.length){
            return currentIndex*2+2;
        }
        else return -1;
    }

    private Integer getParent(int currentIndex) throws Exception{
        if(currentIndex==0){
            throw new Exception();
        }
        Double parentIndex=Math.floor(currentIndex/2);
        return parentIndex.intValue();
    }

    private void swapElementsAtIndex(int index1,int index2){
        int temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }
}
