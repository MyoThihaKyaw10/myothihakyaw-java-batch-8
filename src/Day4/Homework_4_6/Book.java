package Day4.Homework_4_6;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void displayBook(){
        System.out.println("Title: "+title+"   Author: "+author+"   Price: "+price+"MMK");
    }

    public void applyDiscount(double percentage){
        if (percentage > 0 && percentage <= 100) {
            double discountAmount = price * (percentage / 100);
            price -= discountAmount;
            System.out.println("Discount of " + percentage + "% applied to \"" + title + "\".");
        } else {
            System.out.println("Invalid discount percentage.");
        }
    }
}
