package Day8.Exercise_8_2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);
        intList.add(30);

        Printer<Integer> intPrinter = new Printer<>(intList);
        System.out.println("Printing Integer list:");
        intPrinter.printAll();

        ArrayList<Double> doubleList = new ArrayList<>();
        doubleList.add(1.1);
        doubleList.add(2.2);
        doubleList.add(3.3);

        Printer<Double> doublePrinter = new Printer<>(doubleList);
        System.out.println();
        System.out.println("Printing Double list:");
        doublePrinter.printAll();
    }
}
