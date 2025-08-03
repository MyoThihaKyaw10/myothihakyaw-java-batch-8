package Day4.Homework_4_2;

import java.util.ArrayList;

public class Zoo {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Lion("Simba",5));
        animals.add(new Elephant("Momo",10));

        for(Animal a : animals){
            a.displayInfo();
            a.makeSound();
            a.feed();
            System.out.println();
        }
    }
}
