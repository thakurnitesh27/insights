package algo.graph;

public class MaxAreaOfIsland {
    //https://leetcode.com/problems/max-area-of-island/submissions/
    public static void main(String[] args) {

    }
    public int maxAreaOfIsland(int[][] grid) {
        //  int LAND_AREA=2;
        int maxArea=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    int temp=findArea(grid,i,j,0);
                    maxArea=Math.max(maxArea,temp);
                }
            }
        }
        return maxArea;
    }

    int findArea(int[][] grid, int i, int j,int area){
        if(i<0 ||i>grid.length-1||j>grid[i].length-1 || j<0){
            return area;
        }
        if(grid[i][j]==1){
            grid[i][j]=2;
            area++;
            area=findArea(grid,i,j+1,area);
            area=findArea(grid,i,j-1,area);
            area=findArea(grid,i-1,j,area);
            area=findArea(grid,i+1,j,area);
        }

        return area;
    }
}
