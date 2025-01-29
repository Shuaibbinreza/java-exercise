import java.util.*;

public class Customer extends Card{
    private String name;
    private int age;
    private String address;
    private String email;
    static Map<String, Boolean> customerMap = new HashMap<>();
    public static Map<String, Integer> accountNo = new HashMap<>();

    private enum customerStatus{
        ACTIVE,
        INACTIVE,
        BLOCKED,
        BANNED,
        COMPROMISED,
        ARCHIVED,
        CLOSED,
        UNKNOWN;
    }

    public void setCustomer(String name, int age, String address, String email){
        if(!customerMap.containsKey(email)){
            this.name = name;
            this.age = age;
            this.address = address;
            this.email = email;
            customerMap.put(email, true);
            Random rand = new Random();
            int randomNumber = 10000 + rand.nextInt(90000);
            accountNo.put(email, randomNumber);
            System.out.println("Mr/Ms " + name + "! You are now a customer of this bank. Your account Number is: " + accountNo.get(email));
        }
        else{
            System.out.println("Customer already exists with this email address");
        }

    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
