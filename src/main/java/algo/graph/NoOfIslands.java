package algo.graph;
//https://leetcode.com/problems/number-of-islands/
public class NoOfIslands {

    public static void main(String[] args) {
        char [][] grid=new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(findNoOfIslands(grid));

        grid=new char[][]{
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}

        };

        System.out.println(findNoOfIslands(grid));

    }

    static int findNoOfIslands(char[][] grid){

        Character LAND_VALUE='L';
        int count=0;
        for(int i=0;i<grid.length;i++){

            for(int j=0;j<grid[i].length;j++){

                if(grid[i][j]=='1'){

                   count++;
                   traverseDFS(grid,i,j,LAND_VALUE);

                }
            }
        }
        return count;
    }

    private static void traverseDFS(char[][] grid, int i, int j, Character LAND_VALUE) {

        if(i<0 || i>grid.length-1 ||j<0 || j>grid[i].length-1){
            return;
        }

        if(grid[i][j]=='1') {
            grid[i][j] = LAND_VALUE;
            traverseDFS(grid, i - 1, j, LAND_VALUE);
            traverseDFS(grid, i + 1, j, LAND_VALUE);
            traverseDFS(grid, i, j - 1, LAND_VALUE);
            traverseDFS(grid, i, j + 1, LAND_VALUE);

        }

    }


}
