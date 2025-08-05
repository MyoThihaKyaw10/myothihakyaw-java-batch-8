package Day5.Exercise_5_1;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4,6);

        System.out.println("Area of circle: "+circle.calculateArea());
        System.out.println("Area of rectangle: "+rectangle.calculateArea());
    }
}
