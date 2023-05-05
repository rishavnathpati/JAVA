package RandomScripts;
public class Telephone {
    public static void main(String[] args) {
        String number = "(555)555-5555";
        String[] tokens = number.split("[( ) -]");        String areaCode = tokens[0];
        String phoneNumber = tokens[1] + tokens[2];
        System.out.println("Area code: " + areaCode);
        System.out.println("Phone number: " + phoneNumber);
    }
}