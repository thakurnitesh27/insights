package patterns;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterable<T> {

    T[]array;
int currentIndex;

    public ArrayIterator(T[] array)
    {
       this.array=array;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr<T>();
    }

 private    class Itr<T> implements Iterator<T>
    {

        @Override
        public boolean hasNext() {
            return currentIndex<array.length;
        }

        @Override
        public T next() {
            if(currentIndex>=array.length)
                throw new IndexOutOfBoundsException();
            return (T) array[currentIndex++];
        }
    }


    public static void main(String[] args) {

        String [] strings=new String[]{"Papa","Maa","Nitesh","Anjali","Pooja","Shashank","Nitin"};
        ArrayIterator<String> arrayIterator=new ArrayIterator<>(strings);

        Iterator<String> iterator=arrayIterator.iterator();

        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

    }
}
