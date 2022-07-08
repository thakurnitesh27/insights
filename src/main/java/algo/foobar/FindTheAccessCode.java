package algo.foobar;



import java.util.HashSet;
import java.util.Set;

public class FindTheAccessCode {

    int n=999999;
    public static void main(String[] args) {

        int [] arr=new int[]{1,2,3,4,5,6};
        System.out.println(solution(arr));
         arr=new int[]{1,1,1};
        System.out.println(solution(arr));
        arr=new int[]{1,1};
        System.out.println(solution(arr));
        arr=new int[]{1,2,1,3};
        System.out.println(solution(arr));
        arr=new int[]{1,1,5,1};
        System.out.println(solution(arr));
        arr=new int[]{1,2,4,1};
        System.out.println(solution(arr));
         arr=new int[]{1,3,2,5,6,4};
        System.out.println(solution(arr));


    }

    public static int solution(int[] arr){

        int dp[]=new int[arr.length];

        int ans=0;

        for(int i=0;i<arr.length;i++){

            for(int j=0;j<i;j++){
                if(arr[i]%arr[j]==0){
                    dp[i]+=1;
                    if(dp[j]!=0)
                    ans+=dp[j];
                }

            }
        }

        return ans;
    }

    public static int solutionOld(int[] arr){
        Set<Triplet> set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(i!=j && arr[j]%arr[i]==0){
                  set.add(new Triplet(arr[i],i,arr[j],j));
                }
            }
        }

        int count=0;
        Set<Triplet> tripletSet=new HashSet<>();
        for(Triplet triplet:set){
            for(int i=triplet.index2+1;i<arr.length;i++){
                if(i!=triplet.index1 &&i!=triplet.index2 ){
                   if(arr[i]%arr[triplet.index2]==0){
                       triplet.index3=i;
                       triplet.num3=arr[i];
                       if(tripletSet.add(triplet)){
                           count++;
                       }

                   }
                }
            }
        }
        return count;

    }

    static class Triplet {
        Integer num1;
        Integer index1;
        Integer num2;
        Integer index2;
        Integer num3;
        Integer index3;

         Triplet(Integer num1,Integer index1,Integer num2, Integer index2){
            this.num1=num1;
            this.num2=num2;
            this.index1=index1;
            this.index2=index2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Triplet triplet = (Triplet) o;

            if(this.index3==null && triplet.index3==null) {
                if ((index1.equals(triplet.index1) && index2.equals(triplet.index2)) || ((index1.equals(triplet.index2) && index2.equals(triplet.index1)))) {
                    return true;
                }
                return false;
            }else {
                if ((index1.equals(triplet.index1) && index2.equals(triplet.index2) && index3.equals(triplet.index3)) ||
                        (index1.equals(triplet.index1) && index2.equals(triplet.index3) && index3.equals(triplet.index2)) ||
                                (index1.equals(triplet.index2) && index2.equals(triplet.index3) && index3.equals(triplet.index1)) ||
                                        (index1.equals(triplet.index2) && index2.equals(triplet.index1) && index3.equals(triplet.index3)) ||
                                                (index1.equals(triplet.index3) && index2.equals(triplet.index2) && index3.equals(triplet.index1))||
                                                        (index1.equals(triplet.index3) && index2.equals(triplet.index1) && index3.equals(triplet.index2)))
                {
                     return true;
                }

                   return false;
                }


//            if (!num1.equals(triplet.num1)) return false;
//            if (!index1.equals(triplet.index1)) return false;
//            if (!num2.equals(triplet.num2)) return false;
//            if (!index2.equals(triplet.index2)) return false;
//            if (num3 != null ? !num3.equals(triplet.num3) : triplet.num3 != null) return false;
//            return index3 != null ? index3.equals(triplet.index3) : triplet.index3 == null;
        }

        @Override
        public int hashCode() {
            int result =0;
            result =  result + index1.hashCode();
           // result =  result + num2.hashCode();
            result = result + index2.hashCode();
           // result = result + (num3 != null ? num3.hashCode() : 0);
            result =  result + (index3 != null ? index3.hashCode() : 0);
            return result;
        }
    }
}
