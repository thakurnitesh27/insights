package patterns;

public class OneSpoonMochaDecorator extends BeverageDecorator {


    public OneSpoonMochaDecorator(Beverages beverages) {
    //this.beverages=beverages;
        super(beverages);
    }


    @Override
    public String getDescription() {
        return super.getDescription()+"Added OneSpoonMochaDecorator";
    }

    @Override
    public int cost() {
        System.out.println("Adding 10 for OneSpoonMochaDecorator");
        return super.cost()+10;
    }
}
