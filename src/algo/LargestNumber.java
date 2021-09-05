package algo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class LargestNumber {

    public static void main(String[] args) {


        int[] arr = new int[]{3, 30, 34, 5, 9};

//        String number=new String();
//        int maxLength=1;
//        int index=0;
//        while (index<maxLength) {
//            int maxAtCurrentIndex=0;
//            int maxIndex=0;
//            for (int i = 0; i < arr.length; i++) {
//                if(arr[i]==-1)
//                    continue;
//                String s = arr[i] + "";
//                if (index == 0) {
//                    if (maxLength < s.length())
//                        maxLength = s.length();
//                }
//
//                int tmpIndex=index;
//
//
//                if(temp>maxAtCurrentIndex)
//                {
//                    maxAtCurrentIndex=temp;
//                    maxIndex=i;
//                }
//
//
//            }
//            number+=((char)maxAtCurrentIndex+"");
//            arr[maxIndex]=-1;
//           index++;
//        }
//
//        System.out.println(number);
//    }


        int maxLength=0;
        String []s=new String[arr.length];

        for(int i=0;i<arr.length;i++)
        {
            s[i]=arr[i]+"";
            if(maxLength<s[i].length())
                maxLength=s[i].length();
        }

        for(int i=0;i<s.length;i++)
        {
            String tmpStr=s[i];
            int tmpStrLength=tmpStr.length();
            String tmpString=new String(s[i]);
            if(tmpStr.length()<maxLength)
            {
                for(int j=0;j<maxLength-tmpStrLength;j++)
                {
                    tmpString+="0";
                }
               // tmpString+=s[i];
                s[i]=tmpString;

            }
        }

        int currentIndex=0;
        Arrays.sort(s);
        String num="";
       int startPoint=s.length-1;
        int noProcessed=0;
        while (noProcessed<s.length) {
            int max=0;
            for (int i =startPoint; i >= 0; i++) {
if(s[i].equals("-1"))
    continue;
                if(i>0&&Integer.parseInt(s[i])>Integer.parseInt(s[i-1])) {
                    if (Integer.parseInt(s[i]) > max) {
                        max = Integer.parseInt(s[i]);
                        num += arr[i];
                        s[i] = "-1";
                    }
                }
                else if(i>0&&Integer.parseInt(s[i])==Integer.parseInt(s[i-1])){
                    //if(arr[i]>arr[i-1])
                       // num+
                }
            }
        }
        System.out.print(num);


    }
}
