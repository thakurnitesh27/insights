package threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTest {


    public void doLongComputation()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {


        FutureTest futureTest=new FutureTest();

        FutureTask<FutureTest> futureTestFutureTask=new FutureTask<FutureTest>(()->{futureTest.doLongComputation(); return  futureTest;});


       // futureTestFutureTask.run();

        Thread t=new Thread(futureTestFutureTask);
        t.start();

        System.out.println(" I am main thread engaged in doing something else");

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(futureTestFutureTask.get());
    }
}
