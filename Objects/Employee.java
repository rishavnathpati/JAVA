// Create a class called Employee that includes three instance variables—a first name (type String), a last 
// name  (type  String)  and  a  monthly  salary  (double).  Provide  a  constructor  that  initializes  the  three 
// instance variables. Provide a set and a get method for each instance variable. If the monthly salary is not 
// positive, do not set its value. Write a test app named EmployeeTest that demonstrates class Employee’s 
// capabilities.  Create  two  Employee  objects  and  display  each  object’s  yearly  salary.  Then  give  each 
// Employee a 10% raise and display each Employee’s yearly salary again.

public class Employee {
    private String firstName;
    private String lastName;
    private double monthlySalary;

    public Employee(String firstName, String lastName, double monthlySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthlySalary = monthlySalary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double computeYearlySalary() {
        return this.monthlySalary * 12;
    }

    public double computeYearlySalaryWithRaise() {
        return (this.monthlySalary * 12) * 1.1;
    }

    public static void main(String args[]) {
        System.out.print("\033[H\033[2J");

        Employee employee1 = new Employee("John", "Doe", 1000);
        Employee employee2 = new Employee("Jane", "Doe", 2000);

        System.out.printf("Employee 1's yearly salary is: %.2f\n", employee1.computeYearlySalary());
        System.out.printf("Employee 2's yearly salary is: %.2f\n", employee2.computeYearlySalary());
    }
    
}
