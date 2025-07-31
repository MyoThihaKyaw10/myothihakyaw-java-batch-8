import java.util.Scanner;

public class Factorial3_9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a postive integer:");
        int num = input.nextInt();
        if(num < 0){
            System.out.println("Invalid. Please enter a positive integer: ");
        }
        else{
            long output = factorial(num);
            System.out.println("Factorial of "+num+" is "+output);
        }
    }
    public static long factorial(int num){
        long fact = 1;
        for(int i = num; i >= 1; i--){
            fact *= i;
        }
        return fact;
    }
}
