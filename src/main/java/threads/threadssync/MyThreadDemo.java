package threads.threadssync;

import java.util.concurrent.Semaphore;

public class MyThreadDemo {

    int [] int1=new int[]{1,4,7};
    int [] int2=new int[]{2,5,8};
    int [] int3=new int[]{3,6,9};
    volatile int count=0;

    Semaphore semaphore=new Semaphore(0);

    public void printInt1()
    {
        System.out.println(int1[count]);
    }

    public void printInt2(int index)
    {
        System.out.println(int2[count]);
    }

    public void printInt3(int index)
    {
        System.out.println(int3[count]);
    }

    public static void main(String[] args) {

        MyThreadDemo threadDemo=new MyThreadDemo();
        Thread t1=new Thread(()->{
            try {
                threadDemo.semaphore.acquire();
                threadDemo.printInt1();
                threadDemo.semaphore.release();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread t2=new Thread(()->{
            try {
                threadDemo.semaphore.acquire();
                threadDemo.printInt1();
                threadDemo.semaphore.release();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread t3=new Thread(()->{
            try {
                threadDemo.semaphore.acquire();
                threadDemo.printInt1();
                threadDemo.semaphore.release();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

    }
}
