import java.util.Scanner;

public class DoWhileGrades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String answer;
        do {
            System.out.println("Please enter the number of students: ");
            int studentnum = input.nextInt();
            for (int i = 1; i <= studentnum; i++) {
                System.out.println("Enter grades for student " + i);
                System.out.println("English: ");
                int sub1 = input.nextInt();
                System.out.println("Maths: ");
                int sub2 = input.nextInt();
                System.out.println("Computer Science: ");
                int sub3 = input.nextInt();
                int avg = (sub1 + sub2 + sub3) / 3;
                System.out.println("Average Grade for student " + i + " is " + avg);
            }
            input.nextLine();
            System.out.println("Do you want to continue the program? (Yes/No)");
            answer = input.nextLine();
        }
        while (answer.equalsIgnoreCase("Yes"));
    }
}
