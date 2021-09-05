package patterns.factory;

public class PizzaFactoryTest {

    public static void main(String[] args) {

        PizzaStore pizzaStore=new NyPizzaStore();
        pizzaStore.orderPizza("Cheese");

        PizzaStore pizzaStore2=new ChicagoPizzaStore();
        pizzaStore2.orderPizza("Cheese");
    }
}
