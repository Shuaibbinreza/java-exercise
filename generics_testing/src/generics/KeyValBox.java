package generics;

public class KeyValBox <K, T> implements KeyValueContainer<K, T> {
    private K key;
    private T value;

    public KeyValBox(K key, T value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }
}
