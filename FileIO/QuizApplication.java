// You are developing a quiz application. 
// The application should allow users to take a quiz by presenting them with questions and validating their answers. 
// The questions and corresponding answers are stored in a text file.
// Implement the functionality to read the file, present the questions to the users, and validate their answers.

// Answer:
package FileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class QuizApplication {
    public static void main(String[] args) {
        String fileName = "FileIO/quiz.txt";
        int score = 0;
        
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] questionAnswer = line.split("\\|");
                String question = questionAnswer[0];
                String answer = questionAnswer[1];
                
                System.out.println(question);
                
                Scanner scanner = new Scanner(System.in);
                String userAnswer = scanner.nextLine();
                
                if (userAnswer.equalsIgnoreCase(answer)) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Incorrect! The correct answer is " + answer);
                }
            }
            
            bufferedReader.close();
            
        } catch (IOException e) {
            System.out.println("Error reading file " + fileName);
        }
        
        System.out.println("Your score is " + score + " out of 5.");
    }
}