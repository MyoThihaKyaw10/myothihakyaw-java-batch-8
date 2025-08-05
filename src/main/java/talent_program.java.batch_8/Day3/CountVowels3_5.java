package Day3;

import java.util.Scanner;

public class CountVowels3_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a text: ");
        String text = input.nextLine();
        System.out.println("Vowels in this text are: ");
        int vowels = countVowels(text);
        System.out.println();
        System.out.println("Numbers of vowels in this text is "+vowels);
    }
    public static int countVowels(String text){
        int count = 0;
        String lowercased = text.toLowerCase();
        for(int i=0; i<lowercased.length(); i++){
            char ch = lowercased.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                count++;
                System.out.printf(ch+ ", ");
            }
        }
        return count;
    }
}
