package Day7.Exercise_7_4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> studentMarks = new HashMap<>();

        studentMarks.put("Alice", 85);
        studentMarks.put("Bob", 92);
        studentMarks.put("Charlie", 78);
        studentMarks.put("David", 90);
        studentMarks.put("Emma", 95);

        System.out.println("All students and their marks:");

        Iterator<Map.Entry<String, Integer>> iterator = studentMarks.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("Name: " + entry.getKey() + ", Marks: " + entry.getValue());
        }

        String topStudent = "";
        int highestMarks = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : studentMarks.entrySet()) {
            if (entry.getValue() > highestMarks) {
                highestMarks = entry.getValue();
                topStudent = entry.getKey();
            }
        }
        System.out.println("\nTop Student: " + topStudent + " with " + highestMarks + " marks.");

        String removeStudent = "Charlie";
        studentMarks.remove(removeStudent);
        System.out.println("\nRemoved student: " + removeStudent);

        System.out.println("\nUpdated student list:");
        for (Map.Entry<String, Integer> entry : studentMarks.entrySet()) {
            System.out.println("Name: " + entry.getKey() + ", Marks: " + entry.getValue());
        }
    }
}
