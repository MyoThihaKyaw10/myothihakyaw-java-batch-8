package Day7.Exercise_7_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(1, "Alice"));
        students.add(new Student(2, "Bob"));
        students.add(new Student(3, "Charlie"));
        students.add(new Student(4, "David"));
        students.add(new Student(5, "Emma"));

        System.out.println("All students: ");
        for(Student s : students){
            s.displayInfo();
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter name to search: ");
        String searchName = sc.nextLine();
        boolean found = false;
        for (Student s : students) {
            if (s.name.equalsIgnoreCase(searchName)) {
                System.out.println("Student found:");
                s.displayInfo();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }

        System.out.print("\nEnter ID to remove: ");
        int removeId = sc.nextInt();
        Student toRemove = null;
        for (Student s : students) {
            if (s.id == removeId) {
                toRemove = s;
                break;
            }
        }
        if (toRemove != null) {
            students.remove(toRemove);
            System.out.println("Student with ID " + removeId + " removed.");
        } else {
            System.out.println("No student found with that ID.");
        }

        System.out.println("\nNumber of students in the list: " + students.size());
    }
}
