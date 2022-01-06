package patterns;

public class Capachino implements Beverages {
    @Override
    public String getDescription() {
        return "Making Capachino";
    }

    @Override
    public int cost() {

        System.out.println("Capachino costs 5");
        return 5;
    }
}
