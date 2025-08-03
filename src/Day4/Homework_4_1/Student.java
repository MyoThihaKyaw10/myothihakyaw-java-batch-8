package Day4.Homework_4_1;

public class Student extends Person {
    private int gradeLevel;

    public Student(String name, int age, int gradeLevel) {
        super(name, age);
        this.gradeLevel = gradeLevel;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    @Override
    public void introduce() {
        System.out.println("Hi, My name is "+getName()+". I am a "+getAge()+" years old student in grade "+gradeLevel+".");
    }

    @Override
    public String getRole() {
        return "Student";
    }
}
