package Day6.Exercise_6_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadGrades {
    public static void main(String[] args) {
        try{
            File file = new File("E:\\MTHK\\ACEPLUS\\JAVA\\grades.txt");
            Scanner reader = new Scanner(file);
            System.out.println("Student Grades: ");
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] parts = line.split(",");
                if(parts.length == 2){
                    String name = parts[0].trim();
                    String score = parts[1].trim();
                    System.out.println("Name:"+name+"  Score:"+score);
                }
            }
            reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File is not found.");
        }
    }
}
