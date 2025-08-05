package Day6.Exercise_6_0;

import java.io.File;

public class DeleteFiles {
    public void deleteFiles() {
        File myObj = new File("E:\\MTHK\\ACEPLUS\\JAVA\\Day6Exercise.txt");
        if(myObj.delete()){
            System.out.println("Deleted the file: "+myObj.getName());
        }
        else{
            System.out.println("Failed to delete the file.");
        }
    }
}
