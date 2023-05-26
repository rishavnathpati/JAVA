package FileIO;
// Develop and test a program that asks a user for a file name and prints the number of characters, words, and lines in that file. 
// Develop and test a program CopyFile that copies one file to another. The file names are specified on the command line. 
// For example, java CopyFile report.txt report.txt
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileStats {
    public static void main(String[] args) {
        BufferedReader reader = null;
        int charCount = 0;
        int wordCount = 0;
        int lineCount = 0;

        try {
            // Ask user for file name
            System.out.print("Enter file name: ");
            String fileName = System.console().readLine();

            // Open file for reading
            reader = new BufferedReader(new FileReader(fileName));

            // Read file line by line
            String line;
            while ((line = reader.readLine()) != null) {
                // Count characters
                charCount += line.length();

                // Count words
                String[] words = line.split("\\s+");
                wordCount += words.length;

                // Count lines
                lineCount++;
            }

            // Print file stats
            System.out.println("Number of characters: " + charCount);
            System.out.println("Number of words: " + wordCount);
            System.out.println("Number of lines: " + lineCount);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } finally {
            // Close file
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing file: " + e.getMessage());
            }
        }
    }
}