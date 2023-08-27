package design.splitwise;

public class SplitWiseApp {

    public static void main(String[] args) {


        Group group=new Group("G1","Group1");
        group.addUsers(new Person("P1",group));
    }
}
