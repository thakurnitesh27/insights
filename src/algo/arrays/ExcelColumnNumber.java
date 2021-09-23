package algo.arrays;

public class ExcelColumnNumber {

    public static void main(String[] args) {
       // System.out.println(new ExcelColumnNumber().getColumnNumber(943566));
        System.out.println(new ExcelColumnNumber().getColumnNumber(943566));
    }
/*
For certain number the remainder is 0 although A/26 is not 0. In that case 0 represents Z,-1->Y...
So 65+26 is Z and 65-remainder(65+remainder-1=64) gives number from last when subtracted from 65+26.
 */
   String getColumnNumber(int A) {
       StringBuilder response = new StringBuilder();

       while (A > 0) {
           int remainder = A % 26;
          remainder=65+remainder-1;

          if(remainder<65){
              remainder=65+26-(65-remainder);
              A--;
          }
           A = (A/26);

           response.append((new Character((char) remainder).toString()));
          // A = (A/26);
       }
       return response.reverse().toString();
   }
}
