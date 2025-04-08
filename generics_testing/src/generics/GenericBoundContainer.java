package generics;

public class GenericBoundContainer<T extends Number> implements Container<T> {
    private T item;

    public void add(T item) {
        this.item = item;
    }

    public T get() {
        return this.item;
    }

}
