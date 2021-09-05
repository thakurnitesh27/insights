package patterns.factory;

public  abstract class Pizza {
    public abstract String name();
    public Pizza addFlavourToPizza(Pizza pizza)
    {
        System.out.println("Pizza created"+ pizza);
        return pizza;
    }
    public Pizza cutPizza(Pizza pizza)
    {
        System.out.println("Pizza cut"+ pizza);
        return pizza;
    }
}
