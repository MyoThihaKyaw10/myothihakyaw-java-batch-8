package Day6.Exercise_6_0;

import java.io.File;
import java.io.IOException;

public class CreateFiles {
    public void createFiles() {
        try{
            File myObj = new File("E:\\MTHK\\ACEPLUS\\JAVA\\Day6Exercise.txt");
            if(myObj.createNewFile()){
                System.out.println("File created: "+myObj.getName());
            }
            else{
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occured.");
        }
    }
}
