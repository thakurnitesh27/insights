package algo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DetonateTheMaximumBombs {
    public static void main(String[] args) {
//        int[][] arr = new int[][]{
//                {2, 1, 3},
//                {6, 1, 4}};
//        System.out.println(new DetonateTheMaximumBombs().maximumDetonation(arr));
//        arr = new int[][]{
//                {1, 1, 5},
//                {10, 10, 5}};
//        System.out.println(new DetonateTheMaximumBombs().maximumDetonation(arr));
//
        int[][] arr = new int[][]{
                {1, 1, 100000},
                {100000, 100000, 1}
        };
       // System.out.println(new DetonateTheMaximumBombs().maximumDetonation(arr));
        arr = new int[][]{
                {56, 80, 2},{55, 9, 10},{32, 75, 2},{87, 89, 1},{61, 94, 3},{43, 82, 9},{17, 100, 6},{50, 6, 7},{
        9, 66, 7},{98, 3, 6},{67, 50, 2},{79, 39, 5},{92, 60, 10},{49, 9, 9},{42, 32, 10}
        };
        System.out.println(new DetonateTheMaximumBombs().maximumDetonation(arr));

        arr = new int[][]{
                {54, 95, 4}, {99, 46, 3}, {29, 21, 3}, {96, 72, 8}, {49, 43, 3}, {11, 20, 3}, {2, 57, 1}, {69, 51, 7}, {97, 1, 10}, {85, 45, 2}, {38, 47, 1}, {83, 75, 3}, {65, 59, 3}, {33, 4, 1}, {32, 10, 2}, {20, 97, 8}, {35, 37, 3}
        };

       // System.out.println(new DetonateTheMaximumBombs().maximumDetonation(arr));

        arr = new int[][]{
                {63, 47, 3},
                {94, 76, 1},
                {38, 53, 5},
                {66, 67, 9},
                {35, 64, 10},
                {43, 46, 1},
                {76, 95, 9},
                {62, 94, 3},
                {42, 67, 7},
                {19, 84, 7},
                {80, 16, 9},
                {7, 81, 4}, {67, 25, 5}, {32, 27, 1}, {2, 32, 10}, {17, 46, 6}, {40, 32, 6}
        };
       // System.out.println(new DetonateTheMaximumBombs().maximumDetonation(arr));

        arr = new int[][]{
                {1, 2, 3},
                {2, 3, 1}, {3, 4, 2}, {4, 5, 3}, {5, 6, 4}
        };

      //  System.out.println(new DetonateTheMaximumBombs().maximumDetonation(arr));


    }
    public int maximumDetonationCopied(int[][] bombs) {

        List<List<Integer>> adj = new ArrayList<>();
        int n = bombs.length;
        boolean[] vis = new boolean[n];
        int max=1;


        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            long x = (long)bombs[i][0],y=(long)bombs[i][1],r=(long)bombs[i][2];

            for(int j=0;j<n;j++){
                int x1 = bombs[j][0],y1=bombs[j][1],r1=bombs[j][2];

                if(i!=j){
                    if((((x-x1)*(x-x1)+(y-y1)*(y-y1))<=r*r))
                        adj.get(i).add(j);
                }
            }
        }


        for(int i=0;i<n;i++){
            int ans = DFS(i,adj,vis);
            Arrays.fill(vis,false);
            max = Math.max(ans,max);
        }

        return max;

    }

    private int DFS(int i,List<List<Integer>> adj,boolean []vis){
        vis[i]=true;
        int ans =1;
        for(int nd : adj.get(i)){
            if(!vis[nd])
                ans+=DFS(nd,adj,vis);
        }

        return ans;
    }

    public int maximumDetonation(int[][] bombs) {

        List<Integer>[] adjacencyList = new List[bombs.length];

        //Arrays.fill(adjacencyList, new ArrayList<>());
        for(int i=0;i<adjacencyList.length;i++){
            adjacencyList[i]=new ArrayList<>();
        }

        for (int i = 0; i < bombs.length; i++) {
            long r2 = (long)((long)bombs[i][2] * (long)bombs[i][2]);
            for (int j = 0; j < bombs.length; j++) {
                if (i != j) {
                    if (findDistance(bombs[i], bombs[j]) <= r2) {
                        adjacencyList[i].add(j);
                    }

                }
            }
        }

        int count = Integer.MIN_VALUE;
        for (int i = 0; i < bombs.length; i++) {
            boolean[] color = new boolean[bombs.length];
            count = Math.max(count, detonateDFS( i, color, adjacencyList));
            if (count == bombs.length) {
                return count;
            }
        }

        return count;

    }

    private int detonateDFS( int index, boolean[] color, List<Integer>[] adjacencyList) {
        int count = 1;
        color[index] = true;
        for (Integer adjIndex : adjacencyList[index]) {

            if (!color[adjIndex]) {
                count += detonateDFS(adjIndex, color, adjacencyList);
            }
        }
        return count;
    }

    private long findDistance(int[] bomb1, int[] bomb2) {
        long x = bomb1[0] - bomb2[0];
        long y = bomb1[1] - bomb2[1];
        long distance = (x * x) + (y * y);
        //  System.out.println("Distance for bomb: " + bomb1[0] + " " + bomb1[1] + "and " + bomb2[0] + " " + bomb2[1] + "=" + distance + " with radius=" + bomb1[2] * bomb1[2]);
        return distance;
    }
}


/*
[[2,1,3],[6,1,4]]
[[1,1,5],[10,10,5]]
[[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]
[[1,1,100000],[100000,100000,1]]
[[63,47,3],[94,76,1],[38,53,5],[66,67,9],[35,64,10],[43,46,1],[76,95,9],[62,94,3],[42,67,7],[19,84,7],[80,16,9],[7,81,4],[67,25,5],[32,27,1],[2,32,10],[17,46,6],[40,32,6]]
[[54,95,4],[99,46,3],[29,21,3],[96,72,8],[49,43,3],[11,20,3],[2,57,1],[69,51,7],[97,1,10],[85,45,2],[38,47,1],[83,75,3],[65,59,3],[33,4,1],[32,10,2],[20,97,8],[35,37,3]]
 */