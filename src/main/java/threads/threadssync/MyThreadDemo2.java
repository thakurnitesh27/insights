package threads.threadssync;

public class MyThreadDemo2 {

    int [] int1=new int[]{1,4,7};
    int [] int2=new int[]{2,5,8};
    int [] int3=new int[]{3,6,9};
    final Object lock1=new Object();
    final Object lock2=new Object();
    volatile int count=0;

    volatile boolean printInt1=false;
    volatile boolean isPrintInt2=false;
    volatile boolean isPrint3=false;

    public void printInt1()
    {
        while (count<3)
        {
            synchronized (lock1)
            {
               while (printInt1)
                {
                    try {
                        lock1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(int1[count]);
               lock1.notifyAll();
            }
        }

    }

    public void printInt2() {
        while (count < 3) {
            synchronized (lock1) {
                synchronized (lock2) {
                    while (printInt1 && isPrintInt2) {
                        try {
                            lock1.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(int1[count]);
                    lock1.notifyAll();
                }
            }

        }
    }
    public void printInt3()
    {
        while (count<3)
        {
            synchronized (lock1)
            {
                while (printInt1)
                {
                    try {
                        lock1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(int1[count]);
                lock1.notifyAll();
            }
        }

    }

}
