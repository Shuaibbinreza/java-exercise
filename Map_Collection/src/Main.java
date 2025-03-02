public class Main {
    public static void main(String[] args) {
        System.out.println("Adding Element in a HashMap");
        HashMapTrial hp = new HashMapTrial();
        hp.addNumbers();

        System.out.println("Printing HashMap");
        hp.printNumbers();

        System.out.println("\n\nAdding Element in a TreeMap");
        TreeMapTrial tm = new TreeMapTrial();
        tm.addNumbers();

        System.out.println("Printing TreeMap");
        tm.printNumbers();

        System.out.println("\n\nAdding Element in a LinkedHashMap");
        LinkedHashMapTrial lhm = new LinkedHashMapTrial();
        lhm.addNumbers();

        System.out.println("Printing LinkedHashMap");
        lhm.printNumbers();
    }
}

//Same as HashMap but keeps the order