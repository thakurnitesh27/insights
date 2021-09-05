package algo;

public class MagicalString {


    public static void main(String[] args) {

       String s="aeiaaioooaauuaeiou";
       int[] countArr=new int[s.length()];
       if(s.charAt(0)=='a')
       {
           countArr[0]=1;
       }
       for(int i=1;i<s.length();i++)
       {
           Character character=s.charAt(i);
           if(character==s.charAt(i-1))
           {
               countArr[i]=countArr[i-1]+1;
           }
           else {
              if( getNextString(s.charAt(i-1))==character)
              {
                  countArr[i]=countArr[i-1]+1;
              }
           }
       }
        System.out.println(countArr[s.length()-1]);

    }
  static   Character getNextString(Character character)
    {

        switch (character)
        {
            case 'a':
                return 'e';
            case 'e':
                return 'i';
            case 'i':
                return 'o';
            case 'o':
                return 'u';
            default:
                return character;
        }
    }
}
