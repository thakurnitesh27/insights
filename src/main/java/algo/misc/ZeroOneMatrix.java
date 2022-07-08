package algo.misc;
//https://leetcode.com/problems/01-matrix/

import java.util.*;
import java.util.stream.Collectors;

public class ZeroOneMatrix {
    public static void main(String[] args) {

        int[][] arr = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        print(new ZeroOneMatrix().updateMatrix(arr));
        arr = new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 0}
        };

        print(new ZeroOneMatrix().updateMatrix(arr));

        arr = new int[][]{
                {1, 1, 0, 0, 1, 0, 0, 1, 1, 0},
                {1, 0, 0, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 0, 1, 1, 1, 1}
        };
        print(new ZeroOneMatrix().updateMatrix(arr));
    }

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int[][] updateMatrix(int[][] mat) {

        Queue<int[]> queue = new LinkedList<>();
        int dp[][] = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                    ((LinkedList<int[]>) queue).add(new int[]{i, j});
                } else dp[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs(mat, dp, queue);
        return dp;
    }


    void bfs(int[][] mat, int[][] dp, Queue<int[]> queue) {

        while (!queue.isEmpty()) {

            int[] index = ((LinkedList<int[]>) queue).pop();
            int i = index[0];
            int j = index[1];

            if (dp[i][j] == Integer.MAX_VALUE) {
                continue;
            }

            List<int[]> adjacentVertices = getAdjacencyList(i, j, mat.length, mat[0].length);

            for (int[] adjIndex : adjacentVertices) {
                int adjI = adjIndex[0];
                int adjJ = adjIndex[1];
                if (dp[adjI][adjJ] == Integer.MAX_VALUE) {
                    dp[adjI][adjJ] = dp[i][j] + 1;
                    queue.add(new int[]{adjI, adjJ});
                }


            }

        }

    }


    void bfsOld(int[][] mat, int[][] dp) {

        Queue<int[]> queue = new LinkedList<>();
        ((LinkedList<int[]>) queue).add(new int[]{0, 0});

        if (mat[0][0] == 0) {
            dp[0][0] = 0;
        }
        while (!queue.isEmpty()) {

            int[] index = ((LinkedList<int[]>) queue).pop();
            int i = index[0];
            int j = index[1];

            if (mat[i][j] == 0) {
                dp[i][j] = 0;
            }

            List<int[]> adjacentVertices = getAdjacencyList(i, j, mat.length, mat[0].length);

            for (int[] adjIndex : adjacentVertices) {
                int adjI = adjIndex[0];
                int adjJ = adjIndex[1];
                if (dp[adjI][adjJ] == -1) {
                    if (mat[adjI][adjJ] == 0) {
                        dp[adjI][adjJ] = 0;
                        if (dp[i][j] == -1 || dp[i][j] == Integer.MAX_VALUE) {
                            dp[i][j] = 1;
                        }
                        queue.add(new int[]{adjI, adjJ});
                    } else {
                        dp[adjI][adjJ] = Integer.MAX_VALUE;
                        queue.add(new int[]{adjI, adjJ});
                    }
                } else {
                    if (dp[i][j] == Integer.MAX_VALUE || dp[i][j] == -1) {
                        if (dp[adjI][adjJ] != -1 && dp[adjI][adjJ] != Integer.MAX_VALUE) {
                            dp[i][j] = dp[adjI][adjJ] + 1;
                        }

                    } else if (dp[i][j] > dp[adjI][adjJ] + 1 && dp[adjI][adjJ] != Integer.MAX_VALUE) {
                        dp[i][j] = dp[adjI][adjJ] + 1;
                    } else if (dp[adjI][adjJ] > dp[i][j] + 1 && dp[i][j] != Integer.MAX_VALUE) {
                        dp[adjI][adjJ] = dp[i][j] + 1;
                        ((LinkedList<int[]>) queue).add(new int[]{adjI, adjJ});
                    }
                }

            }

        }

    }


    private List<int[]> getAdjacencyList(int i, int j, int rowLength, int columnLength) {
        return Arrays.stream(new int[][]{new int[]{i - 1, j, 0}, new int[]{i + 1, j, 0}, new int[]{i, j - 1, 0}, new int[]{i, j + 1, 0}})
                .filter(val -> val[0] >= 0 && val[0] < rowLength && val[1] >= 0 && val[1] < columnLength).collect(Collectors.toList());

    }
}
