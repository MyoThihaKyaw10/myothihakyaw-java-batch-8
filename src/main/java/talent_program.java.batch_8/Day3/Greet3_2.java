package Day3;

import java.util.Scanner;

public class Greet3_2 {
    public static void main(String[] args) {
        greet();
        System.out.println("Enter the name: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        greet(name);

    }
    public static void greet(){
        System.out.println("Hello!");
    }
    public static void greet(String name){
        System.out.println("Hello, " + name + "!");
    }
}
