package Day6.Exercise_6_0;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public void writeFiles() {
        try{
            FileWriter myWriter = new FileWriter("E:\\MTHK\\ACEPLUS\\JAVA\\Day6Exercise.txt");
            myWriter.write("Files in Java might be tricky, but fun enough.");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            ReadFiles reader = new ReadFiles();
            System.out.print("Written text in the file: ");
            reader.readFiles();
        }
        catch (IOException e){
            System.out.println("An error occured.");
        }
    }
}
