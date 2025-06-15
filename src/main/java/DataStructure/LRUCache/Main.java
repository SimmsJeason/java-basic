package LRUCache;

public class Main {
    public static void main(String[] args) {

        LRUCache<Integer, String> cache = new LRUCache<Integer, String>();
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        cache.get(1);
        cache.put(4, "d");
        System.out.println(cache.keySet());
    }
}
