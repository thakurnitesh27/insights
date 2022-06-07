import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadPoolExecutor;

public class ProducerConsumerForkJoinPool {

    ExecutorService executor;

    ProducerConsumerForkJoinPool(){
        executor= ForkJoinPool.commonPool();
    }



}
