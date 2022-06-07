package algo.foobar;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class PrepareTheBunniesEscapeNew {

    public static void main(String[] args) {
        //        int [][]map=new int[][]{
//                {0,1,1,0},
//                {0,0,0,1},
//                {1,1,0,0},
//                {1,1,1,0}
//        };
        int [][]map=new int[][]{
                {0,1,1,0},
                {0,0,0,1},
                {1,1,0,0},
                {1,1,1,0}
        };

        System.out.println(solution(map));
        map=new int[][]{
                {0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0}
        };
        System.out.println(solution(map));
        map=new int[][]{
                {0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0}
        };
        System.out.println(solution(map));
        map=new int[][]{
                {0, 0, 0, 0, 0, 0, 1},
                {0, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 0, 0, 1, 0},
                {0, 1, 1, 0, 1, 1, 0},
                {0, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 0}
        };
        System.out.println(solution(map));

    }

   // static int num_rows;
   // static int num_column;
    public static int solution(int[][] map){
        int num_rows=map.length;
        int num_column=map[0].length;

        int[][]dp=new int[map.length][map[0].length];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        Queue<DataHolder> queue=new LinkedList<>();
        queue.add(new DataHolder(new Pair(0,0), 0, 0));
        dp[0][0]=0;

        int answer=Integer.MAX_VALUE;

        while (!queue.isEmpty()){

          DataHolder cell=  ((LinkedList<DataHolder>) queue).pop();

          if(cell.pair.row==map.length-1 && cell.pair.column==map[0].length-1){
               answer=Math.min(cell.count+1,answer);
          }
          List<Pair> neighbours=getNeighbours(cell.pair,num_rows,num_column);
          for(Pair p:neighbours){

              if(dp[p.row][p.column]==-1) {//Not visited
                  if(map[p.row][p.column]==1 && cell.oneTraversed==1){
                      continue;
                  }
                  int oneTraversedNewValue=0;
                  if(map[p.row][p.column]==1){
                      oneTraversedNewValue=1;
                  }
                  else {
                      oneTraversedNewValue=cell.oneTraversed;
                  }
                  dp[p.row][p.column]=oneTraversedNewValue;
                  ((LinkedList<DataHolder>) queue).add(new DataHolder(p,cell.count+1,oneTraversedNewValue));
              }
              else if(dp[p.row][p.column]!=2){

                  if(dp[p.row][p.column]!=cell.oneTraversed){
                      int oneTraversedNewValue=cell.oneTraversed;
                      if(map[p.row][p.column]==1){
                          oneTraversedNewValue=1;
                      }
                      dp[p.row][p.column]=2;
                      ((LinkedList<DataHolder>) queue).add(new DataHolder(p,cell.count+1,oneTraversedNewValue));
                  }
              }
          }

        }

        return answer;

    }

    public static boolean isValid(Pair p,int num_rows,int num_column){
        if(p.row>=0 && p.row<num_rows && p.column>=0 &&p.column<num_column){
            return true;
        }
        return false;
    }
    public static List<Pair> getNeighbours(Pair pair,int num_rows,int num_columns){

       Pair up=new Pair(pair.row-1,pair.column);
       Pair down=new Pair(pair.row+1,pair.column);
       Pair left=new Pair(pair.row,pair.column-1);
       Pair right=new Pair(pair.row,pair.column+1);
       return Arrays.asList(up,down,left,right).stream().filter(p->isValid(p,num_rows,num_columns)).collect(Collectors.toList());

    }

    static class Pair{
        final int row;
        final int column;

        Pair(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    static class DataHolder{
       final Pair pair;
        final int count;
       final int oneTraversed;

        DataHolder(Pair pair, int count, int oneTraversed) {
            this.pair = pair;
            this.count = count;
            this.oneTraversed = oneTraversed;
        }
    }

}


