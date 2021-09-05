package patterns;

public class DecoratorPatternTest {

    public static void main(String[] args) {

        Beverages beverages=new OneSpoonMochaDecorator(new OneSpoonExtraSugar(new OneSpoonExtraSugar(new Capachino())));

        System.out.println(beverages.cost());
        System.out.println(beverages.getDescription());

    }
}
