package algo.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/minimum-height-trees/
public class MinimumHeightTrees {
    public static void main(String[] args) {
        System.out.println(new MinimumHeightTrees().findMinHeightTrees(4, new int[][]{
                {1,0},{1,2},{1,3}
        }));
        System.out.println(new MinimumHeightTrees().findMinHeightTrees(6, new int[][]{
                {3,0},{3,1},{3,2},{3,4},{5,4}
        }));

    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer>[] adjacencyList=new List[n];
        for(int i=0;i<adjacencyList.length;i++){
            adjacencyList[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){

            int[] edge =edges[i];
            adjacencyList[edge[0]].add(edge[1]);
            adjacencyList[edge[1]].add(edge[0]);
        }
        List<Integer> ans=new ArrayList<>();

        if(n==1){
            ans.add(0);
            return ans;
        }
        int[] indegree=new int[n];
        Queue<Integer> leaves=new LinkedList<>();

        for(int i=0;i<n;i++){
            indegree[i]=adjacencyList[i].size();
            if(indegree[i]==1){
                ((LinkedList<Integer>) leaves).add(i);
            }
        }


        int cnt=n;
        while (cnt>2){
            int size=leaves.size();
            cnt-=size;
            for(int i=0;i<size;i++){
               int nodeId= leaves.poll();
               for(int adj:adjacencyList[nodeId]){
                  indegree[adj]--;
                  if(indegree[adj]==1){
                      ((LinkedList<Integer>) leaves).add(adj);
                  }
               }

            }

        }
        ans.addAll(leaves);
        return ans;

    }
    public List<Integer> findMinHeightTreesOld(int n, int[][] edges) {

        int[][]adjacencyMatrix=new int[n][n];

        for(int i=0;i<edges.length;i++){
          int[] edge =edges[i];
          adjacencyMatrix[edge[0]][edge[1]]=1;
          adjacencyMatrix[edge[1]][edge[0]]=1;
        }
        List<Integer> ans=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
           int height=getMinHeightBFS(i,adjacencyMatrix,min);

           if(min==height){
               ans.add(i);
           }
           else {
               if(height<min){
                   ans.clear();
                   min=height;
                   ans.add(i);
               }
           }
        }
        return ans;

    }

    private int getMinHeightBFSNew(int i, List<Integer>[] adjacencyList,int min) {
        int[] color=new int[adjacencyList.length];
        Queue<int[]> queue=new LinkedList<>();
        color[i]=1;
        queue.add(new int[]{i,0});
        int maxHeight=0;
        while (!queue.isEmpty()){
            int [] data=queue.poll();
            int nodeId=data[0];
            int height=data[1];
            maxHeight=Integer.max(maxHeight,height);
            if(maxHeight>min){
                queue.clear();
                return Integer.MAX_VALUE;
            }
            //for(int edge:adjacencyMatrix[nodeId]){
            List<Integer> edges=adjacencyList[nodeId];
            for(int k=0;k<edges.size();k++){
                 int edge=edges.get(k);
                if(color[edge]==0){
                    ((LinkedList<int[]>) queue).add(new int[]{edge,height+1});
                    color[edge]=1;
                }
            }

        }
        return maxHeight;
    }

    private int getMinHeightBFS(int i, int[][] adjacencyMatrix,int min) {
        int[] color=new int[adjacencyMatrix.length];
        Queue<int[]> queue=new LinkedList<>();
        color[i]=1;
        queue.add(new int[]{i,0});
        int maxHeight=0;
        while (!queue.isEmpty()){
            int [] data=queue.poll();
            int nodeId=data[0];
            int height=data[1];
            maxHeight=Integer.max(maxHeight,height);
            if(maxHeight>min){
                queue.clear();
                return Integer.MAX_VALUE;
            }
            //for(int edge:adjacencyMatrix[nodeId]){
            int[] edges=adjacencyMatrix[nodeId];
            for(int k=0;k<edges.length;k++){
               // int edge=edges[k];
                if(edges[k]==1 && color[k]==0){
                    ((LinkedList<int[]>) queue).add(new int[]{k,height+1});
                    color[k]=1;
                }
            }

        }
        return maxHeight;
    }

}

