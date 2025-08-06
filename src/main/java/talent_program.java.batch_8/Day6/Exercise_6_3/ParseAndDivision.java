package Day6.Exercise_6_3;

import java.util.Scanner;

public class ParseAndDivision {
    public static int parseAndDivide(String a, String b){
        try{
            int num1 = Integer.parseInt(a);
            int num2 = Integer.parseInt(b);
            return num1/num2;
        }
        catch(NumberFormatException e){
            System.out.println("Error: Inputs are not valid integers.");
        }
        catch(ArithmeticException e){
            System.out.println("Error: Cannot be divided by zero");
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Result: "+parseAndDivide("10","2"));
        System.out.println("Result: "+parseAndDivide("8","0"));
        System.out.println("Result: "+parseAndDivide("abc","5"));
        System.out.println();
        Scanner input = new Scanner(System.in);
        String ans;
        do {
            System.out.println("Enter a value: ");
            String x = input.nextLine();
            System.out.println("Enter a value to divide with: ");
            String y = input.nextLine();
            System.out.println("Result: "+parseAndDivide(x,y));
            System.out.println("Do you want to rerun the program? (Y/N)");
            ans = input.nextLine();
        }while (ans.equalsIgnoreCase("Y"));

    }
}
