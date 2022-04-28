package algo.stack;

import java.util.Stack;

public class SumOfSubarrayRanges {

    public static void main(String[] args) {
      //  System.out.println(new SumOfSubarrayRanges().subArrayRanges(new int[]{1,2,3}));
        System.out.println(new SumOfSubarrayRanges().subArrayRanges(new int[]{4,3,2,1}));
    }

    public long subArrayRanges(int[] A) {
        int n = A.length, j, k;
        long res = 0;

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && A[s.peek()] > (i == n ? Integer.MIN_VALUE : A[i])) {
                j = s.pop();
                k = s.isEmpty() ? -1 : s.peek();
                res -= (long)A[j] * (i - j) * (j - k);

            }
            s.push(i);
        }

        s.clear();
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && A[s.peek()] < (i == n ? Integer.MAX_VALUE : A[i])) {
                j = s.pop();
                k = s.isEmpty() ? -1 : s.peek();
                res += (long)A[j] * (i - j) * (j - k);

            }
            s.push(i);
        }
        return res;
    }
}
