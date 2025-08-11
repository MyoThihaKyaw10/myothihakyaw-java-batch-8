package Day9.Exercise_9_1;

import java.util.Scanner;
import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Student Grades Menu ===");
            System.out.println("1. Add Student");
            System.out.println("2. Record Grade for Student");
            System.out.println("3. Calculate Average Grade of a Student");
            System.out.println("4. View Top-Performing Students");
            System.out.println("5. Search Student by Name");
            System.out.println("6. View All Students");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = readInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> recordGrade();
                case 3 -> calculateAverage();
                case 4 -> viewTopPerformers();
                case 5 -> searchStudent();
                case 6 -> viewAllStudents();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        students.add(new Student(name));
        System.out.println("Student added successfully.");
    }

    private static void recordGrade() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        viewAllStudents();
        System.out.print("Enter student number: ");
        int index = readInt() - 1;
        if (index >= 0 && index < students.size()) {
            System.out.print("Enter grade: ");
            double grade = readDouble();
            students.get(index).addGrade(grade);
            System.out.println("Grade recorded.");
        } else {
            System.out.println("Invalid student number.");
        }
    }

    private static void calculateAverage() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        viewAllStudents();
        System.out.print("Enter student number: ");
        int index = readInt() - 1;
        if (index >= 0 && index < students.size()) {
            double avg = students.get(index).getAverageGrade();
            System.out.printf("Average grade for %s: %.2f%n", students.get(index).getName(), avg);
        } else {
            System.out.println("Invalid student number.");
        }
    }

    private static void viewTopPerformers() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        students.stream()
                .sorted(Comparator.comparing(Student::getAverageGrade).reversed())
                .limit(3)
                .forEach(System.out::println);
    }

    private static void searchStudent() {
        System.out.print("Enter name to search: ");
        String search = sc.nextLine().toLowerCase();
        boolean found = false;
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(search)) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with that name.");
        }
    }

    private static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        int i = 1;
        for (Student s : students) {
            System.out.println(i++ + ". " + s);
        }
    }

    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid number, try again: ");
            }
        }
    }

    private static double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid number, try again: ");
            }
        }
    }
}
