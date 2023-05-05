// Develop a class called Student containing registration number, name and total credits registered by a student. Define the
// set and get method and a zero argument constructor for the class. Read students’ information through keyboard. Develop a
// user-defined exception called CreditsOutOfRange to throw exception whenever the total number of credits registered by a
// student is either less than 16 or greater than 24 and an exception called NameCaseException should also be thrown if the
// name of a student is not entered in uppercase letters and an exception called InvalidRegistrationNumber if either the
// registration number does not start with 22MCA or the registration number has less than nine characters. Show the usage of
// these custom exceptions in try-catch-finally blocks inside a driver class.
package RandomScripts;
import java.util.Scanner;

class Student {
    private String regNo;
    private String name;
    private int credits;

    public Student() {
        this.regNo = null;
        this.name = null;
        this.credits = 0;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) throws InvalidRegistrationNumber {
        if (regNo.length() < 9 || !regNo.startsWith("22MCA")) {
            throw new InvalidRegistrationNumber("Registration number is invalid");
        }
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NameCaseException {
        if (!name.equals(name.toUpperCase())) {
            throw new NameCaseException("Name should be in upper case");
        }
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) throws CreditsOutOfRange {
        if (credits < 16 && credits > 24) {
            throw new CreditsOutOfRange("Credits value should be between 16 and 24");
        }
        this.credits = credits;
    }

    public String toString() {
        return "Student details: [Reg. No.: " + getRegNo() + " Name: " + getName() + " Credits: " + getCredits() + "]";
    }
}

class CreditsOutOfRange extends Exception {
    public CreditsOutOfRange(String message) {
        super(message);
    }

    public CreditsOutOfRange() {
        super("Default CreditsOutOfRange range");
    }

    @Override
    public String toString() {
        return "CreditsOutOfRange [from toString()] " + getMessage();
    }
}

class NameCaseException extends Exception {
    public NameCaseException(String message) {
        super(message);
    }

    public NameCaseException() {
        super("Default NameCaseException error");
    }

    @Override
    public String toString() {
        return "NameCaseException [from toString()] " + getMessage();
    }
}

class InvalidRegistrationNumber extends Exception {
    public InvalidRegistrationNumber(String message) {
        super(message);
    }

    public InvalidRegistrationNumber() {
        super("Default InvalidRegistrationNumber error");
    }

    @Override
    public String toString() {
        return "InvalidRegistrationNumber [from toString()] " + getMessage();
    }
}

public class Credits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();
        try {
            System.out.println("Enter registration number: ");
            String regNo = sc.next();
            s.setRegNo(regNo);

            System.out.println("Enter name: ");
            sc.nextLine();
            String name = sc.nextLine();
            s.setName(name);

            System.out.println("Enter credits: ");
            int credits = sc.nextInt();
            s.setCredits(credits);

            System.out.println(s);
        } catch (InvalidRegistrationNumber | NameCaseException | CreditsOutOfRange e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
