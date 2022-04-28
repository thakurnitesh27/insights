import java.util.HashMap;

interface Cacheable<K,V>{

    public V get(K key);
    public void put(K key, V val);

}

enum CacheTypeEnum{
    LRU, SORTED
}

public class CustomCache {

    //eviction type -LRU, lexi Sorted

  CacheTypeEnum cacheTypeEnum;

    Cacheable cache;



    public CustomCache(){
        cache=new LRUCache();
    }

    public CustomCache(Cacheable cache){
    this.cache=cache;
    }

    public int get(int key){
     return (int) cache.get(key);

    }

    public void put(int key,int value){
        cache.put(key,value);

    }


    class LinkedNode{
        int val;
        LinkedNode prev;
        LinkedNode next;


    }

    class LRUCache implements Cacheable{
        LinkedNode head;
        LinkedNode tail;

        HashMap<Integer, LinkedNode> map=new HashMap();

        @Override
        public Object get(Object key) {
            if( map.get(key)!=null){
                LinkedNode currentNode= map.get(key);

                if(currentNode.prev!=null && currentNode.next!=null){
                    currentNode.prev.next=currentNode.next;
                    currentNode.next.prev=currentNode.prev;
                }
            }
            return null;
        }

        @Override
        public void put(Object key, Object val) {


        }
    }

    class SortedCache implements Cacheable{

        @Override
        public Object get(Object key) {
            return null;
        }

        @Override
        public void put(Object key, Object val) {

        }
    }
    /*
    1. Check null key and values handling
    2. Check if eviction policies works as promised. 3 size- 1,2,3,4,1,5
    3. Get and put operation
    4.

     */
}
