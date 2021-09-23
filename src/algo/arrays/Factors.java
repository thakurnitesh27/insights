package algo.arrays;

import java.util.ArrayList;

public class Factors {
    public static void main(String[] args) {
        System.out.println(new Factors().findFactors(720927070));
        ///1 2 5 10 19 38 95 190 3794353 7588706 18971765 37943530 72092707 144185414 360463535 720927070
    }

    private ArrayList<Integer> findFactors(int A){

        ArrayList<Integer> response=new ArrayList<>();
        for(int i=1;i<=(A/4)+1;i++){
            if(A%i==0){
                response.add(i);
            }
        }

        int endIndex=response.size()-1;
        int startIndex=0;

        ArrayList<Integer> newData=new ArrayList<>();
        while (startIndex<=endIndex) {
            int newVal = A / response.get(startIndex);
            if (response.get(endIndex) == newVal) {
                break;
            } else {
                newData.add(newVal);
                startIndex++;
                //endIndex--;
            }
        }
         for(int i=newData.size()-1;i>=0;i--){
             response.add(newData.get(i));
         }




        return response;
    }
}
