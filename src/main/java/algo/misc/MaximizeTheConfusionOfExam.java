package algo.misc;

//https://leetcode.com/problems/maximize-the-confusion-of-an-exam/
public class MaximizeTheConfusionOfExam {

    public static void main(String[] args) {

       // System.out.println(new MaximizeTheConfusionOfExam().maximize("TTFTTFTT",1));
      // System.out.println(new MaximizeTheConfusionOfExam().maximize("TFFT",1));
        System.out.println(new MaximizeTheConfusionOfExam().maximize("FFFTTFTTFT", 3));

    }

    int maximize(String answerKey,int k){

       char[] keys= answerKey.toCharArray();

       int maxTrueCount=0;
       int maxFalseCount=0;

       int trueK=k;
       int falseK=k;

       int wl=0,wr=0;

       while (wr<keys.length){

           if(keys[wr]=='T'){
               wr++;
           }
           else {
               if(trueK>0){
                   trueK--;
                   wr++;
               }
               else {
                  if(keys[wl]=='F'){
                      trueK++;
                  }
                      wl++;

               }

           }



           maxTrueCount=Math.max(maxTrueCount,wr-wl);
       }
       wl=0;
       wr=0;

        while (wr<keys.length){

            if(keys[wr]=='F'){
                wr++;
            }
            else {
                if(falseK>0){
                    falseK--;
                    wr++;
                }
                else {
                    if(keys[wl]=='T'){
                        falseK++;
                    }
                        wl++;

                }

            }

            maxFalseCount=Math.max(maxFalseCount,wr-wl);

        }

       return Math.max(maxTrueCount,maxFalseCount);

    }
}
