// Write an application involving switch-case-default that performs one of the following actions: 
// (i) reads a line of text and outputs the text twice— once in all uppercase letters and once in all lowercase 
// letters; 
// (ii) reads a line of text and a search character and uses String method indexOf to determine the number 
// of occurrences of the character in the text; 
// (iii)  reads  a  line  of  text,  tokenizes  the  line  using  space  characters  as  delimiters  and  outputs  only  those 
// words beginning with the letter "b"; 
// (iv)  reads  a line  of  text,  tokenizes  it  using  space  characters  as  delimiters  and  outputs  only  those  words 
// ending with the letters "ED". 
// (v)  reads  a  line  of  text,  tokenizes  the  line  with  String  method  split  and  outputs  the  tokens  in  reverse 
// order. Use space characters as delimiters.
package String;

public class StringSwitchCase {
    public static void main(String[] args) {
        // Clear the console
        System.out.print("\033[H\033[2J");

        System.out.println("Enter a line of text: ");
        String line = System.console().readLine();
        System.out.println("\n");

        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.println(
                    "Enter 1: Output the text twice — once in all uppercase letters and once in all lowercase letters");
            System.out.println("Enter 2: Output the number of occurrences of the character in the text");
            System.out.println("Enter 3: Output only those words beginning with the letter \"b\"");
            System.out.println("Enter 4: Output only those words ending with the letters \"ED\"");
            System.out.println("Enter 5: Output the tokens in reverse order");
            System.out.println("Enter 0: Exit");
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(System.console().readLine());

            // switch-case-default
            switch (choice) {
                case 1:
                    System.out.println("Uppercase: " + line.toUpperCase());
                    System.out.println("Lowercase: " + line.toLowerCase());
                    System.console().readLine();
                    break;

                case 2:
                    System.out.println("Enter a search character: ");
                    char searchChar = System.console().readLine().charAt(0);
                    int count = 0;
                    // Use String method indexOf to determine the number of occurrences of the
                    // character in the text
                    int startIndexOf = 0;
                    for (int i = 0; i < line.length(); i++) {
                        if (line.indexOf(searchChar, startIndexOf) != -1) {
                            count++;
                            startIndexOf = line.indexOf(searchChar, startIndexOf) + 1;
                        }
                    }
                    System.out.println("The number of occurrences of the character in the text: " + count);
                    System.console().readLine();
                    break;

                case 3:
                    // Output only those words beginning with the letter "b"
                    String[] words = line.split(" ");
                    for (String word : words) {
                        if (word.charAt(0) == 'b') {
                            System.out.println(word);
                        }
                        if(word.startsWith("B")) {
                            System.out.println(word);
                        }
                    }
                    System.console().readLine();
                    break;

                case 4:
                    words = line.split(" ");
                    for (String word : words) {
                        if (word.endsWith("ed") || word.endsWith("ED")) {
                            System.out.println(word);
                        }
                    }
                    System.console().readLine();
                    break;

                case 5:
                    words = line.split(" ");
                    for (int i = words.length - 1; i >= 0; i--) {
                        System.out.print(words[i] + " ");
                    }
                    System.console().readLine();
                    break;

                case 0:
                    System.out.println("Exit");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice");
                    System.console().readLine();
                    break;
            }
        }
    }
}
