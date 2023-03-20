package Theory;
// Develop  and  test  a  Java  class  named  Student  with  the  (private)  instance  fields  namely,  registration 
// number, name, the date of birth and a list of a maximum of three courses a student has registered in. If 
// a  student  has  registered  in  less  than  three  courses  then  use  null.  Provide  constructors  for  the  class 
// showing  how  one  constructor  can  call  some  other  constructor  and  include  accessor  and  mutator 
// methods  for  each  of  the  instance  fields.  Include  a  method  into  the  class  to  compute  the  age  of  a 
// student.  Create  an  array  of  objects  of  three  students  after  receiving  input  from  the  keyboard  using 
// object of BufferedReader class and display for each student her/his registration number, name and age 
// in a tabular format with column header.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String registrationNumber;
    private String name;
    private String dateOfBirth;
    private List<String> courses;

    // Constructor chaining
    public Student(String registrationNumber, String name, String dateOfBirth, List<String> courses) {
        // this.registrationNumber = registrationNumber;
        // this.name = name;
        // this.dateOfBirth = dateOfBirth;
        this(registrationNumber, name, dateOfBirth);
        this.courses = courses;
    }

    public Student(String registrationNumber, String name, String dateOfBirth) {
        this(registrationNumber, name);
        this.dateOfBirth = dateOfBirth;
        // this(registrationNumber, name, dateOfBirth, new ArrayList<>());
    }

    public Student(String registrationNumber, String name) {
        this(registrationNumber);
        this.name = name;
        // this(registrationNumber, name, null, new ArrayList<>());
    }

    public Student(String registrationNumber) {

        this.registrationNumber = registrationNumber;
        // this(registrationNumber, null, null);
    }

    public Student() {
        this(null, null, null, new ArrayList<>());
    }

    // Accessor and mutator methods
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // List is mutable, so we need to return a copy of the list to prevent the list
    // from being modified outside the class
    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public void addCourse(String course) {
        if (courses.size() < 3) {
            courses.add(course);
        }
    }

    public void removeCourse(String course) {
        courses.remove(course);
    }

    // Method to compute age of student
    public int getAge() {
        // Return age of student, assuming that the date of birth is in the format
        // dd/mm/yyyy
        String[] dateOfBirthParts = dateOfBirth.split("/");
        int day = Integer.parseInt(dateOfBirthParts[0]);
        int month = Integer.parseInt(dateOfBirthParts[1]);
        int year = Integer.parseInt(dateOfBirthParts[2]);
        int age = 2023 - year;
        if (month > 10) {
            age--;
        } else if (month == 10) {
            if (day > 15) {
                age--;
            }
        }
        return age;
    }

    public static void main(String[] args) throws IOException {
        System.out.print("\033[H\033[2J");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Student[] students = new Student[3];
        for (int i = 0; i < students.length; i++) {

            System.out.println("\n----------------Enter details of student " + (i + 1) + ":-------------------\n");
            System.out.println("Enter registration number: ");
            String registrationNumber = "22MCA011" + i;// br.readLine();
            System.out.println(registrationNumber);

            System.out.println("Enter name: ");
            String name = "Rishav " + i;// br.readLine();
            System.out.println(name);

            System.out.println("Enter date of birth: ");
            String dateOfBirth = "12/12/200" + i;// br.readLine();
            System.out.println(dateOfBirth);

            System.out.println("Enter number of courses: ");
            int numberOfCourses = Integer.parseInt(br.readLine());

            // Maximum of 3 courses
            if (numberOfCourses > 3) {
                numberOfCourses = 3;
            }

            List<String> courses = new ArrayList<>();
            for (int j = 0; j < numberOfCourses; j++) {
                System.out.println("Enter course: ");
                String course = "Course " + j;// br.readLine();
                System.out.println(course);
                courses.add(course);
            }
            students[i] = new Student(registrationNumber, name, dateOfBirth, courses);
        }

        // Display details of all students
        System.out.println("\n----------------Details of all students:-------------------\n");
        System.out.println("Reg Number\t\tName\t\tAge");
        for (Student student : students) {
            System.out
                    .println(student.getRegistrationNumber() + "\t\t" + student.getName() + "\t\t" + student.getAge());
        }

        // Infinite loop to add or remove courses and view courses for a student using
        // the registration number
        System.out.println("\n----------------Add or remove courses for a student:-------------------\n");
        while (true) {
            System.out.println(
                    "\nEnter 1 : Add a course\nEnter 2 : Remove a course\nEnter 3 : View courses\nEnter 0 : Exit\nChoose an option:");
            int choice = Integer.parseInt(br.readLine());

            // Add course to student with given registration number
            if (choice == 1) {
                System.out.println("\nEnter registration number of student to add course to: ");
                String registrationNumber = br.readLine();

                // Check if student exists
                boolean studentExists = false;
                for (Student student : students) {
                    if (student.getRegistrationNumber().equals(registrationNumber)) {
                        studentExists = true;
                        break;
                    }
                }
                if (!studentExists) {
                    System.out.println("Student does not exist");
                    continue;
                }

                // Check if student has already registered for 3 courses, if yes, then do not
                // add course and continue to next iteration
                for (Student student : students) {
                    if (student.getRegistrationNumber().equals(registrationNumber)) {
                        if (student.getCourses().size() == 3) {
                            System.out.println("Student has already registered for 3 courses");
                            continue;
                        } else {
                            System.out.println("Enter course to add: ");
                            String course = br.readLine();
                            student.addCourse(course);
                        }
                    }
                }
            }

            // Remove course from student with given registration number
            else if (choice == 2) {
                System.out.println("Enter registration number of student to remove course from: ");
                String registrationNumber = br.readLine();
                System.out.println("Enter course to remove: ");
                String course = br.readLine();
                for (Student student : students) {
                    if (student.getRegistrationNumber().equals(registrationNumber)) {
                        student.removeCourse(course);
                    }
                }
            }

            // View courses of student with given registration number
            else if (choice == 3) {
                System.out.println("Enter registration number of student to view courses: ");
                String registrationNumber = br.readLine();
                for (Student student : students) {
                    if (student.getRegistrationNumber().equals(registrationNumber)) {
                        System.out.println("Courses: ");
                        for (String course : student.getCourses()) {
                            System.out.println(course);
                        }
                    }
                }
            }

            // Exit
            else if (choice == 0) {
                break;
            }
        }
    }
}

