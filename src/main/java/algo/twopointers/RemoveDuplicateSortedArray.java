import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicateSortedArray {
    public static void main(String[] args) {
        System.out.println(new RemoveDuplicateSortedArray().remove(Arrays.asList(1, 2, 2, 3, 3)));
        System.out.println(new RemoveDuplicateSortedArray().remove(Arrays.asList(
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3
        )));
    }
    int remove(List<Integer> a){
        int uniqueIndex=1;
        int currItem=a.get(0);
        for(int i=1;i<a.size();i++){

            if(a.get(i)==currItem){
                a.set(i,-1);
                if(!a.get(uniqueIndex).equals(-1)){
                    uniqueIndex=i;
                }
            }
            else if(currItem!=a.get(i)){
                currItem=a.get(i);
                if(a.get(uniqueIndex).equals(-1)){
                    a.set(uniqueIndex,a.get(i));
                    a.set(i,-1);
                    uniqueIndex++;
                }
            }



        }
        int k=0;
        for(int i=1;i<a.size();i++){
            if(a.get(i)==-1){
                k=i;
                break;
            }
        }
        if(k==0){
            return a.size();
        }
        else {
            return k;
        }

    }
}
