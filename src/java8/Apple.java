package java8;

public class Apple implements Fruits{

    enum Color
    {
        ORANGE, BLUE, RED,BLACK,WHITE,GREEN

    }

    @Override
    public String toString() {
        return "Apple{" +
                "color=" + color +
                ", name='" + name + '\'' +
                '}';
    }

    Color color;
    String name;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Apple(Color color, String name) {
        this.color = color;

        this.name=name;
    }
}
