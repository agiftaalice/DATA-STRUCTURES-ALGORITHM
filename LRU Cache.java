import java.util.*;

class LRUCache extends LinkedHashMap<Integer, Integer> {
    private final int capacity;

    LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
        if (size() > capacity) {
            Iterator<Integer> it = keySet().iterator();
            it.next();
            it.remove();
        }
    }
}
