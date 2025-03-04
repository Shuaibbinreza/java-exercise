import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Collection_to_Array {
    public static void main(String[] args) {
        Collection<String> strings = List.of("one", "two");

        String[] largerTab = {"three", "three", "three", "I", "was", "there"};
        System.out.println("largerTab = " + Arrays.toString(largerTab));

        String[] result = strings.toArray(largerTab);
        System.out.println("result = " + Arrays.toString(result));

        System.out.println("Same arrays? " + (result == largerTab));

    }
}