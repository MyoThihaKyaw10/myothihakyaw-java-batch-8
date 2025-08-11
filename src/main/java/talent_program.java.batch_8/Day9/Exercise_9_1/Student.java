package Day9.Exercise_9_1;

import java.util.*;

class Student {
    private String name;
    private List<Double> grades = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0;
        for (double g : grades) {
            sum += g;
        }
        return sum / grades.size();
    }

    @Override
    public String toString() {
        return String.format("%s | Grades: %s | Average: %.2f",
                name, grades.toString(), getAverageGrade());
    }
}