import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class LinkedHashMapTrial {
    Map<Person, String> phoneBook = new LinkedHashMap<>();

    Person shuaib = new Person("Shuaib");
    Person tamim = new Person("Tamim");
    Person abdullah = new Person("Abdullah");
    Person rahim = new Person("Rahim");
    Person karim = new Person("Rahim");

    public void addNumbers(){
        phoneBook.put(shuaib, "01624656511");
        phoneBook.put(tamim, "01624656512");
        phoneBook.put(abdullah, "01624656513");
        phoneBook.put(rahim, "01624656514");
        phoneBook.put(karim, "01624656515");
    }

    public void printNumbers(){
        for(Map.Entry<Person, String> entry : phoneBook.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
