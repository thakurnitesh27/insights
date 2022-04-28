package algo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
public class ConnectedComponentsInUndirectedGraph {

    public static void main(String[] args) {

        int [][] edges=new int[][]{
                {1,0},{1,2},{4,3}
        };
        //5
        //[[0,1],[1,2],[3,4]] //
        //5
        //[[0,1],[1,2],[2,3],[3,4]]
        //3
        //[[1,0],[2,0]]
        //2
        //[[1,0]]
        //4
        //[[2,3],[1,2],[1,3]]

        System.out.println(new ConnectedComponentsInUndirectedGraph().findConnectedComponents(5,edges));

    }

    public int findConnectedComponents(int n, int[][] edges) {

        int[] colors=new int[n];
        int count=0;
        int nonConnectedVertices=0;
        for(int i=0;i<n;i++){
            if(colors[i]==0){

                if(DFS(i,edges,colors)){
                    count++;
                }
                else{
                    boolean edgeFound=false;
                    for(int[] edge:edges){
                        if(edge[0]==i|| edge[1]==i){
                            edgeFound=true;
                            break;
                        }
                    }
                    if(!edgeFound){
                        //  System.out.println("Found nonConnectVertex: "+i);
                        nonConnectedVertices++;
                    }

                }
            }

        }


        return count+nonConnectedVertices;
    }
    private boolean DFS(int i, int[][] edges,int[] color) {
        color[i]=1;
        ArrayList<int[]> matchingEdges=findEdges(i,edges);
        for(int[] edge:matchingEdges){
            if(color[edge[1]]==0){
                DFS(edge[1],edges,color);
                color[edge[1]]=2;
            }
            else if(color[edge[0]]==0){
                DFS(edge[0],edges,color);
                color[edge[0]]=2;
            }

        }
        color[i]=2;
        return matchingEdges.size()>0;

    }
    private ArrayList<int[]> findEdges(int vertex, int[][]edges){

        ArrayList<int[]> matchingEdges=new ArrayList<>();

        for(int i=0;i<edges.length;i++){
            if(edges[i][0]==vertex || edges[i][1]==vertex){
                matchingEdges.add(edges[i]);
            }
        }
        return matchingEdges;
    }
}
