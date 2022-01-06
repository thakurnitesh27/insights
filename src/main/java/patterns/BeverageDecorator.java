package patterns;

//public abstract class BeverageDecorator implements Beverages {
public  class BeverageDecorator implements Beverages {


    public BeverageDecorator(Beverages beverages) {
        this.beverages = beverages;
    }

    protected Beverages beverages;

    @Override
    public String getDescription() {
        return beverages.getDescription();
    }

    @Override
    public int cost() {
        return beverages.cost();
    }
    /*@Override
    public abstract String getDescription() ;

    @Override
    public abstract int cost() ;*/


}
