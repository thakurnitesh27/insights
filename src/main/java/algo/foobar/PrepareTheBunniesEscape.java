package algo.foobar;

public class PrepareTheBunniesEscape {
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

        Pair [][]dp=new Pair[map.length][map[0].length];
        dp[map.length-1][map[0].length-1]=new Pair(1,false);
        System.out.println(new PrepareTheBunniesEscape().findMinPath(map,false,0,0,true,dp));
//        map=new int[][]{
////                {0, 0, 0, 0, 0, 0},
////                {1, 1, 1, 1, 1, 0},
////                {0, 0, 0, 0, 0, 0},
////                {0, 1, 1, 1, 1, 1},
////                {0, 1, 1, 1, 1, 1},
////                {0, 0, 0, 0, 0, 0}
////        };
        map=new int[][]{
                {0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0}
        };
        dp=new Pair[map.length][map[0].length];
        dp[map.length-1][map[0].length-1]=new Pair(1,false);
        Pair ans=new PrepareTheBunniesEscape().findMinPath(map,false,0,0,true,dp);
        System.out.println(ans.intVal);

    }

//    static int findMinPath(int [][] arr,boolean wallRemoved, int i,int j, Integer[][]dp){
//
//    }



     Pair findMinPath(int[][] arr,boolean wallRemoved,int i, int j,boolean rightOrientation, Pair[][]dp){

        if(i<0 || i>=arr.length ||j<0 || j>=arr[i].length){
            return new Pair(Integer.MAX_VALUE,wallRemoved);
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        if(arr[i][j]==1){
            if(!wallRemoved){
                wallRemoved=true;
            }else {
               // dp[i][j]=Integer.MAX_VALUE;
                return new Pair(Integer.MAX_VALUE,wallRemoved);
            }
        }

         Pair rightPathStatus=new Pair(Integer.MAX_VALUE,false);
         Pair leftPathStatus=new Pair(Integer.MAX_VALUE,false);
         Pair downPathStatus=new Pair(Integer.MAX_VALUE,false);
       // int downPathCount=Integer.MAX_VALUE;
        if(j>=0 &&j<arr[i].length-1 && rightOrientation)
        rightPathStatus=findMinPath(arr,wallRemoved,i,j+1,rightOrientation,dp);

        if(i<arr.length-1) {

            Pair temp=findMinPath(arr, wallRemoved, i + 1, j, true, dp);
            Pair temp1=findMinPath(arr, wallRemoved, i + 1, j, false, dp);

            if(temp.intVal<temp1.intVal ){
                downPathStatus=temp;
            }else if(temp.intVal>temp1.intVal){
                downPathStatus=temp1;
            }else if(temp.intVal==temp1.intVal){
                downPathStatus=(!temp.booleanVal)?temp:temp1;
            }
        }
        if(j>0 && j<arr[i].length && !rightOrientation)
            leftPathStatus=findMinPath(arr,wallRemoved,i,j-1,rightOrientation,dp);

        Pair ans=adjustValue(leftPathStatus,rightPathStatus,downPathStatus);
        if(ans.intVal==Integer.MAX_VALUE){
           return (dp[i][j]!=null)?dp[i][j]:ans;
        }else {
            if(arr[i][j]==1 && ans.booleanVal==true){
                return new Pair(Integer.MAX_VALUE,true);
            }
            if(arr[i][j]==1){
                ans.booleanVal=true;
            }
            ans.intVal+=1;
            dp[i][j]=ans;
        }
        return ans;

    }

    static Pair adjustValue( Pair l, Pair r, Pair d){

        if(Math.min(Math.min(l.intVal,r.intVal),d.intVal)==Integer.MAX_VALUE){
            return new Pair(Integer.MAX_VALUE, (l.booleanVal || r.booleanVal || d.booleanVal==false?false:true));
        }
        if(l.intVal<=r.intVal && l.intVal<=d.intVal){
            return new Pair(l.intVal,(l.intVal==r.intVal)?(!l.booleanVal?l.booleanVal:!r.booleanVal?r.booleanVal:true):
                    ((l.intVal==d.intVal)?(!l.booleanVal?l.booleanVal:!d.booleanVal?d.booleanVal:true):l.booleanVal));
        }
        if(r.intVal<=l.intVal && r.intVal<=d.intVal){
            return new Pair(r.intVal,(l.intVal==r.intVal)?(!l.booleanVal?l.booleanVal:!r.booleanVal?r.booleanVal:true):
                    ((r.intVal==d.intVal)?(!r.booleanVal?r.booleanVal:!d.booleanVal?d.booleanVal:true):r.booleanVal));
        }

        if(d.intVal<=l.intVal && d.intVal<=r.intVal){
            return new Pair(d.intVal,(d.intVal==l.intVal)?(!l.booleanVal?l.booleanVal:!d.booleanVal?d.booleanVal:true):
                    ((r.intVal==d.intVal)?(!r.booleanVal?r.booleanVal:!d.booleanVal?d.booleanVal:true):d.booleanVal));

        }
        return new Pair(Integer.MAX_VALUE,false);

    }


}class Pair {
    Integer intVal;
    Boolean booleanVal;

    Pair(Integer i,Boolean b){
        this.intVal=i;
        this.booleanVal=b;

    }

    @Override
    public String toString() {
        return
                "intVal=" + intVal +
                ", booleanVal=" + booleanVal;
    }
}

/*
public static int solutionOld(int[][] map) {
        Integer [][]dp=new Integer[map.length][map[0].length];
        dp[map.length-1][map[0].length-1]=1;
        return findMinPath(map,false,0,0,dp);
    }

     static int findMinPath(int[][] arr,boolean wallRemoved,int i, int j, Integer[][]dp)
     {

        if(i>=arr.length || j>=arr[i].length){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        if(arr[i][j]==1){
            if(!wallRemoved){
                wallRemoved=true;
            }else {
                dp[i][j]=Integer.MAX_VALUE;
                return dp[i][j];
            }
        }
        int rightPathCount=Integer.MAX_VALUE;
        int downPathCount=Integer.MAX_VALUE;
        if(j<arr[i].length-1)
        rightPathCount=findMinPath(arr,wallRemoved,i,j+1,dp);
        if(i<arr.length-1)
            downPathCount=findMinPath(arr,wallRemoved,i+1,j,dp);

        int ans=Math.min(rightPathCount,downPathCount);
        if(ans==Integer.MAX_VALUE){
            dp[i][j]=Integer.MAX_VALUE;
        }else {
            ans+=1;
            dp[i][j]=ans;
        }
        return ans;

    }
 */
