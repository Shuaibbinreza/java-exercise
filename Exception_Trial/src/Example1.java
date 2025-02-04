import java.util.Scanner;

public class Example1 {
    private int n = 0, m = 0;
    private int sum;
    private int sub;
    private int div;
    private int mul;
    private int mod;
    public void takeInput(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter first number (n): ");
                n = Integer.parseInt(sc.nextLine());

                System.out.print("Enter second number (m): ");
                m = Integer.parseInt(sc.nextLine());

                sum = n + m;
                sub = n - m;
                div = n / m;
                mod = n % m;
                mul = n * m;

                break; // Exit loop if inputs are valid
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter integers only.");
            } catch (ArithmeticException e) {
                System.out.println("Arithmetic exception. Try again.");
            }
        }
    }

    public void showOutput(){
        System.out.println("Sum: " + sum);
        System.out.println("Sub: " + sub);
        System.out.println("Div: " + div);
        System.out.println("Mul: " + mul);
        System.out.println("Mod: " + mod);
    }
}
