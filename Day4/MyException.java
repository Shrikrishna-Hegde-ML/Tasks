import java.util.*;

/**
 * MyException
 */
public class MyException {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your age");
        int age = scan.nextInt();
        try {
           if(validateAge(age)){
                System.out.println("Nice");
           }
        } catch (InvalidAgeException e) {
            System.out.println(e);
        }
    }

    static boolean validateAge(int age) throws InvalidAgeException {
        if (age<=0 || age>150) {
            throw new InvalidAgeException("Invalid Age");
        }
        return true;
    }
}

class InvalidAgeException extends Exception{
    InvalidAgeException(String message){
        super(message);
    }
}