package generics;

public class BoxInterface implements Container<String> {
    private String name;

    public void add(String item) {
        this.name = item;    
    }

    public String get() {
        return this.name;
    }
}
