package Day7.Exercise_7_3;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashSet<String> guests = new HashSet<>();

        guests.add("Alice");
        guests.add("Bob");
        guests.add("Charlie");
        guests.add("Ali");
        guests.add("David");
        guests.add("Emma");
        guests.add("Alice");
        guests.add("Ali");

        System.out.println("Guest List: ");
        for (String guest : guests) {
            System.out.println(guest);
        }

        String checkGuest = "Ali";
        if (guests.contains(checkGuest)) {
            System.out.println("\n" + checkGuest + " is on the guest list.");
        } else {
            System.out.println("\n" + checkGuest + " is NOT on the guest list.");
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter guest name to remove: ");
        String removeName = sc.nextLine();

        if (guests.remove(removeName)) {
            System.out.println(removeName + " has been removed from the list.");
        } else {
            System.out.println(removeName + " is not on the list.");
        }

        System.out.println("\nUpdated guest list:");
        for (String guest : guests) {
            System.out.println(guest);
        }
        System.out.println("\nTotal number of guests: " + guests.size());
    }
}
