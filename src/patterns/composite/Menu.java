package patterns.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Menu implements MenuComponent {

 private    ArrayList<MenuComponent> childList=new ArrayList<>();
String name;
String desc;

    public Menu(String name, String desc) {
        this.name = name;
        this.desc = desc;
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
    public void print() {
        System.out.print("\n" +name);
        System.out.print("-"+desc);
        System.out.print("-----");
        Iterator<MenuComponent> iterator=childList.iterator();

        while (iterator.hasNext())
        {
            MenuComponent menuComponent=iterator.next();
            menuComponent.print();
        }

    }




    @Override
    public void add(MenuComponent menuComponent) {
childList.add(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return childList.get(i);
    }

    @Override
    public Iterator iterator() {
        return new MenuIterator(childList.iterator());
    }

    class MenuIterator implements Iterator<patterns.composite.MenuComponent>
    {
        Stack<Iterator> stack=new Stack<>();

        public MenuIterator(Iterator iterator) {
            stack.push(iterator);
        }

        @Override
        public boolean hasNext() {
            if(stack.isEmpty())
                return false;
            else{
                Iterator iterator=stack.peek();

                    if(iterator.hasNext())
                    {
                        return true;
                    }
                    else
                        {
                            stack.pop();
                            return   hasNext();
                        }
                }

        }

        @Override
        public MenuComponent next() {
            MenuComponent menuComponent=null;

            if (hasNext())
            {
                Iterator<MenuComponent> iterator=stack.peek();
                 menuComponent=iterator.next();
                if(menuComponent instanceof Menu)
                {
                    stack.push(menuComponent.iterator());
                }
            }
            return null;
        }
    }
}
