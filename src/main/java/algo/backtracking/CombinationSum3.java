package algo.backtracking;

import java.util.*;

public class CombinationSum3 {
    public static void main(String[] args) {

        System.out.println(findCombinations(3,9));
        System.out.println(findCombinations(3,15));

    }

    static  List<List<Integer>> findCombinations(int k , int n){
        List<List<Integer>> ans=new ArrayList<>();
        combinations(ans,new ArrayList<>(),k,1,0,n);
        return ans;


    }

  static void combinations(List<List<Integer>> ansList, List<Integer> list,int k,int startIndex, int sum, int target){
        if(k==0 && sum==target){
            ansList.add(new ArrayList<>(list));
            return;
        }
        if(k==0){
            return;
        }

        for(int i=startIndex;i<=9;i++){
           List<Integer> newList= new ArrayList<>(list);
           newList.add(i);
           combinations(ansList,newList,k-1,i+1,sum+i,target);
           newList.remove((Integer) i);

        }

   }

  static List<List<Integer>> findCombinationsOld(int k , int n){


      List<List<Integer>> ans=new ArrayList<>();

      int count=0;
      int sum=0;
      List<Integer> firstSet=new ArrayList<>();
      int num=0;

      while (count<k-1){
          num++;
          sum+=num;
          firstSet.add(num);
          count++;
      }
      int lastNum=n-sum;
      if(lastNum<=num || num>9){
          return ans;
      }

      firstSet.add(lastNum);
      if(lastNum<10){
          ans.add(firstSet);
      }

      for(int i=k-2;i>=0;i--){

          int index=i;
          List<Integer> tempSet=new ArrayList();
          tempSet.addAll(firstSet);
          Set<Integer> uniqueCheck=new HashSet<>();
          for(int j=0;j<tempSet.size()-1;j++){
              if(j!=index){
                  uniqueCheck.add(tempSet.get(j));
              }
          }
          int element1=tempSet.get(index);
          int element2=tempSet.get(tempSet.size()-1);
          while (element1<element2){

              boolean firstElementAdded=false;
              boolean secondElementAdded=false;
              element1=element1+1;
              element2=element2-1;
              if(element1<element2 && element1<=9 && element2<=9 && (firstElementAdded=uniqueCheck.add(element1)) &&
                      (secondElementAdded=uniqueCheck.add(element2))) {

                  tempSet.set(index, element1);
                  tempSet.set(tempSet.size() - 1, element2);

                  if(ans.isEmpty()){
                      firstSet=new ArrayList<>(tempSet);
                  }
                  ans.add(new ArrayList<>(tempSet));
              }
              if(firstElementAdded){
                  uniqueCheck.remove(element1);
              }
              if(secondElementAdded){
                  uniqueCheck.remove(element2);
              }

          }

      }

      return ans;

    }
}
