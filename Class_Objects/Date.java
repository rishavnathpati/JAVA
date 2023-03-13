// Create a class called Date that includes three instance variables—a month (type int), a day (type int)
// and a year (type int). Provide a constructor that initializes the three instance variables and assumes that
// the  values  provided  are  correct.  Provide  a  set  and  a  get  method  for  each  instance  variable.  Provide  a
// method displayDate that displays the month, day and year separated by forward slashes (/). Write a test
// app named DateTest that demonstrates class Date’s capabilities

public class Date {

    private int month;
    private int day;
    private int year;

    public Date(int day, int month, int year) throws IllegalArgumentException {
        this.day = day;
        // Check that the month is between 1 and 12, if not throw an exception and
        // continue with the program
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else {
            throw new IllegalArgumentException("Month must be between 1 and 12");
        }
        this.year = year;
    }

    public Date() {
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else {
            throw new IllegalArgumentException("Month must be between 1 and 12");
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void displayDate() {
        System.out.printf("Date is: " + "%d/%d/%d\n", this.day, this.month, this.year);
    }
}
