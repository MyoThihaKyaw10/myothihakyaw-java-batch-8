package Day3;

import java.util.Scanner;

public class Multi_table3_4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int num = input.nextInt();
        System.out.println("Please enter a number of rows you want to multiply: ");
        int row = input.nextInt();
        printTable(num,row);
    }
    public static void printTable(int num, int row){
        for(int i=1; i <= row; i++){
            int multiply = num * i;
            System.out.println(num + " x " + i + " = "+ multiply);
        }
    }
}
