package patterns.factory;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        return  new ChicagoCheesePizza();
    }
}
