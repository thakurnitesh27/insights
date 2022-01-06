package java8;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class HashMap  {

    public static void main(String[] args) {
//
//        HashSet<Character> s1 = new HashSet<Character>(8);
//        s1.add('a');
//        s1.add('b');
//        s1.add('c');
//        s1.add('d');
//        s1.add('e');
//        s1.add('f');
//        s1.add('g');
//        s1.add('h');
//        s1.add('i');
//        s1.add('j');
//        s1.add('k');
//        s1.add('l');
//        s1.add('m');
//        s1.add('n');
//        s1.add('o');
//        s1.add('p');
//        s1.add('q');
//        s1.add('r');
//        s1.add('s');
//        s1.add('u');
//        s1.add('v');
//        s1.add('w');
//        s1.add('x');
//        s1.add('y');
//        s1.add('z');
//
//        System.out.println(s1);

        java.util.HashMap map=new java.util.HashMap();

        map.put("MAY",1);
        map.put("MYA",2);
        map.put("AMY",3);
        map.put("AYM",4);
        map.put("YAM",5);
        map.put("YMA",6);

        map.get("YAM");

        System.out.println(map);

        TreeMap treeMap=new TreeMap();
        treeMap.put("Nitesh",1);
        treeMap.put("Anjali",1);
        treeMap.put("Nitesh",1);
        treeMap.put("Maa",1);
        System.out.println(treeMap);

    }
}
