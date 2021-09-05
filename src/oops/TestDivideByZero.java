package oops;

import java.util.HashMap;

public class TestDivideByZero {

    public static void main(String[] args) {

//        int i=0;
//
//        int sum=10;
//        int t=sum/i;


        HashMap map=new HashMap();
        map.put(1,new Integer(1));
        map.put(2,new Integer(2));
        map.put(3,new Integer(3));

        System.out.println(map.get(2));



    }
}
