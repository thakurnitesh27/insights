package algo.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class MineSweeper2 {

    public static void main(String[] args) {

    }

//    public char[][] updateBoard(char[][] board, int[] click) {
//
//        Queue<int[]> queue = new LinkedList<>();
//        ((LinkedList<int[]>) queue).add(click);
//
//    }

    void process(char[][] board, Queue<int[]> queue) {

        while (!queue.isEmpty()) {

            int[] coordinates = queue.poll();
            if(board[coordinates[0]][coordinates[1]]=='M'){
                board[coordinates[0]][coordinates[1]]='X';
                return;
            }

           List<int []> adjList= getAdjacentList(coordinates,board.length,board[0].length);

           for(int[] adj: adjList){

               if(board[adj[0]][adj[1]]=='E'){
               }
           }
        }
    }

    private List<int[]> getAdjacentList(int[] coordinates, int iLength, int jLength) {
        int i = coordinates[0];
        int j = coordinates[1];

        List<int[]> list = Arrays.asList(
                new int[]{i - 1, j},
                new int[]{i + 1, j},
                new int[]{i, j - 1},
                new int[]{i, j + 1},
                new int[]{i + 1, j + 1},
                new int[]{i - 1, j - 1}
        );

        return list.stream()
                .filter(num -> num[0] < 0 || num[0] >= iLength || num[1] < 0 || num[1] > jLength)
                .collect(Collectors.toList());
    }
}
