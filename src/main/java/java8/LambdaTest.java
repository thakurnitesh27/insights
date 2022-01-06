package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaTest {

    int price;
    public Integer convertToString(String price,Function<String, Integer> function)
    {
       return function.apply(price);


    }

    public boolean isPriceGreater(Long desiredPrice, Predicate predicate)
    {
       return predicate.test(desiredPrice);
    }

    public static void main(String[] args) {

        Supplier<LambdaTest> lambdaTest=LambdaTest::new;

        lambdaTest.get().convertToString("200",(String x)->Integer.parseInt(x));
        lambdaTest.get().convertToString("200",Integer::parseInt);

        lambdaTest.get().isPriceGreater(300L,(x)->(Long)x>lambdaTest.get().price);


        List list=new ArrayList();

        Predicate<Integer> evenNo=(i)->i%2==0;
        Predicate<Integer> oddNo=(i)->i%2!=0;

       // oddNo.a
int k=2;
       // Stream.iterate(1,(i)->i<50,(i)->i++).filter(evenNo.negate().and(oddNo)).map((Integer i)->(i+"\n")).forEach(System.out::print);
//        Stream.iterate(k,(i)->i<50,(i)->i++).map((Integer i)->{
//            var sqrtNum=Math.sqrt(i);
//            for(var j=2;j<=sqrtNum;j++)
//            {
//                if(i%j==0)
//                    return i;
//            }
//            return -1;
//        })./*filter(i->(i==-1)).*/forEach(System.out::print);
       // List.of(1,2,3,4,5,).stream();

        String words="Hello World";

        List<String> wordsList= new ArrayList<>();

      List<String[]> data=  Stream.of("Hello World").map((String s)->{
            String [] stringChars=new String[s.length()];
            for(int i=0;i<s.length();i++)
            {
              stringChars[i]=s.charAt(i)+"";
            }
            return stringChars;
        }).distinct().collect(Collectors.toList());

       // System.out.println(data);

        for(int i=0;i<data.size();i++)
        {
            System.out.println("i is "+i);
            String [] tmp=data.get(i);
            for(int j=0;j<tmp.length;j++)
                System.out.println(tmp[j]);
            System.out.println("\n");
        }


//        List<String[]> data1=  Stream.of("Hello World").map((String s)->{
//            String [] stringChars=new String[s.length()];
//            for(var i=0;i<s.length();i++)
//            {
//                stringChars[i]=s.charAt(i)+"";
//            }
//            return stringChars;
//        }).collect(Collectors.toList()).stream().flatMap(Arrays::stream).distinct().collect(Collectors.toList());

        List<String> data2=Stream.of("Hello World").map((String s)->s.split(" ")).distinct().flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println(data2);
    }
}
