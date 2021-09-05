package patterns.composite;

import java.util.Iterator;

public class MenuItem implements MenuComponent {

    String name;
    String desc;
    double price;
    boolean isVegetarian;

    public MenuItem(String name, String desc, double price, boolean isVegetarian) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.isVegetarian = isVegetarian;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return desc;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void print() {


        System.out.print(getName());
        if(isVegetarian)
            System.out.print("-v-");
        System.out.print(desc);
        System.out.println(price);
    }

    @Override
    public Iterator<MenuItem> iterator() {
        return new MenuItemIterator<>();
    }


    class MenuItemIterator<T> implements Iterator<T>
    {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }
}
