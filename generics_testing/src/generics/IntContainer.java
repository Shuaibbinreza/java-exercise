package generics;

public class IntContainer implements Container<Integer> {
    private int serialNumber;

    public IntContainer(int serialNumber) {
        add(serialNumber);
    }

    public void add(Integer item) {
        this.serialNumber = item;
    }

    public Integer get() {
        return this.serialNumber;
    }
}
