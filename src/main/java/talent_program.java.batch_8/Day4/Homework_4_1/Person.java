package Day4.Homework_4_1;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void introduce(){
        System.out.println("Hello, my name is "+name+". I am "+age+" years old.");
    }

    public String getRole(){
        return "Person";
    }
}
