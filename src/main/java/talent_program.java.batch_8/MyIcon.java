import java.util.Scanner;

public class MyIcon {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a symbol:");
        String symbol = input.nextLine();
        System.out.println("Enter a number:");
        int num = input.nextInt();
        for(int i = 0; i < num; i++){
            System.out.print(symbol);
        }
        input.close();
    }
}
