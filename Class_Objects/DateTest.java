import java.util.Scanner;

public class DateTest {

    public static void main(String args[]) {
        System.out.print("\033[H\033[2J");

        // Creating a new date object using the constructor and displaying it
        Date date = new Date(12, 2, 2016);
        date.displayDate();
        System.out.println();

        // Showing that the date can be changed by taking input from the user
        System.out.println("Enter a new date: ");
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a new day: ");
        date.setDay(input.nextInt());
        System.out.print("Enter a new month: ");
        date.setMonth(input.nextInt());
        System.out.print("Enter a new year: ");
        date.setYear(input.nextInt());

        date.displayDate();
        System.out.println();

        // Creating a second date object using the default constructor and displaying it
        Date date2 = new Date();

        date2.setDay(6);
        date2.setMonth(10);
        date2.setYear(2016);

        System.out.println(
                "Date 2 is: \nDay: " + date2.getDay() + " Month: " + date2.getMonth() + " Year: " + date2.getYear());

        input.close();

    }
}