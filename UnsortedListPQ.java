import java.util.LinkedList;

public class UnsortedListPQ<K extends Comparable<K>, V> implements PriorityQueue<K, V> {
    private LinkedList<MyEntry<K, V>> list = new LinkedList<>();

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void insert(K key, V value) {
        list.addLast(new MyEntry<>(key, value));
    }

    @Override
    public MyEntry<K, V> min() {
        if (isEmpty()) {
            return null;
        }
        MyEntry<K, V> minEntry = list.getFirst();
        for (MyEntry<K, V> entry : list) {
            if (entry.compareTo(minEntry) < 0) {
                minEntry = entry;
            }
        }
        return minEntry;
    }

    @Override
    public MyEntry<K, V> removeMin() {
        if (isEmpty()) {
            return null;
        }
        MyEntry<K, V> minEntry = min();
        list.remove(minEntry);
        return minEntry;
    }
}
