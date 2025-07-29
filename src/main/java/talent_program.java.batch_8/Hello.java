import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = input.nextLine();
        System.out.println("Enter the date: ");
        String date = input.nextLine();
        System.out.println("Hello " + name + ". Today is " + date + ".");
        input.close();
    }
}
