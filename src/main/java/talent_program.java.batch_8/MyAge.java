import java.util.Scanner;

public class MyAge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your birth year:");
        int birthyear = input.nextInt();
        int age = (2025 - birthyear);
        System.out.println("You are "+age+" years old.");
        input.close();
    }
}
