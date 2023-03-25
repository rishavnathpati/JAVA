import java.util.Scanner;

// Write an application that encodes English-language phrases into pig Latin. Pig Latin is a form of coded 
// language.  There  are  many  different  ways  to  form  pig  Latin  phrases.  For  simplicity,  use  the  following 
// algorithm: 
// To form a pig Latin phrase from an English-language phrase, tokenize the phrase into words with String 
// method  split.  To  translate  each  English  word  into  a  pig  Latin  word,  place  the  first  letter  of  the  English 
// word  at  the  end  of  the  word  and  add  the  letters  “ay.”  Thus,  the  word  “jump”  becomes  “umpjay,”  the 
// word “the” becomes “hetay,” and the word “computer” becomes “omputercay.” 
// Blanks  between  words  remain  as  blanks.  Assume  the  following:  The  English  phrase  consists  of  words 
// separated by blanks, there are no punctuation marks and all words have two or more letters. 
// Method  printLatinWord  should  display  each  word.  Each  token  is  passed  to  method  printLatinWord  to 
// print  the  pig  Latin  word.  Enable  the  user  to  input  the  sentence.  Keep  a  running  display  of  all  the 
// converted sentences in a text area

public class PigLatin {
    public static void main(String[] args) {
        // Take input with scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an English phrase to be converted to Pig Latin");
        String englishPhrase = scanner.nextLine();
        scanner.close();

        String[] words = englishPhrase.split(" ");
        String pigLatinPhrase = "";
        for (String word : words) {
            pigLatinPhrase += printLatinWord(word) + " ";
        }
        System.out.println(pigLatinPhrase);
    }

    public static String printLatinWord(String word) {
        return word.substring(1) + word.charAt(0) + "ay";
    }

}
