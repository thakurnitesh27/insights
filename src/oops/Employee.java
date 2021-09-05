package oops;

import java.util.HashMap;
import java.util.Map;

public class Employee implements Cloneable {
    String name;
    Map<String,String> educations=new HashMap();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
