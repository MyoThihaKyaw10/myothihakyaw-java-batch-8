package Day7.Exercise_7_2;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> waitingList = new LinkedList<>();

        waitingList.add("Alice");
        waitingList.add("Bob");
        waitingList.add("Charlie");
        waitingList.add("David");
        waitingList.add("Emma");

        System.out.println("Initial waiting list:");
        for (String name : waitingList) {
            System.out.println(name);
        }

        String servedPerson = waitingList.pollFirst();
        System.out.println("\nPerson served: " + servedPerson);

        waitingList.add("Frank");

        System.out.println("\nUpdated waiting list:");
        for (String name : waitingList) {
            System.out.println(name);
        }

        System.out.println("\nNumber of people waiting: " + waitingList.size());
    }
}
