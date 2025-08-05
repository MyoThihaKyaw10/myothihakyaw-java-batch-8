package Day5.Exercise_5_5;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Alice", 20, "S001", 85.5);
        student1.printDetails();
        student1.study();
        student1.study("Java");
        student1.displayInfo();

        student1.setGrade(90);
        System.out.println("Updated Grade: " + student1.getGrade());
        System.out.println();

        Teacher teacher1 = new Teacher("Mr. Smith", 40, "Math");
        teacher1.teach();
        teacher1.displayInfo();
        teacher1.doWork();
    }
}
