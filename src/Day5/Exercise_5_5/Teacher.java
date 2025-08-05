package Day5.Exercise_5_5;

class Teacher extends Person implements Workable{
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void teach() {
        System.out.println(name + " is teaching " + subject + ".");
    }

    @Override
    void displayInfo() {
        System.out.println("Teacher Info: " + name + ", Age: " + age + ", Subject: " + subject);
    }

    @Override
    public void doWork() {
        System.out.println(name + " is preparing lessons and grading assignments.");
    }
}
