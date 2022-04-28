import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Test {

    public static void main(String[] args) {

        HashMap<String, String> map=new HashMap();
        map.put("AUD","06/01/2022");
        map.put("USD","06/01/2025");
        map.put("CHF","06/01/2021");
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("DD/MM/YYYY");
//
//        LocalDate todayDate= LocalDate.now();
//
//        map.values().stream().filter(d->{
//          LocalDate date=LocalDate.parse(d,formatter);
//         int val= date.compareTo(todayDate);
//         return val>0?true:false;
//        }).forEach(System.out::print);
//

//        int[] arr=new int[]{1,2,3};
//        Integer [] arr1=new Integer[]{1,2,3};
//       Object obj= Arrays.asList(arr);
//       Object obj1= Arrays.asList(arr1);
//
//       ArrayList<Integer> list=new ArrayList<>();
//       list.add(1);
//       list.add(11);
//       list.add(12);
//      Integer[] ans= list.toArray(new int[1]);


    }





}
