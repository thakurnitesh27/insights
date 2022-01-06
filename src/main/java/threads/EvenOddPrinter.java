package threads;

public class EvenOddPrinter {
             static int count;
 static    class EvenPrinter implements Runnable
    {

final Object lock;
//volatile int count;

        public EvenPrinter(Object lock,int count) {
            this.lock = lock;
           // this.count=count;
        }

        @Override
        public void run() {




                // int i=1;


                  //    System.out.println("Even Loop Counter:"+count);

                       synchronized (lock)

                       {
                           while ( count<20)

                           {
                                                       //       System.out.println("Current Num in Odd Printer: "+count);
                while (count%2!=0)
                {
                    try {

                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                 System.out.println("Even Printer:"+ count);

                     count++;
                     lock.notifyAll();
             }





            }
        }
    }


  static   class OddPrinter implements Runnable
    {
        final Object lock;
    //  volatile   int count;

        public OddPrinter(Object lock,int count) {
            this.lock = lock;
          //  this.count=count;
        }
        @Override
        public void run() {



              //  int i=1;

               // {
                  //  System.out.println("Odd Loop Counter:"+count);
                     synchronized (lock)
                             
                     {
                          while (count<20)
                          {
                       //  System.out.println("Current Num in Odd Printer: "+ count);
                    while (count%2==0)
                    {
                        try {

                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Odd Printer:"+ count);

                    count++;
                    lock.notifyAll();
                }





            }
        }
    }

    public static void main(String[] args) {
        Object lock=new Object();
        EvenOddPrinter evenOddPrinter=new EvenOddPrinter();
        Thread evenPrinterThread=new Thread(new EvenPrinter(lock,20));
        Thread oddPrinterThread=new Thread(new OddPrinter(lock,20));

        evenPrinterThread.start();
        oddPrinterThread.start();
    }
}
