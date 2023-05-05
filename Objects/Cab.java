// Create a class called Cab to represent a cab on hire. A cab should include four pieces of information as
// instance variables - a cab registration number (type String), name of the driver (type String), the rate per
// kilometer (type double) and the total distance it covered on hire on a day (type double). The Cab class
// should have a constructor that initializes the four instance variables. Provide a set and a get method for
// each instance variable. In addition, provide a method named computeIncome that calculates the daily
// income based on the total distance that it travelled on hire and returns the daily income as a double
// value. The registration number and driver name must be available and the rate per kilometer and total
// distance cannot be negative. Write a test application named Income that demonstrates creation of an
// array of objects of size three of the Cab class and display the daily income from each cab along with its
// registration number and driver’s name.

import java.util.Scanner;

public class Cab {
    private String cabRegistrationNumber;
    private String driverName;
    private double ratePerKilometer;
    private double totalDistanceCovered;

    public Cab(String cabRegistrationNumber, String driverName, double ratePerKilometer, double totalDistanceCovered) {
        this.cabRegistrationNumber = cabRegistrationNumber;
        this.driverName = driverName;
        this.ratePerKilometer = ratePerKilometer;
        this.totalDistanceCovered = totalDistanceCovered;
    }

    public String getCabRegistrationNumber() {
        return cabRegistrationNumber;
    }

    public void setCabRegistrationNumber(String cabRegistrationNumber) {
        this.cabRegistrationNumber = cabRegistrationNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public double getRatePerKilometer() {
        return ratePerKilometer;
    }

    public void setRatePerKilometer(double ratePerKilometer) {
        this.ratePerKilometer = ratePerKilometer;
    }

    public double getTotalDistanceCovered() {
        return totalDistanceCovered;
    }

    public void setTotalDistanceCovered(double totalDistanceCovered) {
        this.totalDistanceCovered = totalDistanceCovered;
    }

    public double computeIncome() {
        return this.ratePerKilometer * this.totalDistanceCovered;
    }

    public static void main(String args[]) {
        System.out.print("\033[H\033[2J");

        Scanner sc = new Scanner(System.in);
        Cab[] cabs = new Cab[3];
        for (int i = 0; i < cabs.length; i++) {

            System.out.printf("Enter Cab %d registration number: \n", i + 1);
            String cabRegistrationNumber = sc.nextLine();
            System.out.println("Enter driver name: ");
            String driverName = sc.nextLine();
            System.out.println("Enter rate per kilometer: ");
            double ratePerKilometer = sc.nextDouble();
            sc.nextLine();
            System.out.println("Enter total distance covered: ");
            double totalDistanceCovered = sc.nextDouble();
            sc.nextLine();
            cabs[i] = new Cab(cabRegistrationNumber, driverName, ratePerKilometer, totalDistanceCovered);
            System.out.println();
        }
        System.out.print("\033[H\033[2J");
        for (int i = 0; i < cabs.length; i++) {
            System.out.printf("Cab %d registration number: " + cabs[i].getCabRegistrationNumber(), i + 1);
            System.out.println("Driver name: " + cabs[i].getDriverName());
            System.out.println("Daily income: " + cabs[i].computeIncome());
            System.out.println();
        }
        sc.close();
        System.out.flush();
    }
}