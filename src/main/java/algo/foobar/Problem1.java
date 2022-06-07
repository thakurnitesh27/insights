package algo.foobar;

import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class Problem1 {

    public static void main(String[] args) {

        System.out.println(solution(new int[]{13,5,6,2,5},new int[]{5,2,5,13}));
        System.out.println(solution(new int[]{13,5,6,5},new int[]{13,6,5,2,5}));
    }
    public static int solution(int[] x, int[] y) {
        HashMap<Integer,Integer> countMap=new HashMap<Integer,Integer>();
        for(int i=0;i<x.length;i++){
            countMap.put(x[i],countMap.getOrDefault(x[i],0)+1);
        }
        for(int i=0;i<y.length;i++){
            int num=y[i];
            if(countMap.get(num)!=null){
                int count=countMap.get(num);
                if(count>1)
                    countMap.put(num,count-1);
                else{
                    countMap.remove(num);
                }
            }
            else{
                return num;
            }
        }
        return (int)countMap.keySet().iterator().next();
    }


   static int find(int [] x,int[] y){
        HashMap<Integer,Integer> countMap=new HashMap();

        for(int i=0;i<x.length;i++){
            countMap.put(x[i],countMap.getOrDefault(x[i],0)+1);
        }
        for(int i=0;i<y.length;i++){

            int num=y[i];

            if(countMap.get(num)!=null){
                int count=countMap.get(num);
                if(count>1)
                    countMap.put(num,count-1);
                else{
                    countMap.remove(num);
                }
            }
            else{
                return num;
            }
        }

     //   if(countMap.size()==1){
            return countMap.keySet().iterator().next();
      //  }

      //  return -1;

    }


}
