package java8;

public interface Fruits {

    String name="fruit";

    default public String getName()
    {
        //name="fruit";
        return name;
    }
}
