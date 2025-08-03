package Day4.Homework_4_2;

public class Elephant extends Animal{
    public Elephant(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(getName()+" trumpets.");
    }

    @Override
    public void feed() {
        System.out.println(getName()+" eats sugar cane.");
    }
}
