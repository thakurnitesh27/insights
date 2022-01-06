package patterns;

public class Latte implements Beverages {
    @Override
    public String getDescription() {
        return "Making Latte";
    }

    @Override
    public int cost() {

        System.out.println("Latte costs 10");
        return 10;
    }
}
