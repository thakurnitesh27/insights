package oops;

 interface Interface1 {
    default public void mymethod()
    {
        System.out.println("Interface default method in interface");
    }

    public static void eat()
    {
        System.out.println("I am eating");
    }

//    private void codeReuse()
//    {
//        System.out.println("I am private");
//    }

     class InnerInterface implements Interface1{
         public void innerInterfaceMethod(){


        }

         public static void main(String[] args) {
                InnerInterface innerInterface=new InnerInterface();
                Interface1.eat();
         }
    }
}

interface Interface2 extends Interface1
{
    default public void mymethod1()
    {
        System.out.println("Interface mymethod1 in Interface2");
    }
}
public class  InterfaceTrial implements  Interface2
{
    public static void main(String[] args) {
        InterfaceTrial interfaceTrial=new InterfaceTrial();
        interfaceTrial.mymethod();
        interfaceTrial.mymethod1();
        Interface1.eat();
    }
}
