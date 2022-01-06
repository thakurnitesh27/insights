package algo.arrays;

public class PureWords {

    public static void main(String[] args) {
        String s="let's meet l8r 2nite?";
       int length= process(s);
        System.out.println(length);
    }

    public static  int process(String s) {
        int no = 0;
        if (s == null || s.isEmpty())
            return no;

        String[] words = s.split(" ");
        for (int j = 0; j < words.length; j++) {
            String wordString=words[j];
            for (int i = 0; i < wordString.length(); i++) {
                Character c = wordString.charAt(i);
                if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122) || c == 32) {
                    if(i==0){
                        no++;
                    }

                } else {

                    if(i!=0 && i!=wordString.length()-1){
                        no++;
                    }
                    else {

                    }
                 //  no+= wordString.split(wordString.charAt(i)+"").length;
                }
            }
        }

        return no;
    }

    class Main{

    }
}
