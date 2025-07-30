import java.util.Scanner;

public class BMI_v2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your weight in pounds:");
        double weightp = input.nextDouble();

        System.out.println("Enter your height in feet and inches. Feet:");
        double heightf = input.nextDouble();

        System.out.println("Enter your height in feet and inches. Inches:");
        double heighti = input.nextDouble();

        double weightkilo = weightp * 0.45359237;
        double totalheighti = (heightf * 12) + heighti;
        double heightmeter = totalheighti * 0.0254;

        double BMI = weightkilo / (heightmeter * heightmeter);
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