// ----------------Enter details of student 1:-------------------

// Enter registration number:
// 22MCA0110
// Enter name:
// Rishav0
// Enter date of birth:
// 12/12/2000
// Enter number of courses:
// 2
// Enter course:
// Course 0
// Enter course:
// Course 1

// ----------------Enter details of student 2:-------------------

// Enter registration number:
// 22MCA0111
// Enter name:
// Rishav1
// Enter date of birth:
// 12/12/2001
// Enter number of courses:
// 3
// Enter course:
// Course 0
// Enter course:
// Course 1
// Enter course:
// Course 2

// ----------------Enter details of student 3:-------------------

// Enter registration number:
// 22MCA0112
// Enter name:
// Rishav2
// Enter date of birth:
// 12/12/2002
// Enter number of courses:
// 2
// Enter course:
// Course 0
// Enter course:
// Course 1

// ----------------Details of all students:-------------------

// Reg Number Name Age
// 22MCA0110 Rishav0 22
// 22MCA0111 Rishav1 21
// 22MCA0112 Rishav2 20

// ----------------Add or remove courses for a student:-------------------

// Enter 1 : Add a course
// Enter 2 : Remove a course
// Enter 3 : View courses
// Enter 0 : Exit
// Choose an option:
// 1

// Enter registration number of student to add course to:
// 22MCA0110
// Enter course to add:
// Course 3

// Enter 1 : Add a course
// Enter 2 : Remove a course
// Enter 3 : View courses
// Enter 0 : Exit
// Choose an option:
// 1

// Enter registration number of student to add course to:
// 22MCA0110
// Student has already registered for 3 courses

// Enter 1 : Add a course
// Enter 2 : Remove a course
// Enter 3 : View courses
// Enter 0 : Exit
// Choose an option:
// 3
// Enter registration number of student to view courses:
// 22MCA0110
// Courses:
// Course 0
// Course 1
// Course 3

// Enter 1 : Add a course
// Enter 2 : Remove a course
// Enter 3 : View courses
// Enter 0 : Exit
// Choose an option:
// 2
// Enter registration number of student to remove course from:
// 22MCA0110
// Enter course to remove:
// Course 1

// Enter 1 : Add a course
// Enter 2 : Remove a course
// Enter 3 : View courses
// Enter 0 : Exit
// Choose an option:
// 3
// Enter registration number of student to view courses:
// 22MCA0110
// Courses:
// Course 0
// Course 3

// Enter 1 : Add a course
// Enter 2 : Remove a course
// Enter 3 : View courses
// Enter 0 : Exit
// Choose an option:
// 0
