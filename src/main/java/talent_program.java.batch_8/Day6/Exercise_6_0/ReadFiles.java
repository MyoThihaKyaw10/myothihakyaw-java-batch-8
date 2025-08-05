package Day6.Exercise_6_0;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFiles {
    public void readFiles() {
        try{
            File myObj = new File("E:\\MTHK\\ACEPLUS\\JAVA\\Day6Exercise.txt");
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("An error occured.");
        }
    }
}
