package algo.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

//https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
public class ShortestPathInGridWithObstacle {
    public static void main(String[] args) {

        int[][] grid = new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 0}};


        System.out.println(new ShortestPathInGridWithObstacle().traverse(grid, 1));
        grid = new int[][]{{0,1,1},{1,1,1},{1,0,0}};
        System.out.println(new ShortestPathInGridWithObstacle().traverse(grid, 1));
        grid = new int[][]{{0}};
        System.out.println(new ShortestPathInGridWithObstacle().traverse(grid, 1));

    }

    public int shortestPath(int[][] grid, int k) {

        return traverse(grid, k);

    }

    int traverse(int[][] grid, int k) {

        int rowLength = grid.length;
        int columnLength = grid[0].length;
        int count = 0;
        Queue<Pair> queue = new LinkedList<>();
        int[][][] c = new int[grid.length][grid[0].length][k + 1];

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++)
                Arrays.fill(c[i][j], -1);
        }
        Pair firstPair = new Pair(0, 0);
        firstPair.k = k;

//        if (grid[0][0] == 1) {
//            c[0][0][k - 1] = 0;
//        } else {
//            c[0][0][k] = 0;
//        }

        for(int i=0;i<k+1;i++){
            c[0][0][i]=0;
        }
        ((LinkedList<Pair>) queue).push(firstPair);

        while (!queue.isEmpty()) {

            Pair p = ((LinkedList<Pair>) queue).pop();
            List<Pair> adjacentPairs = getAdjacencyList(p, rowLength, columnLength);

            if(adjacentPairs.isEmpty() && (p.i == rowLength-1) && p.j==columnLength-1){
                return p.count;
            }

            for (Pair adjPair : adjacentPairs) {
                int eliminationNo = p.k;

                if (adjPair.i == rowLength - 1 && adjPair.j == columnLength - 1) {
                    return p.count + 1;
                }

                if (grid[adjPair.i][adjPair.j] == 1) {
                    eliminationNo = eliminationNo - 1;
                }

                if (eliminationNo < 0) { //Path not possible
                    continue;
                }

                if (c[adjPair.i][adjPair.j][eliminationNo] == -1) { //Not visited

                    c[adjPair.i][adjPair.j][eliminationNo] = p.count + 1;
                    adjPair.count = p.count + 1;
                    adjPair.k = eliminationNo;
                    ((LinkedList<Pair>) queue).add(adjPair);
                } else {
                    if (p.count < c[adjPair.i][adjPair.j][eliminationNo]) {
                        c[adjPair.i][adjPair.j][eliminationNo] = p.count;
                        adjPair.count = p.count;
                        ((LinkedList<Pair>) queue).add(adjPair);
                    }
                }

            }


        }

        return -1;


    }

    List<Pair> getAdjacencyList(Pair pair, int rowLength, int columnLength) {
        Pair p1 = new Pair(pair.i - 1, pair.j);
        Pair p2 = new Pair(pair.i + 1, pair.j);
        Pair p3 = new Pair(pair.i, pair.j - 1);
        Pair p4 = new Pair(pair.i, pair.j + 1);

        List<Pair> pairs = Arrays.stream(new Pair[]{p1, p2, p3, p4})
                .filter(p -> p.i >= 0 && p.i < rowLength && p.j >= 0 && p.j < columnLength).collect(Collectors.toList());
        return pairs;
    }
}

class Pair {
    int i;
    int j;
    int count;
    int k;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
