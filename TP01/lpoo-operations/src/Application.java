import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose the operation: (sum or mul)");
        String operation = scanner.nextLine();

        System.out.println("Please input first number: ");
        int a = scanner.nextInt();
        System.out.println("Please input second number: ");
        int b = scanner.nextInt();

        int result = 0;

        if(operation.equals("sum")) {
            result = a + b;
        } else if (operation.equals("mul")) {
            result = a*b;
        }

        System.out.printf("Result: %d", result);
    }
}