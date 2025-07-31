import java.util.Scanner;

public class Multiplication3_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter 1st number: ");
        int x = input.nextInt();
        System.out.println("Please enter 2nd number: ");
        int y = input.nextInt();
        System.out.println("Multiplication is "+multiply(x,y));
        System.out.println("Do you want to multiply another number? (Yes/No)");
        input.nextLine();
        String ans = input.nextLine();
        if(ans.equalsIgnoreCase("Yes")){
            System.out.println("Please enter 3rd number: ");
            int z = input.nextInt();
            System.out.println("Multiplication is "+multiply(x,y,z));
        }
        input.close();
    }
    public static int multiply(int x, int y){
        int multiplication = x * y;
        return multiplication;
    }
    public static int multiply(int x, int y, int z){
        int multiplication = x * y * z;
        return multiplication;
    }

}
