import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the marks from 0 to 100 for the following 5 subjects.");
        System.out.println("English: ");
        int sub1 = input.nextInt();
        System.out.println("Maths: ");
        int sub2 = input.nextInt();
        System.out.println("Computer Science: ");
        int sub3 = input.nextInt();
        System.out.println("Science: ");
        int sub4 = input.nextInt();
        System.out.println("History: ");
        int sub5 = input.nextInt();

        int avg = (sub1 + sub2 + sub3 + sub4 + sub5) / 5;
        System.out.println("Your average mark is "+avg);
        if (avg >= 90 && avg <= 100){
            System.out.println("Grade : A");
        }
        else if (avg >= 80 && avg <= 89) {
            System.out.println("Grade : B");
        }
        else if (avg >= 70 && avg <= 79) {
            System.out.println("Grade : C");
        }
        else if (avg >= 60 && avg <= 69) {
            System.out.println("Grade : D");
        }
        else {
            System.out.println("Grade : F");
        }
    }
}
