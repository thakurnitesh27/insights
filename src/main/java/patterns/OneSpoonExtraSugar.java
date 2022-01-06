package patterns;

public class OneSpoonExtraSugar extends BeverageDecorator {

    public OneSpoonExtraSugar(Beverages beverages) {
       // this.beverages=beverages;
        super(beverages);
    }

    @Override
    public String getDescription() {
        return beverages.getDescription()+"Added OneSpoonExtraSugar";
    }

    @Override
    public int cost() {
        System.out.println("Adding 5 for OneSpoonExtraSugar");
        //super.cost();
        return super.cost()+5;
    }
}
