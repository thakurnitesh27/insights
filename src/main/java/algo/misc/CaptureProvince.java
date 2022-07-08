package algo.misc;

import java.util.*;
import java.util.stream.Collectors;

public class CaptureProvince {
    public static void main(String[] args) {

        System.out.println(solve(5,2,1,new int[][]{
                {1,2},
                {2,3}
        },new int[][]{
                {1,3}
        }));

        System.out.println(solve(5,1,2,new int[][]{
                {1,2}
        },new int[][]{
                {1,3},
                {3,2}
        }));

        System.out.println(solve(5,2,0,new int[][]{
                {1,2},
                {2,3},
                {1,3}
        },new int[][]{

        }));
    }

    static int solve(int N, int A, int B, int[][] land, int[][] water){

            int[][] arr=new int[N+1][N+1];
        Queue<int[]> queue=new LinkedList<>();

        for( int i=0;i<land.length;i++){
            int[] landIndex=land[i];
            arr[landIndex[0]][landIndex[1]]=1; //1 means land
            ((LinkedList<int[]>) queue).add(landIndex);
        }
        // ((LinkedList<int[]>) queue).add(land[0]);
        Set<Integer> waterProvinces=new HashSet();
        for(int i=0;i<water.length;i++){
            int[] waterIndex=water[i];
            arr[waterIndex[0]][waterIndex[1]]=3;
            waterProvinces.add(waterIndex[0]);//3 means water
            waterProvinces.add(waterIndex[1]);
        }

        Set<Integer> provinces=new HashSet<>();
        while (!queue.isEmpty()){
            int[] index=  ((LinkedList<int[]>) queue).pop();
            if(!waterProvinces.contains(index[0])){
                provinces.add(index[0]);
            }
               if(!waterProvinces.contains(index[1])){
                provinces.add(index[1]);
            }
            else {
                provinces.add(index[0]);
            }
            // count++;
            int i=index[0];
            int j=index[1];
            List<int[]> adjIndexes=getAdjacencyList(i,j,N,N);

            for(int[] adjIndex:adjIndexes){
                if(arr[adjIndex[0]][adjIndex[1]]==0||arr[adjIndex[0]][adjIndex[1]]>=3){
                    continue;
                }
                if (arr[adjIndex[0]][adjIndex[1]]==1){ //land
                    arr[adjIndex[0]][adjIndex[1]]=5;
                    ((LinkedList<int[]>) queue).add(adjIndex);
                }
                //   if(arr[adjIndex[0]][adjIndex[1]]==3){
                //       break;
                //   }

            }


        }
        return provinces.size();

    }

    static List<int[]> getAdjacencyList(int i, int j, int rowLength, int columnLength) {
        return Arrays.stream(new int[][]{new int[]{i - 1, j, 0}, new int[]{i + 1, j, 0}, new int[]{i, j - 1, 0}, new int[]{i, j + 1, 0}})
                .filter(val -> val[0] >= 1 && val[0] < rowLength && val[1] >= 1 && val[1] < columnLength).collect(Collectors.toList());
    }
}
