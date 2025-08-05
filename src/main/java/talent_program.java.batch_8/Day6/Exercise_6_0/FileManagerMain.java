package Day6.Exercise_6_0;

import java.util.Scanner;

public class FileManagerMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CreateFiles create = new CreateFiles();
        WriteFile write = new WriteFile();
        ReadFiles read = new ReadFiles();
        DeleteFiles delete = new DeleteFiles();

        while(true){
            System.out.println("\nChoose an option:");
            System.out.println("1 - Create File");
            System.out.println("2 - Write to File");
            System.out.println("3 - Read File");
            System.out.println("4 - Delete File");
            System.out.println("5 - Exit");
            System.out.print("Enter choice: ");
            int choice = input.nextInt();

            switch (choice){
                case 1:
                    create.createFiles();
                    break;
                case 2:
                    write.writeFiles();
                    break;
                case 3:
                    read.readFiles();
                    break;
                case 4:
                    delete.deleteFiles();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
