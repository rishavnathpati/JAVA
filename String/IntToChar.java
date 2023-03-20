// Write  an  application  that  inputs  an  integer  code  for  a  character  and  displays  the  corresponding 
// character.  Modify  this  application  so  that  it  generates  all  possible  three-digit  codes  in  the  range  from 
// 000 to 255 and attempts to print the corresponding characters

package String;

public class IntToChar {
    public static void main(String[] args) {
        // Clear the console
        System.out.print("\033[H\033[2J");

        System.out.println("Enter an integer code for a character: ");
        int code = Integer.parseInt(System.console().readLine());
        System.out.println("The corresponding character: " + (char) code);

        // Generate all possible three-digit codes in the range from 000 to 255 and
        // attempts to print the corresponding characters
        for (int i = 0; i < 256; i++) {
            char ch = (char) i;
            if (ch != ' ')
                System.out.println(i + " = " + ch);
        }
    }
}
