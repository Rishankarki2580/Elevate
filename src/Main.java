import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static double add(double a, double b){
        return a+b;
    }

    public static double subtract(double a, double b){
        return a-b;
    }

    public static double multiply(double a, double b){
        return a*b;
    }

    public static double divide(double a, double b){
        if(b == 0){
            System.out.println("Error!!!");
            return Double .NaN;
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1,num2, result;
        char operator;
        boolean continueCalc = true;

        System.out.println("Basic calculator");

        while(continueCalc) {
            System.out.println("Enter first number");
            num1 = scanner.nextDouble();

            System.out.println("Enter operator(+, -, *, /): ");
            operator = scanner.next().charAt(0);

            System.out.println("Enter second number");
            num2 = scanner.nextDouble();

            switch (operator) {
                case '+':
                    result = add(num1, num2);
                    System.out.println("Result:" + result);
                    break;

                case '-':
                    result = subtract(num1, num2);
                    System.out.println("Result:" + result);
                    break;

                case '*':
                    result = multiply(num1, num2);
                    System.out.println("Result:" + result);
                    break;

                case '/':
                    result = divide(num1, num2);
                    if(Double.isNaN(result)){
                        System.out.println("Result:" + result);
                    }
                    break;
                default:
                    System.out.println("Invalid operator");
                    break;
            }
            System.out.println("Do you want to continue? y/n");
            char choice  = scanner.next().charAt(0);

            if(choice != 'y' && choice != 'Y') {
                continueCalc = false;
                System.out.println("Exiting calculator");
            }
        }
        scanner.close();
    }
}