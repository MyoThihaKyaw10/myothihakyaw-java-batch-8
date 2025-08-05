package Day6.Exercise_6_1;

import java.util.Scanner;

public class DivisionExercise {
    static int divide(int a, int b){
        try {
            return a / b;
        }
        catch (ArithmeticException e){
            System.out.println("Cannot be divided by 0");
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(divide(10,2));
        System.out.println(divide(8,0));
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int x = input.nextInt();
        System.out.println("Enter a number to divide with: ");
        int y = input.nextInt();
        System.out.println(divide(x,y));
    }
}
