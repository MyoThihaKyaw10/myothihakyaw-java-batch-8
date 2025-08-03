package Day4.Homework_4_6;

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("Flooded The Face","Lil Uzi Vert",20000);
        Book b2 = new Book("My Eyes","Travis Scott",30000);
        Book b3 = new Book("Poland","Lil Yachty",15000);

        System.out.println("Original Book Prices");
        b1.displayBook();
        b2.displayBook();
        b3.displayBook();
        System.out.println();

        b1.applyDiscount(10);
        b3.applyDiscount(20);
        System.out.println();

        System.out.println("After Discount Book Prices");
        b1.displayBook();
        b2.displayBook();
        b3.displayBook();
    }
}
