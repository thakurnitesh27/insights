package tree;

//https://leetcode.com/problems/unique-binary-search-trees/
//https://www.geeksforgeeks.org/total-number-of-possible-binary-search-trees-with-n-keys/

public class UniqueBinarySearchTree {

    public static void main(String[] args) {

        System.out.println(new UniqueBinarySearchTree().find(4));
       // System.out.println(new UniqueBinarySearchTree().find(19));

    }

    private int find(int n) {

        double numerator = 1;
        long denominator = 1;

        int i = 2 * n;
        int j = n;

        while (i > (n + 1)) {
            numerator *= (i--);

            if (numerator > j && j > 1) {
                numerator = numerator / (j--);
            }

        }


        while (j > 1) {
            denominator *= (j--);

        }

        numerator = (double) numerator / denominator;

        long ans = Math.round(numerator);
        return (int) ans;
    }
}
