package Day4.Homework_4_2;

public class Lion extends Animal{
    public Lion(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(getName()+" roars.");
    }

    @Override
    public void feed() {
        System.out.println(getName()+" eats meat.");
    }
}
