package Day4.Homework_4_1;

public class Main {
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Person("Alice", 40);
        people[1] = new Student("Bob", 16, 10);
        people[2] = new Teacher("Mr. Smith", 35, "Mathematics");

        for (Person p : people) {
            p.introduce();
            System.out.println("Role: " + p.getRole());
            System.out.println();
        }

        // Example: using setters
        Student student = (Student) people[1];
        student.setGradeLevel(11); // Changing grade
        System.out.println(student.getName() + " is now in grade " + student.getGradeLevel());
    }
}
