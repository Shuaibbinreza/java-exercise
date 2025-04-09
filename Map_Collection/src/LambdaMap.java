import java.util.HashMap;
import java.util.Map;

public class LambdaMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        System.out.println(map.replace(1, "uno")); // Output: one
        map.forEach((key, value) -> System.out.println(key + " :: " + value));

        System.out.println(map.replace(2, "dos")); // Output: null (key 2 not present)
        map.forEach((key, value) -> System.out.println(key + " :: " + value));

        map.put(2, "two");
        System.out.println(map.replace(2, "two", "dos")); // Output: true
        System.out.println(map.replace(2, "three", "tres")); // Output: false (value mismatch)
        map.forEach((key, value) -> System.out.println(key + " :: " + value));

        Map<Integer, String> mp = new HashMap<>();

        mp.put(1, "one");
        mp.put(2, "two");
        mp.put(3, "three");

        System.out.println("Before ReplaceAll");
        mp.forEach((key, value) -> System.out.println(key + " :: " + value));

        mp.replaceAll((key, value) -> value.toUpperCase());
        System.out.println("After ReplaceAll");
        mp.forEach((key, value) -> System.out.println(key + " :: " + value));

    }
}
