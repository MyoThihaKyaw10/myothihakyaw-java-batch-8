package Day8.Exercise_8_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("10", "20", "abc", "30", "xyz", "40");

        List<Integer> numbers = new ArrayList<>();

        for (String str : input) {
            try {
                int num = Integer.parseInt(str);
                numbers.add(num);
                System.out.println("Valid input added: "+str);
            } catch (NumberFormatException e) {
                System.out.println("Skipping invalid input: " + str);
            }
        }

        if (numbers.isEmpty()) {
            System.out.println("No valid integers to process.");
            return;
        }

        int sum = 0;
        int min = Collections.min(numbers);
        int max = Collections.max(numbers);

        for (int num : numbers) {
            sum += num;
        }

        double average = (double) sum / numbers.size();
        System.out.println();
        System.out.println("Valid integers: " + numbers);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }
}
