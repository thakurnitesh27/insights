package algo.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class PathWithMinimumEffort {

    public static void main(String[] args) {

        int[][] arr = new int[][]{
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
        System.out.println(new PathWithMinimumEffort().minimumEffortPath(arr));
        arr = new int[][]{
                {8, 3, 2, 5, 2, 10, 7, 1, 8, 9},
                {1, 4, 9, 1, 10, 2, 4, 10, 3, 5},
                {4, 10, 10, 3, 6, 1, 3, 9, 8, 8},
                {4, 4, 6, 10, 10, 10, 2, 10, 8, 8},
                {9, 10, 2, 4, 1, 2, 2, 6, 5, 7},
                {2, 9, 2, 6, 1, 4, 7, 6, 10, 9},
                {8, 8, 2, 10, 8, 2, 3, 9, 5, 3},
                {2, 10, 9, 3, 5, 1, 7, 4, 5, 6},
                {2, 3, 9, 2, 5, 10, 2, 7, 1, 8},
                {9, 10, 4, 10, 7, 4, 9, 3, 1, 6}
        };

        System.out.println(new PathWithMinimumEffort().minimumEffortPath(arr));
    }

    public int minimumEffortPath(int[][] heights) {

        int[][] weights = new int[heights.length][heights[0].length];


        int minAns = Integer.MAX_VALUE;

        for (int i = 0; i < weights.length; i++) {
            Arrays.fill(weights[i], Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        weights[0][0]=0;

        while (!queue.isEmpty()) {

            int[] p = queue.poll();
            int i=p[0],j=p[1];
            int val = heights[i][j];
            List<int[]> adjIndexes = getAdjacencyList(i, j, heights.length, heights[0].length);

            for (int[] adjIndex : adjIndexes) {
                int effort = val - heights[adjIndex[0]][adjIndex[1]];
                int maxEffort = Math.max(Math.abs(effort), weights[i][j]);
                if (maxEffort < weights[adjIndex[0]][adjIndex[1]]) {
                    weights[adjIndex[0]][adjIndex[1]] = maxEffort;
                    queue.add(adjIndex);
                }

            }


        }

        return weights[weights.length-1][weights[0].length-1];

    }


    List<int[]> getAdjacencyList(int i, int j, int rowLength, int columnLength) {

        return Arrays.stream(new int[][]
                {
                        {i - 1, j},
                        {i, j - 1},
                        {i + 1, j},
                        {i, j + 1}
                }).filter(a -> a[0] >= 0 && a[0] < rowLength && a[1] >= 0 && a[1] < columnLength)
                .collect(Collectors.toList());
    }


    class Pair {
        int i;
        int j;
        int weight;

        public Pair(int i, int j, int weight) {
            this.i = i;
            this.j = j;
            this.weight = weight;
        }

        public Pair(int[] p, int weight) {
            this.i = p[0];
            this.j = p[1];
            this.weight = weight;
        }
    }


}
