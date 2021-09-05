package patterns.factory;

public  abstract class PizzaStore {

    public Pizza orderPizza(String type)
    {
       Pizza pizza= createPizza(type);
       pizza.addFlavourToPizza(pizza);
       pizza.cutPizza(pizza);
       return pizza;
    }
    public abstract Pizza createPizza(String type);

}
