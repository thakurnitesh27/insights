package patterns.factory;

public class NyPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
         return new NyCheezaPizza();
    }
}
