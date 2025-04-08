import generics.Box;
import generics.BoxInterface;
import generics.GenericBoundContainer;
import generics.GenericContainer;
import generics.GenericsPair;
import generics.IntContainer;
import generics.KeyValBox;
import generics.KeyValueContainer;

public class App {
    public static void main(String[] args) throws Exception {
        Box<String> box = new Box<>();
        box.setBox("Hello World");
        System.out.println(box.getBox());

        String str = (String) box.getBox();
        System.out.println(str);

        Box<Integer> box2 = new Box<>();
        box2.setBox(5);

        System.out.println(box2.getBox());
        Integer val = box2.getBox();
        System.out.println(val);

        // Key Pair
        System.out.println("\n\nKey Pair Testing");
        GenericsPair<String, Integer> age = new GenericsPair<String,Integer>("Age", 27);
        GenericsPair<String, String> name = new GenericsPair<String,String>("Name", "Shuaib");

        System.out.println(age.getKey() + ": " + age.getValue());
        System.out.println(name.getKey() + ": " + name.getValue());

        // Generics Interface
        System.out.println("\n\nGenerics Interface Testing");
        BoxInterface boxInterface = new BoxInterface();
        boxInterface.add("Hello World");
        System.out.println(boxInterface.get());

        IntContainer ic = new IntContainer(123);
        int sn = ic.get();
        System.out.println("Serial Number is: " + sn);  


        // Generic Container
        System.out.println("\n\nGeneric Container Testing");
        GenericContainer<String> gc = new GenericContainer<>();
        gc.add("Generic Container");
        String gcItem = gc.get();
        System.out.println(gcItem);

        // Generic Bound Container
        System.out.println("\n\nGeneric Bound Container Testing");
        GenericBoundContainer<Double> gbc = new GenericBoundContainer<>();
        gbc.add(140.55);
        Double gbcItem = gbc.get();
        System.out.println(gbcItem);

        // Key Value Interface
        System.out.println("\n\nKey Value Interface Testing");
        KeyValBox<String, String> kv_name = new KeyValBox<>("Name", "Shuaib");
        String key_kv = kv_name.getKey();
        String val_kv = kv_name.getValue();
        System.out.println(key_kv + ": " + val_kv);

        KeyValBox<String, Integer> kv_age = new KeyValBox<>("Age", 27);
        String key_kv2 = kv_age.getKey();
        Integer val_kv2 = kv_age.getValue();
        System.out.println(key_kv2 + ": " + val_kv2);
    }
}
