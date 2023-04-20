// Write an application that inputs a telephone number as a string in the form (555) 555-5555. The
// application should String method split to extract the area code as a token, the first three digits of the
// phone number as a token and the last four digits of the phone number as a token. The seven digits of
// the phone number should be concatenated into one string. Both the area code and the phone number
// should be printed. Remember that you’ll have to change delimiter characters during the tokenization
// process.

public class Telephone {
    public static void main(String[] args) {
        String number = "(123)456-7891";
        String areaCode = number.substring(1, 3 + 1);
        String rem = number.substring(5,number.length());
        String tokens[] = rem.split("-");
        String phoneNumber = tokens[0] + tokens[1];
        System.out.println("Area code: " + areaCode);
        System.out.println("Phone number: " + phoneNumber);
    }
}