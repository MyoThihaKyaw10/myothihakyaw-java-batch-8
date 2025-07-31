import java.util.Scanner;

public class ReverseString3_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a text: ");
        String text = input.nextLine();
        String output = reverseString(text);
        System.out.println("Reversed version: "+output);

    }
    public static String reverseString(String text){
        String reversed="";
        for(int i = text.length() - 1; i >= 0; i--){
            reversed += text.charAt(i);
        }
        return reversed;
    }
}
