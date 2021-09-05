package patterns;

public class MySystem {
    System system;
    //Using Principle of least knowledge. Out should not be used in other classes directly since using its method in our class makes it
    //prone to bound ourselves to make the changes whenever PrintStream changes its behaviour.
    //For instance, print() method is renamed to show(), in that case, our code has to be changed. But if System had exposed print() method-
    //a wrapper which internally calls PrintStream's print method, our classes using system is not bound to follow the PrintStream change.
    public void print(Object data)
    {
        system.out.print(data);
    }
}
