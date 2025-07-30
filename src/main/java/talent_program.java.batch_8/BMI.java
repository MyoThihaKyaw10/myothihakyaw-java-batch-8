import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your weight in kilograms:");
        double weight = input.nextDouble();
        System.out.println("Enter your height in meters:");
        double height = input.nextDouble();
        double BMI = weight / (height * height);
        double roundedBMI = (int)(BMI * 10 + 0.5) / 10.0;
        System.out.println("Your BMI is "+ roundedBMI);
        if(roundedBMI < 18.5){
            System.out.println("Category: Underweight");
        }
        else if (roundedBMI >= 18.5 && roundedBMI < 25) {
            System.out.println("Category: Normal weight");
        }
        else if (roundedBMI >= 25 && roundedBMI < 30) {
            System.out.println("Category: Overweight");
        }
        else if (roundedBMI >= 30) {
            System.out.println("Category: Obese");
        }
    }
}
