package Day1;

import java.util.Scanner;

public class MySquareBlock {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a character:");
        String cha = input.nextLine();
        System.out.println("Enter the number of lines to print:");
        int num = input.nextInt();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(cha);
            }
            System.out.println();
        }
        input.close();
    }
}
