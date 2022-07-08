package algo.graph;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/shortest-path-to-get-food/
public class ShortestPathToGetFood {

    public static void main(String[] args) {

        char[][] arr = new char[][]{
                {'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', '*', 'O', 'O', 'O', 'X'},
                {'X', 'O', 'O', '#', 'O', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X'}
        };

        //System.out.println(new ShortestPathToGetFood().getFood(arr));

        arr = new char[][]{
                {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', '*', 'O', 'X', 'O', '#', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'O', 'O', '#', 'O', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}

        };

        arr = new char[][]{
                {'O', 'O', '*', 'O'},
                {'#', 'O', 'O', 'O'},
                {'O', 'O', 'X', 'O'},
                {'O', 'O', 'O', 'O'}

        };
        System.out.println(new ShortestPathToGetFood().getFood(arr));

    }


    public int getFood(char[][] grid) {
        int startI = 0, startJ = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '*') {
                    startI = i;
                    startJ = j;
                    break;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        ((LinkedList<int[]>) queue).push(new int[]{startI, startJ, 0});
        // int count=0;
        int rowLength = grid.length;
        int columnLength = grid[0].length;

        int color[][] = new int[grid.length][grid[0].length];
        color[startI][startJ] = 1;
        int minVal = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] indexes = ((LinkedList<int[]>) queue).pop();
            List<int[]> adjIndexes = getAdjacencyList(indexes[0], indexes[1], rowLength, columnLength);
            int count = color[indexes[0]][indexes[1]];

            for (int[] adjIndex : adjIndexes) {

                if (grid[adjIndex[0]][adjIndex[1]] == '#') {
                   return count;

                }
                if (grid[adjIndex[0]][adjIndex[1]] == 'O' && color[adjIndex[0]][adjIndex[1]] == 0) {
                    color[adjIndex[0]][adjIndex[1]] = count+1;
                    adjIndex[2] = count + 1;
                    ((LinkedList<int[]>) queue).add(adjIndex);
                } else if (count+1 < color[adjIndex[0]][adjIndex[1]]) {
                    adjIndex[2] = count + 1;
                    color[adjIndex[0]][adjIndex[1]]=count+1;
                    ((LinkedList<int[]>) queue).add(adjIndex);
                }
            }

        }

        return -1;

    }

    List<int[]> getAdjacencyList(int i, int j, int rowLength, int columnLength) {
        return Arrays.stream(new int[][]{new int[]{i - 1, j, 0}, new int[]{i + 1, j, 0}, new int[]{i, j - 1, 0}, new int[]{i, j + 1, 0}})
                .filter(val -> val[0] >= 0 && val[0] < rowLength && val[1] >= 0 && val[1] < columnLength).collect(Collectors.toList());
    }
}
