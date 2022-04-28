package algo.misc;
//https://leetcode.com/problems/maximal-rectangle/description/

import java.util.*;

public class MaximalRectangle {

    public static void main(String[] args) {

        char[][]matrix=new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };

        System.out.println(new MaximalRectangle().maximalRectangleNew(matrix));
    }

    public int maximalRectangleNew(char[][] matrix){
        int[][]height=new int[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){

                height[i][j]=matrix[i][j]-'0';
                if(height[i][j]>0 && i>0){
                    height[i][j]+=height[i-1][j];
                }
            }
        }
int max=0;
        for(int i=0;i<height.length;i++){
            int[] arr=height[i];
            Stack<Integer> stack=new Stack<>();

            for(int j=0;j<=arr.length;j++){

                while (!stack.isEmpty() && (j==arr.length ||arr[stack.peek()]>arr[j])){
                   int h= arr[stack.pop()];
                  int w=stack.isEmpty()?j:j-stack.peek()-1;
                  max=Math.max(max,h*w);
                }
                stack.push(j);
            }

        }

        return max;

    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;
        int cLen = matrix[0].length;    // column length
        int rLen = matrix.length;       // row length
        // height array
        int[] h = new int[cLen+1];
        h[cLen]=0;
        int max = 0;


        for (int row=0;row<rLen;row++) {
            Stack<Integer> s = new Stack<Integer>();
            for (int i=0;i<cLen+1;i++) {
                if (i<cLen)
                    if(matrix[row][i]=='1')
                        h[i]+=1;
                    else h[i]=0;

                if (s.isEmpty()||h[s.peek()]<=h[i])
                    s.push(i);
                else {
                    while(!s.isEmpty()&&h[i]<h[s.peek()]){
                        int top = s.pop();
                        int area = h[top]*(s.isEmpty()?i:(i-s.peek()-1));
                        if (area>max)
                            max = area;
                    }
                    s.push(i);
                }
            }
        }
        return max;
    }

    int findMaximumRectangleArea(char[][]matrix){


        List<Integer[]> rowAreas=new ArrayList<>();

        for(int i=0;i<matrix.length;i++){

            int maxArea=0;

            int area=0;
            int k=0;
            int t=0;

            for(int j=0;j<=matrix[i].length;j++)
            {
                if(j<matrix[i].length&&matrix[i][j]=='1'){
                    if(area==0){
                        k=j;
                    }
                   area++;
                }
                else {
                    if(area>0) {
                        t = area - 1;
                        rowAreas.add(new Integer[]{k, k+t});
                    }
                    area=0;
                }
                if(area>=maxArea){
                    maxArea=area;
                }
            }

           // rowAreas[i]=maxArea;
        }

        Collections.sort(rowAreas, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if(o1[0].equals(o2[0])){
                    return o1[1].compareTo(o2[1]);
                }
                return o1[0].compareTo(o2[0]);

            }
        });
int ans=0;
        for(int i=0;i<rowAreas.size();i++){
            int iIndex=rowAreas.get(i)[0];
            int jIndex=rowAreas.get(i)[1];
            int count=0;
           l1: for(int j=i;j<rowAreas.size();j++){

                if(rowAreas.get(j)[0]>=iIndex && rowAreas.get(j)[1]<=jIndex){
                    count++;
                }
                else break l1;

            }
           ans=Math.max((jIndex-iIndex+1)*count,ans);
        }
        return ans;



    }
}
