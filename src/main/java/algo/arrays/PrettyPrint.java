package algo.arrays;

public class PrettyPrint {
    public static void main(String[] args) {

        print(new PrettyPrint().generate(1));
    }

   int[][] generate(int A){

        int[][] response=new int[2*A-1][2*A-1];
        int num=A;
        int start=0,end=response.length-1,top=0,bottom=response.length-1;
        int state=0;
        while (num>0){

            switch (state){
                case 0:{

                    for(int k=start;k<=end;k++) {
                            response[top][k] = num;
                    }

                        top++;
                        state=1;
                        break;


                    }

                case 1:{
                    for(int i=top;i<=bottom;i++){
                        response[i][end]=num;
                    }
                    end--;
                    state=2;
                    break;
                }
                case 2:{
                    for(int i=end;i>=start;i--){
                        response[bottom][i]=num;
                    }
                    bottom--;
                    state=3;
                    break;
                }
                case 3:{
                    for(int i=bottom;i>=top;i--){
                        response[i][start]=num;
                    }
                    start++;
                    num--;
                    state=0;
                    break;
                }

            }

        }

        return response;

    }
   static void print(int[][]a){

        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.print(a[i][j] +"\t");
            }
            System.out.println();
        }
    }
}
