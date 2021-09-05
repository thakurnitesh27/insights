package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;

public class IncrementBy1 {

  static   List list=new ArrayList();
    public void Increment(List<Integer> list, IntConsumer consumer)
    {
        for(Integer i:list)
        {
            consumer.accept(i);
        }

    }
    public static void putinList(int i)
    {
        list.add(i);
        //return i+"";

    }

    public static void main(String[] args) {
        IncrementBy1 incrementBy1=new IncrementBy1();
        incrementBy1.Increment(Arrays.asList(1,2,3),i-> { //System.out.print(i);
            IncrementBy1.list.add(i); });
        //);

       // incrementBy1.Increment(Arrays.asList(1,2,3),i-> System.out::print);--Cannot pass method in consumer
       // });
        //);
    }
}
