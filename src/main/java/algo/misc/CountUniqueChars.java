package algo.misc;

import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/
public class CountUniqueChars {

    public static void main(String[] args) {
      //  System.out.println(new CountUniqueChars().uniqueLetterString("ABA"));
       // System.out.println(new CountUniqueChars().uniqueLetterString("ABC"));
        System.out.println(new CountUniqueChars().uniqueStringLee("LEETCODE"));
        System.out.println(new CountUniqueChars().uniqueLetterStringDp("DELQGVWNZKIJJPSXOVWWIZUXCEGWSQLESNSRBMKZARFPAXSVWQEZDENDAHNNIBHGHTFDLPGDLFXMIYRFNLMXHNPIFUAXINXPXLCTTJNLGGMKJIOEWBECNOFQPVCIKIAZMNGHEHFMCPWSMJTMGVSXTOGCGUYKFMNCGLCBRAFJLJVPIVDOLJBURULPGXBVDCEWXXXLTRMSHPKSPFDGNVOCZWDXJUWVNAREDOKTZMIUDKDQWWWSAEUUDBHMWZELOSBIHMAYJEMGZPMDOOGSCKLVHTGMETHUISCLJKDOQEWGVBULEMUXGTRKGXYFDIZTZWMLOFTCANBGUARNWQEQWGMIKMORVQUZANJNRNPMJWYLVHWKDFLDDBBMILAKGFROEQAMEVONUVHOHGPKLBPNYZFPLXNBCIFENCGIMIDCXIIQJWPVVCOCJTSKSHVMQJNLHSQTEZQTTMOXUSKBMUJEJDBJQNXECJGSZUDENJCPTTSREKHPRIISXMWBUGMTOVOTRKQCFSDOTEFPSVQINYLHXYVZTVAMWGPNKIDLOPGAMWSKDXEPLPPTKUHEKBQAWEBMORRZHBLOGIYLTPMUVBPGOOOIEBJEGTKQKOUURHSEJCMWMGHXYIAOGKJXFAMRLGTPNSLERNOHSDFSSFASUJTFHBDMGBQOKZRBRAZEQQVWFRNUNHBGKRFNBETEDJIWCTUBJDPFRRVNZENGRANELPHSDJLKVHWXAXUTMPWHUQPLTLYQAATEFXHZARFAUDLIUDEHEGGNIYICVARQNRJJKQSLXKZZTFPVJMOXADCIGKUXCVMLPFJGVXMMBEKQXFNXNUWOHCSZSEZWZHDCXPGLROYPMUOBDFLQMTTERGSSGVGOURDWDSEXONCKWHDUOVDHDESNINELLCTURJHGCJWVIPNSISHRWTFSFNRAHJAJNNXKKEMESDWGIYIQQRLUUADAXOUEYURQRVZBCSHXXFLYWFHDZKPHAGYOCTYGZNPALAUZSTOU"));
   //116039203
    }
//By Lee
    public int uniqueStringLee(String S){
        int[][] index = new int[26][2];
        for (int i = 0; i < 26; ++i) Arrays.fill(index[i], -1);
        int res = 0, N = S.length(), mod = (int)Math.pow(10, 9) + 7;
        for (int i = 0; i < N; ++i) {
            int c = S.charAt(i) - 'A';
            res = (res + (i - index[c][1]) * (index[c][1] - index[c][0]) % mod) % mod;
            index[c] = new int[] {index[c][1], i};
        }
        for (int c = 0; c < 26; ++c)
            res = (res + (N - index[c][1]) * (index[c][1] - index[c][0]) % mod) % mod;
        return res;
    }
    public int uniqueLetterStringDp(String s){
        int dp[][]=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            dp[i][i]=1;
        }

        for(int length=1;length<=s.length();length++){
            for(int i=0;i<=s.length()-length-1;i++){
                int j=i+length;
                int min=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    if(s.substring(i,k+1).equals(s.substring(k+1,j+1))){
                       min=0;
                        break;
                    }
                    else if(s.substring(i,k+1).contains(s.substring(k+1,j+1))){
                        String temp=s.substring(i,j);
                        temp=temp.replaceAll(s.substring(k+1,j+1),"");
                        min=Math.min(temp.length(),min);
                    }else {
                        int temp = dp[i][k] + dp[k + 1][j];
                        min=Math.min(temp,min);
                    }

                }
                dp[i][j]=min;
            }
        }

        int count=0;
        for(int i=0;i<dp.length;i++){
            for(int j=i;j<dp.length;j++){
                count+=dp[i][j];
            }
        }
        return count;
    }

    public int uniqueLetterString(String s) {

        int size=1;
        int length=s.length();
        int count=length;
        for(size=2;size<=length;size++){
            for(int i=0;i<=length-size;i++){
                int j=i+size;
                String subStr=s.substring(i,j);
                count+=countUniqueChars(subStr);
            }
        }

        return count;
    }

    int countUniqueChars(String s){
        HashMap<Character, Integer> map=new HashMap<>();
        char[] chars=s.toCharArray();
        for(Character c:chars){

            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else{
                map.put(c,1);
            }

        }

        long count=map.entrySet().stream().filter(e->e.getValue()==1).count();
        return (int)count;
    }
}
