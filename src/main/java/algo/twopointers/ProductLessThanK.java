package algo.twopointers;

public class ProductLessThanK {
    public static void main(String[] args) {
        int []arr=new int[]{10,5,2,6};

        System.out.println( findMaximumCount(arr,100));


    }

  static int findMaximumCount(int []nums, int k) {
      if (k == 0) {
          return 0;
      }

      int count = 0;
      int left = 0;
      int right = 0;
      int prod = 1;
      while (left <= right && right < nums.length) {
          if (nums[right] < k) {
              count++;
              //  right++;

          }
          if (right>0) {
              if (prod < k) {
                  count++;
              } else {
                  prod = prod / nums[left];
//                  if (prod < k) {
//                      count++;
//
//                  }
                  left++;
              }
          }

          //  count++;
          prod = prod * nums[right];
          right++;
      }
      return count;

  }


}
