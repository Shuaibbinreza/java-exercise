package generics;

public class GenericContainer<T> implements Container<T> {
    private T item;

    public void add(T item) {
        this.item = item;
    }

    public T get() {
        return this.item;
    }

}
