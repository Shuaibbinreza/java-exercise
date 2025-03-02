import java.util.HashMap;
import java.util.Map;

public class HashMapTrial {
    Map<Person, String> phoneBook = new HashMap<>();
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

/// In the code you've provided, you're using Person objects as keys in a HashMap and attempting to store phone numbers for different people. However, there is an issue that can arise here due to the default behavior of Person objects in a HashMap. Here's a breakdown:
/// Use of Mutable Objects as Keys: If the Person class doesn't override the hashCode() and equals() methods, the default behavior from the Object class is used. This means:
/// Two Person objects with the same name (like rahim and karim, both having the name "Rahim") might be treated as different keys, because the default implementation of hashCode() in Object generates a unique hash code for each object.
/// If the hashCode() and equals() methods aren't overridden, phoneBook.put(rahim, "01624656514") and phoneBook.put(karim, "01624656515") might not consider them as the same person, even though their names are the same.
/// Printing Shuaib: When you print shuaib, it will call the toString() method of the Person class. If toString() is not overridden in the Person class, it will use the default toString() from Object, which returns a string like Person@hashcode, where hashcode is the memory address. This won't be very useful or readable for the user.
/// Duplicates for "Rahim": In your code, both rahim and karim are instances of Person, and their names are identical. This could potentially lead to confusion when querying the map for "Rahim", as the two instances are treated as separate keys unless the hashCode() and equals() methods are implemented correctly.
