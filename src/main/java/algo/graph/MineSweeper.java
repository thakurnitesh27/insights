package algo.graph;

import java.util.*;
import java.util.stream.Collectors;

public class MineSweeper {
    public static void main(String[] args) {

        char[][] board = new char[][]{
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        };
       print(new MineSweeper().updateBoard(board, new int[]{3, 0}));

    }

    private static void print(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public char[][] updateBoard(char[][] board, int[] click) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);

        process(board, queue);

        return board;

    }

    void process(char[][] board, Queue<int[]> queue) {

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int i = position[0];
            int j = position[1];


            if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {

                if (board[i][j] == 'E') {

                    List<int[]> adjList = getAdjacencyList(i, j, board.length, board[0].length);
                    boolean unrevealed = false;

                    List<int[]> toBeAdded=new ArrayList<>();
                    int count=0;
                    for (int[] adj : adjList) {
                        char val = board[adj[0]][adj[1]];
                        switch (val) {
                            case 'E': {
                               // queue.add(adj);
                                toBeAdded.add(adj);
                                break;
                            }
                            case 'X': {
                                // return;
                            }
                            case 'M': {
                                unrevealed = true;
                                //board[i][j] = 1;
                                count++;
                               // queue.add(adj);
                                break;
                            }

                        }
                    }

                    if (!unrevealed) {
                        board[i][j] = 'B';
                        queue.addAll(toBeAdded);
                    }
                    else {
                        board[i][j]= (char) (48+count);
                    }

                } else if (board[i][j] == 'M') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    List<int[]> getAdjacencyList(int i, int j, int rowLength, int columnLength) {
        return Arrays.stream(new int[][]{new int[]{i - 1, j}, new int[]{i + 1, j}, new int[]{i, j - 1}, new int[]{i, j + 1},
                new int[]{i - 1, j - 1}, new int[]{i + 1, j + 1},new int[]{i-1,j+1},new  int[]{i+1,j-1}}).
                filter(cell -> cell[0] >= 0 && cell[0] < rowLength && cell[1] >= 0 && cell[1] < columnLength).
                collect(Collectors.toList());
    }
}
