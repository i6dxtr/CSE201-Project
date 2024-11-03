import java.util.Scanner;
public class AddingCalc {
    public static void main(String[] args) {
        Scanner newScanner = new Scanner(System.in);
        System.out.println("Enter a number bitch: ");

        int theirInt = newScanner.nextInt();
        int result = 1 + theirInt;

        System.out.print(result);
        newScanner.close();

    }
}
