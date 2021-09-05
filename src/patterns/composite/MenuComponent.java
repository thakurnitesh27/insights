package patterns.composite;

public interface MenuComponent  extends Iterable{

    public String getName();
    public String getDescription();
    default
    public double getPrice()
    {
        return 0;
    }

    public void print();

    default
    public Boolean isVegetarian()
    {
        return false;
    }

    default
    public Boolean remove()
    {
        throw new UnsupportedOperationException();
    }

    default
    public void add(MenuComponent menuComponent)
    {
        throw new UnsupportedOperationException();
    }

    default
    public MenuComponent getChild(int i)
    {
        throw new UnsupportedOperationException();
    }
}
