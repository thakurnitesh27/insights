package algo.twopointers;

public class AllocateBooks {

    public static void main(String[] args) {
//12, 34, 67, 90
       // int [] arr=new int[]{12, 34, 67, 90};
    //    System.out.println(new AllocateBooks().allocate(arr,2));
      // int [] arr=new int[]{5, 17, 100, 11};
      //  System.out.println(new AllocateBooks().allocate(arr,4));
       /* int [] arr=new int[]{ 97, 26, 12, 67, 10, 33, 79, 49, 79, 21, 67, 72, 93, 36, 85, 45, 28, 91,
                94, 57, 1, 53, 8, 44, 68, 90, 24};
        System.out.println(new AllocateBooks().allocate(arr,26));*/
         int [] arr=new int[]{ 73, 58, 30, 72, 44, 78, 23, 9 };
        System.out.println(new AllocateBooks().allocate(arr,5));
    }

    int allocate(int [] arr,int m){
       // Arrays.sort(arr);
        int min=0;
        int max=findSum(arr);
        if(m>arr.length){ //this is to ensure that all students atleast get one book to read.
            return -1;
        }
        return process(arr,m,min,max,0);

    }

    private int max(int[] arr) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }

    private int process(int[] arr, int m, int min, int max,int ans) {
        if(min<=max){ //for min<max case,  73, 58, 30, 72, 44, 78, 23, 9 for 5 students returns 111 instead of 110.
            int mid=(min+(max))/2;

            boolean check=isFeasible(arr,mid,m);

            if(check){
                ans=mid;
              return process(arr,m,min,mid-1,ans);
            }
            else {
                return process(arr,m,mid+1,max,ans);
            }

        }
        return ans;
    }

    private boolean isFeasible(int[] arr, int max,int m){
        int studentsRequired=1;
        int total=0;

        for(int i=0;i<arr.length;i++){

            if(arr[i]>max){ //this check is to ensure that max(sum of minimum pages required to be read by each student, so the max(arr)
                //arr will be read by atleast one student. Incase max is less than max(arr), then it is invalid case.
                return false;
            }
            total+=arr[i];

            if(total>max){
                total=arr[i];
                studentsRequired++;
            }
        }
        if(studentsRequired<=m){
            return true;
        }
        else {
            return false;
        }
    }

    private int findSum(int[] arr) {
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }
}
