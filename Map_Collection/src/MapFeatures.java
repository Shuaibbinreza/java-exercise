import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapFeatures {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");

        Set<Integer> keys = map.keySet();
        System.out.println("keys = " + keys);

        Collection<String> values = map.values();
        System.out.println("values = " + values);

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        System.out.println("entries = " + entries);

        map.put(7, "Seven");
        //Will print the updated map entries
        System.out.println("entries " + entries);

//        Removing a key
        keys.remove(3);
        entries.forEach(System.out::println);

        // Removing a value. If there are multiple values then only removes the first one
        Map<Integer, String> mp =
                Map.ofEntries(
                        Map.entry(1, "one"),
                        Map.entry(2, "two"),
                        Map.entry(3, "three"),
                        Map.entry(4, "three")
                );
        System.out.println("map before remove = " + mp);
        mp = new HashMap<>(mp);
        mp.values().remove("three");
        System.out.println("map after remove = " + mp);

    }
}
