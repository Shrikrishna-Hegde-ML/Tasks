import java.util.Scanner;
public class arithExcep {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter two integers");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();

        try {
            int ans = num1/num2;
            System.out.println("Answer: "+ans);
        } catch (ArithmeticException e) {
            System.out.println("Excpetion: ");
            e.printStackTrace();
        }
    }
}