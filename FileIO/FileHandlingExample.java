package FileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileHandlingExample {
    
    public static void main(String[] args) {
        
        // Create a new file
        File file = new File("example.txt");
        try {
            boolean success = file.createNewFile();
            if (success) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Write some data to the file
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Hello, world!\n");
            writer.write("This is a test.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Read the data from the file
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Error reading from file.");
        }
        
        // Append some data to the file
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write("This is another line.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Use RandomAccessFile to read and write data to the file
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            raf.seek(0);
            String firstLine = raf.readLine();
            System.out.println("First line: " + firstLine);
            raf.seek(raf.length());
            raf.writeBytes("This is the end.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Delete the file
        boolean deleted = file.delete();
        if (deleted) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("Failed to delete file.");
        }
    }
}
