package generics;

public class GenericsPair<K, V> {
    private K key;
    private V value;

    public GenericsPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }
}
