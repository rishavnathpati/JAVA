package Threads;

public class StudentGrades implements Runnable {

    private String name;
    private int paper1Marks;
    private int paper2Marks;
    private String grade;
    private double gpa;

    public StudentGrades(String name, int paper1Marks, int paper2Marks) {
        this.name = name;
        this.paper1Marks = paper1Marks;
        this.paper2Marks = paper2Marks;
    }

    public void run() {
        // Assign grade based on paper marks
        int totalMarks = paper1Marks + paper2Marks;
        if (totalMarks >= 80 && totalMarks <= 100) {
            grade = "A";
            gpa = 10.0;
        } else if (totalMarks >= 60 && totalMarks < 80) {
            grade = "B";
            gpa = 8.0;
        } else {
            grade = "C";
            gpa = 0.0;
        }

        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Compute cumulative GPA
        if (gpa > 0) {
            gpa = (gpa + 8.0) / 2.0;
        }
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public double getGPA() {
        return gpa;
    }

    // toString() method is used to return the string representation of an object.

    @Override
    public String toString() {
        return "StudentGrades :" +
                "name='" + name + '\'' +
                ", paper1Marks=" + paper1Marks +
                ", paper2Marks=" + paper2Marks +
                ", grade='" + grade + '\'' +
                ", gpa=" + gpa +
                ' ';
    }

    public static void main(String[] args) {
        // Create fixed number of students
        int numStudents = 5;
        StudentGrades[] students = new StudentGrades[numStudents];

        // Initialize student objects with random marks
        for (int i = 0; i < numStudents; i++) {
            students[i] = new StudentGrades("Student " + (i + 1), (int) (Math.random() * 100),
                    (int) (Math.random() * 100));

            System.out.println(students[i]);
        }

        // Create and start threads
        Thread assignGradesThread = new Thread(() -> {
            for (int i = 0; i < numStudents; i++) {
                students[i].run();
            }
        });
        assignGradesThread.start();

        new Thread(() -> {
            try {
                // Wait for assignGradesThread to finish
                assignGradesThread.join();

                // Display student name and grade
                for (int i = 0; i < numStudents; i++) {
                    System.out.println(students[i].getName() + " - " + students[i].getGrade());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
