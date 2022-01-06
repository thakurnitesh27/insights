package generics;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class SuperExtends {
    //Use extends when we want to get items from collections. Use super when we need to put items into collections.

    public static void main(String[] args) {
       // List<>
    }

    public static void addNumbers(List<? extends Integer> list)
    {
       //list.forEach(((i)->(SuperExtends::multiply))->{System.out.print();});
       list.stream().map(SuperExtends::multiply).forEach(i->System.out.print(i));

       // list.forEach(i->SuperExtends::multiply);

        list.forEach(i->System.out.print(i));
      // list.stream().parallel().mapToDouble(i->i*Math.pow(i,2)).collect(Collectors.toList());
    }
    public static  <T extends Number> int multiply(T num)
    {
        return (Integer.parseInt(Integer.parseInt(num.toString())*2+""));
    }
}
