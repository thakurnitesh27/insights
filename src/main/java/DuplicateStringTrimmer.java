public class DuplicateStringTrimmer {

    String s="aaabb";

    public static void main(String[] args) {
        System.out.println(trim("aaabb"));
        System.out.println(trim("aabb"));
        System.out.println(trim("abab"));
        System.out.println(trim("abba"));
    }

    static String trim(String s){
        if(s==null || s.isEmpty()){
            return s;
        }
        int i=1;
        boolean foundDuplicate=false;
        while (i<s.length()){
            if(s.charAt(i-1)==s.charAt(i)){
                foundDuplicate=true;
                break;
            }
            i++;
        }
        if(foundDuplicate){
           String s1="" ;
           if(i==1){
               s1=s.substring(i+1);
           }
           else {
               s1=s.substring(0,i-1)+s.substring(i+1);
           }
           return trim(s1);

        }
        return s;
    }
}
