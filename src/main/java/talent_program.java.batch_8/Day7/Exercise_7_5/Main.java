package Day7.Exercise_7_5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> students = new ArrayList<>();

        Map<String, Set<String>> studentSubjects;
        studentSubjects = new HashMap<>();

        students.add("Alice");
        students.add("Bob");
        students.add("Charlie");

        Set<String> aliceSubjects = new HashSet<>();
        aliceSubjects.add("Math");
        aliceSubjects.add("English");
        aliceSubjects.add("Science");
        studentSubjects.put("Alice", aliceSubjects);

        Set<String> bobSubjects = new HashSet<>();
        bobSubjects.add("Math");
        bobSubjects.add("History");
        bobSubjects.add("Geography");
        bobSubjects.add("English");
        studentSubjects.put("Bob", bobSubjects);

        Set<String> charlieSubjects = new HashSet<>();
        charlieSubjects.add("Science");
        charlieSubjects.add("Math");
        charlieSubjects.add("Art");
        studentSubjects.put("Charlie", charlieSubjects);

        System.out.println("Students and their subjects:");
        for (String student : students) {
            System.out.println(student + " -> " + studentSubjects.get(student));
        }

        studentSubjects.get("Alice").add("Computer");
        System.out.println("\nAdded 'Computer' subject to Alice.");

        studentSubjects.get("Bob").remove("History");
        System.out.println("Removed 'History' subject from Bob.");

        System.out.println("\nUpdated student list:");
        for (String student : students) {
            System.out.println(student + " -> " + studentSubjects.get(student));
        }

        Set<String> allSubjects = new HashSet<>();
        for (Set<String> subjects : studentSubjects.values()) {
            allSubjects.addAll(subjects);
        }

        System.out.println("\nAll unique subjects offered in the department:");
        System.out.println(allSubjects);
    }
    }

