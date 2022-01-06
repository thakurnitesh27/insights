package sorting;

public class QuickSort {
    final int[] arr;

    private QuickSort(int [] arr) {
        this.arr=arr;
    }

    public static void main(String[] args) {
        int [] arr=new int[]{15,16,14,11,10,12,8,7,1,5};
        int result[]=QuickSort.sort(arr);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+ "\t");
        }
    }

   public static int [] sort(int[] arr) {
       QuickSort quickSort = new QuickSort(arr);
       if (arr.length > 0) {

           quickSort.sortInternal(0,arr.length-1);

       }
       return quickSort.arr;
   }

   private void sortInternal(int startIndex, int endIndex){

        if(startIndex<endIndex){

            int q= partition(startIndex,endIndex);
            sortInternal(startIndex,q);
            sortInternal(q+1,endIndex);
        }

   }

    private int partition(int startIndex, int endIndex) {
        int pivotIndex=findPivotIndex(startIndex,endIndex);

        int smallElementsCount=startIndex;

        int j=endIndex-1;
       // for(int i=startIndex;i<=endIndex;i++){
        while (smallElementsCount<j){

            if(arr[smallElementsCount]>arr[pivotIndex]){
                int temp=arr[smallElementsCount];
                arr[smallElementsCount]=arr[j];
                arr[j]=temp;
                j--;

            }
            else {
                smallElementsCount++;
            }
        }

       int temp=arr[pivotIndex];
        if(temp<arr[smallElementsCount]){
            arr[pivotIndex]=arr[smallElementsCount];
            arr[smallElementsCount]=temp;
        }

        return smallElementsCount;

    }

    private int findPivotIndex(int startIndex,int endIndex){
        return endIndex;
    }


}
