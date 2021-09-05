package generics;

import java.util.ArrayList;
import java.util.List;

public class SuperTest {

    public int multiply(int num)
    {
        return num*2;
    }



    public static void main(String[] args) {
      //  List<? super Sub2>
    }
}

class Sub1 extends SuperTest
{

    public int add(int num1, int num2)
    {
        return num1+num2;
    }
}

class Sub2 extends Sub1
{


    private static List<? super Sub2> list=new ArrayList<>();
    //super means any subtype of Sub2 is allowed. So, we can add only to collection which has super wildcard.
    //For extends, any parent class can come and it is unknown if the new method written in this subclass exists in superclass too and
    //so it can be problematic at runtime.
    //For super, since only subclasses are allowed, the methods which are defined in this class has to be in child class.
    public int subtract(int num1, int num2)
    {
        return num1-num2;
    }


    public <T >void addToList( Sub3 superTest)
    {
        list.add(superTest);
    }
}
class Sub3 extends Sub2
{

}
