package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Inventory {

   // List<T> inventory;

   /* public Inventory(List<T> inventory)
    {
        this.inventory=inventory;
    }
*/
    public static List<Fruits> findAppleInInventory(List<Fruits> inventory, Predicate<Fruits> predicate)
    {
      return   inventory.stream().filter(predicate).collect(Collectors.toList());

    }
    public static boolean isGreenApple(Apple apple)
    {
        return apple.getColor()== Apple.Color.GREEN;
    }

    public static void main(String[] args) {


        List<Fruits> apples= Arrays.asList(new Orange("orange1","50"),new Apple(Apple.Color.BLACK,"black1"),new Apple(Apple.Color.GREEN,"green1"),
                new Apple(Apple.Color.GREEN,"green2"),new Apple(Apple.Color.WHITE,"white1"));

       // List<Apple> filteredApples=Inventory.findAppleInInventory(apples,Inventory::isGreenApple);
       // List<Apple> filteredApples1=Inventory.findAppleInInventory(apples,);

       // System.out.println(filteredApples);
    }


}
