import java.util.Scanner;

public class Example2 {
    private int num1;
    private int num2;

    public void takeInput() {
        while (true){
            try{
                Scanner sc = new Scanner(System.in);
                num1 = sc.nextInt();
                num2 = sc.nextInt();

                calculate();

                break;
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

    }

    private void calculate() throws IllegalArgumentException{
        if(num1 > num2){
            throw new IllegalArgumentException("Both int must be positive");
        }
        else{
            System.out.println("Correct output provided");
        }
    }
}
