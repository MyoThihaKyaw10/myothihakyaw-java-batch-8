package Day2;

import java.util.Scanner;

public class ATM2_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an initial balance:");
        double  balance = input.nextDouble();
        int menu;
        do {
            System.out.println("Menu");
            System.out.println("********************");
            System.out.println("1. Deposit money");
            System.out.println("2. Withdraw money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("Please enter a number to choose menu:");
            menu = input.nextInt();

            switch (menu){
                case 1:
                    System.out.println("Deposit money");
                    System.out.println("Enter the amount you want to deposit:");
                    double deposit = input.nextDouble();
                    balance = balance + deposit;
                    System.out.println("You have successfully deposited "+deposit+" into your account.");
                    System.out.println("Your balance is "+ balance);
                    break;
                case 2:
                    System.out.println("Withdraw money");
                    System.out.println("Enter the amount you want to withdraw:");
                    double withdraw = input.nextDouble();
                    if (balance < withdraw){
                        System.out.println("You have insufficient balance. Please try again.");
                    }
                    else{
                        balance = balance - withdraw;
                        System.out.println("You have successfully withdraw "+withdraw+" from your account.");
                        System.out.println("Your balance is "+ balance);
                    }
                    break;
                case 3:
                    System.out.println("Check Balance");
                    System.out.println("Your balance is "+balance);
                    break;
            }
        } while (menu != 4);
        input.close();
    }
}
