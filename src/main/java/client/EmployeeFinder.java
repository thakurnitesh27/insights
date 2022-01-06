package client;

import oops.Employee;

public class EmployeeFinder   {

   //Cannot call Employee clone since Employee is in different package than this class and clone method is protected in Employee class.
    //That's the reason why it is suggested to keep clone method public when overriding-so that it can be cloned in any class.
    //Java kept clone protected in object class in order to impose the rule that all subclass should override the default cloning. It not, other classes will not be
    //able to use it.
   // @Override
//    protected Object clone() throws CloneNotSupportedException {
//        new Employee().clone();
//    }

    public static void main(String[] args) {

        int i=Integer.parseInt("2345");
    }
}
