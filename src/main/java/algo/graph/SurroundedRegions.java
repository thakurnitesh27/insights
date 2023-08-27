package algo.graph;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//https://leetcode.com/problems/surrounded-regions/
public class SurroundedRegions {
    public static void main(String[] args) {

        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        board = new char[][]{
                {'O', 'O', 'O', 'O', 'X', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'O'}
        };
        board = new char[][]{
                {'X', 'X', 'X', 'X', 'O', 'X'},
                {'O', 'X', 'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'O', 'X', 'O'},
                {'O', 'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'X'}
        };
        new SurroundedRegions().solveOld(board);
        print(board);

    }

    private static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" \t");
            }
            System.out.println();
        }
    }

    public void solveOld(char[][] board) {

        int[][] color = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == 'O' && color[i][j] == 0) {
                    traverseDFSOld(i, j, color, board);
                }
            }
        }

    }

    private boolean traverseDFSOld(int i, int j, int[][] color, char[][] board) {
        color[i][j] = 1;
        if (i <= 0 || i >= board.length - 1 || j <= 0 || j >= board[0].length - 1) {
            color[i][j] = 3;//false->no region Found
            return false;
        }

        List<int[]> adjIndexes = getAdjacencyList(i, j, board.length, board[0].length);
        boolean regionFound = true;
        boolean inProgressFound=false;
        for (int[] adj : adjIndexes) {
            if (board[adj[0]][adj[1]] == 'O') {
                if (color[adj[0]][adj[1]] == 0) {
                    regionFound = (regionFound && traverseDFSOld(adj[0], adj[1], color, board));
                } else if (color[adj[0]][adj[1]] == 3) {
                    regionFound = false;
                    break;
                }
                else if(color[adj[0]][adj[1]]==1){ //In progress
                   // color[i][j]=0;
                inProgressFound=true;
                }
            }

            if(!regionFound){
                break;
            }

        }
        if(inProgressFound && regionFound){
            color[i][j]=0;
        }else
        if (regionFound) {
            board[i][j] = 'X';
            color[i][j] = 2;// true->regionFound
        } else {
            color[i][j] = 3;//false->no region Found
        }
        return regionFound;

    }

    List<int[]> getAdjacencyList(int i, int j, int rowLength, int columnLength) {
        int[][] arr = new int[][]{
                {i - 1, j},
                {i, j - 1},
                {i + 1, j},
                {i, j + 1}
        };
        return Arrays.stream(arr).
                filter(a -> a[0] >= 0 && a[0] < rowLength && a[1] >= 0 && a[1] < columnLength).
                collect(Collectors.toList());
    }
}
