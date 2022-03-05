package algo;



import java.util.HashMap;
import java.util.HashSet;

public class VisaTest {

    public static void main(String[] args) {

        System.out.println(new VisaTest().canConstruct("The quick brown fox jumps over the lazy dog","visa"));
    }

    boolean canConstruct(String  text, String note){

        HashMap<String,Integer> set=new HashMap();

        for(int i=0;i<text.length();i++){

          Integer count=  set.get(text.charAt(i));
          if(text.charAt(i)==' '){
              continue;
          }
            if(count!=null){
                set.put(((Character)text.charAt(i)).toString().toLowerCase(),++count);
            }
            else {
                set.put(((Character)text.charAt(i)).toString().toLowerCase(),1);
            }


        }


        for(int i=0;i<note.length();i++){

            Character c=note.charAt(i);
            if(c==' '){
                continue;
            }
            String s=((Character)c).toString().toLowerCase();

            if(!set.containsKey(s)){
                return false;
            }
            else {
               int count= set.get(s);
               if(count>0){
                  --count;
                   if(count<=0){
                       set.remove(s);
                   }
                   else {
                       set.put(s,count);
                   }
               }
               else {
                   return false;
               }
            }
        }

        return true;

    }
}
