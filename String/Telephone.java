// Write  an  application  that  inputs  a  telephone  number  as  a  string  in  the  form  (555) 555-5555.  The 
// application  should  String  method  split  to  extract  the  area  code  as  a  token,  the  first  three  digits  of  the 
// phone  number  as  a  token  and  the  last  four  digits  of  the  phone  number  as  a  token.  The  seven  digits  of 
// the phone number should be concatenated into  one string. Both the area code and the phone number 
// should  be  printed.  Remember  that  you’ll  have  to  change  delimiter  characters  during  the  tokenization 
// process. 

import java.util.Scanner;

public class Telephone {

    public static void main(String[] args) {
        System.out.println("Enter a telephone number in the form (555) 555-5555");
        Scanner scanner = new Scanner(System.in);
        String telephoneNumber = scanner.nextLine();
        scanner.close();

        String[] tokens = telephoneNumber.split("[() -]");
        String areaCode = tokens[1];
        String phoneNumber = tokens[2] + tokens[3];
        System.out.println("Area code: " + areaCode);
        System.out.println("Phone number: " + phoneNumber);

    }
}
