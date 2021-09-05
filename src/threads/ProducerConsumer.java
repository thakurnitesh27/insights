package threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {
    int counter;
    Lock lock = new ReentrantLock();

    Task[] arr;
    Condition isQueueFull = lock.newCondition();
    Condition isQueueEmpty = lock.newCondition();

    Producer producer;
    Consumer consumer;
    ProducerConsumer(Task[] tasks) {
        arr = tasks;
        producer=new Producer();
        consumer=new Consumer();
    }

    public boolean offer(Task task)
    {

       return producer.add(task);
    }

    public Task poll()
    {
        return consumer.get();
    }

    class Producer {


//        Producer(Task[] arr)
//        {
//            this.arr=arr;
//        }

        boolean add(Task task) {
            try {


                if (counter < arr.length) {
                    arr[counter] = task;
                    return true;
                } else {
                    try {
                        lock.lock();
                        while (counter >= arr.length) {
                            isQueueEmpty.await();
                        }
                        arr[counter] = task;
                        isQueueFull.signalAll();
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    } finally {
                        lock.unlock();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                return false;

            }
        }
    }

    class Consumer {


//        Producer(Task[] arr)
//        {
//            this.arr=arr;
//        }

        Task get() {
            try {


                if (counter > 0) {
                    return arr[counter--];

                } else {
                    try {
                        lock.lock();
                        while (counter < 0) {
                            isQueueFull.await();
                        }
                        // arr[counter]=task;
                        isQueueEmpty.signalAll();
                        return arr[counter--];
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                //return false;

            }
            return null;
        }


    }

    public static void main(String[] args) {

        Task [] tasks=new Task[1];

        ProducerConsumer producerConsumer=new ProducerConsumer(tasks);


        Thread t1=new Thread(()->{
            producerConsumer.offer(new Task());
            producerConsumer.offer(new Task());
            producerConsumer.offer(new Task());
            producerConsumer.offer(new Task());
            producerConsumer.offer(new Task());
            producerConsumer.offer(new Task());
        });

        Thread t2=new Thread(()->{

            System.out.println(producerConsumer.poll());
            System.out.println(producerConsumer.poll());
            System.out.println(producerConsumer.poll());
            System.out.println(producerConsumer.poll());
            System.out.println(producerConsumer.poll());
            System.out.println(producerConsumer.poll());
        });

        t1.start();
        t2.start();
    }
}
class Task {
    static  int taskIdCounter;

    int taskId;
    public void doTask(){

        try {
            taskId=taskIdCounter;
            taskIdCounter++;
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                '}';
    }
}
