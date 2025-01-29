public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();

        customer1.setCustomer("Shuaib", 26, "Mirpur", "shuaib6950@gmail.com");
        customer2.setCustomer("Shuaib", 26, "Mirpur", "shuaib6950@gmail.com");

        customer1.setCard(customer1.accountNo.get(customer1.getEmail()));
        System.out.println(customer1.accountNo.get(customer1.getEmail()));
    }
}