package algo.arrays;

public class TotalMovesForBishop {
    public static void main(String[] args) {
        System.out.println(new TotalMovesForBishop().totalMoves(4,4));
    }

   int totalMoves(int pi,int pj){
        int moves=0;

        for(int i=pi+1,j=pj+1;i>0 && j>0&&i<8&&j<8;i++,j++){
            moves++;
        }
       for(int i=pi-1,j=pj+1;i>0 && j>0&&i<8&&j<8;i--,j++){
           moves++;
       }
       for(int i=pi+1,j=pj-1;i>0 && j>0&&i<8&&j<8;i++,j--){
           moves++;
       }
       for(int i=pi-1,j=pj-1;i>=0 && j>=0&&i<8&&j<8;i--,j--){
           moves++;
       }

       return moves;

    }
}
