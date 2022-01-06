package patterns;

public class Expresso implements Beverages {
    @Override
    public String getDescription() {
        return "Making Expresso";
    }

    @Override
    public int cost() {

        System.out.println("Expresso costs 20");
        return 20;
    }
}
