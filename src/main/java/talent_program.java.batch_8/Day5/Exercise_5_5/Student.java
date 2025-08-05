package Day5.Exercise_5_5;

class Student extends Person{
    private String id;
    private double grade;

    public Student(String name, int age, String id, double grade) {
        super(name, age);
        this.id = id;
        this.grade = grade;
    }

    public void printDetails(){
        System.out.println("Student Details: Name = " + name + ", ID = " + id +
                ", Age = " + age + ", Grade = " + grade);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age value.");
        }
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        if (grade >= 0 && grade <= 100) {
            this.grade = grade;
        } else {
            System.out.println("Invalid grade value.");
        }
    }

    public void study() {
        System.out.println(name + " is studying.");
    }

    public void study(String subject) {
        System.out.println(name + " is studying " + subject + ".");
    }

    @Override
    void displayInfo() {
        System.out.println("Student Info: " + name + ", Age: " + age + ", ID: " + id);
    }
}
