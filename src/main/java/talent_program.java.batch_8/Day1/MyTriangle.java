package Day1;

public class MyTriangle {
    public static void main(String[] args) {
        int level = 5;
        System.out.println();
        for (int i = 1; i <= level; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
