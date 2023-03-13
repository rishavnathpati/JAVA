// A parking garage charges a $2.00 minimum fee to park for up to three hours. The garage charges an 
// additional  $0.50  per  hour  for  each  hour or part  thereof  in  excess  of  three  hours.  The  maximum  charge 
// for  any  given  24-hour  period  is  $10.00.  Assume  that  no  car  parks  for  longer  than  24  hours  at  a  time. 
// Write  an  application  that  calculates  and  displays  the parking  charges  for each  customer  who  parked  in 
// the garage yesterday. You should enter the hours parked for each customer. The program should display 
// the  charge  for  the  current  customer  and  should  calculate  and  display  the  running  total  of  yesterday’s 
// receipts. It should use the method calculateCharges to determine the charge for each customer. 

import java.util.Scanner;

public class ParkingGarage {
    private static final double MIN_FEE = 2.00;
    private static final double HOURLY_RATE = 0.50;
    private static final double MAX_DAILY_CHARGE = 10.00;

    public static void main(String[] args) {
        double totalCharges = 0.0;
        Scanner sc = new Scanner(System.in);

        // Get number of customers and hours parked for each customer
        System.out.print("Enter the number of customers: ");
        int numCustomers = sc.nextInt();
        for (int i = 1; i <= numCustomers; i++) {
            System.out.printf("Enter the number of hours parked for customer %d: ", i);
            int hours = sc.nextInt();

            // Calculate and display the charge for the current customer
            double charge = calculateCharges(hours);
            System.out.printf("Customer %d's charge is $%.2f\n", i, charge);

            // Update the total charges for yesterday
            totalCharges += charge;
        }

        // Display the total charges for yesterday
        System.out.printf("Yesterday's total receipts: $%.2f\n", totalCharges);
        sc.close();
    }

    // Calculate parking charge based on hours parked
    private static double calculateCharges(int hours) {
        double charge = MIN_FEE;
        if (hours > 3) {
            charge += (hours - 3) * HOURLY_RATE;
        }
        if (charge > MAX_DAILY_CHARGE) {
            charge = MAX_DAILY_CHARGE;
        }
        return charge;
    }

}
