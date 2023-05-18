package RandomScripts;

/*
 * Develop a multithread program with two threads one of which should assign grade depending on marks secured in two papers
 * by a student followed the rules: 100-80 Grade A and 80-60 Grade B.
 * The thread should also compute the grade point average using 10 for Grade A and 8 from Grade B. 
 * The other thread should display the name of the student his/her grade.
 * The latter thread should wait until the first thread has finished generating the grades and computing the cummulative grade point
 * average for a student. Show execution of threads in a loop of a fixed number of iterations.
 */

class Student {
    private double marks1, marks2;
    private char[] grade = new char[2];
    private int val;
    private String name;
    boolean value = false;

    Student(String name, double marks1, double marks2) {
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.name = name;
        grade[0] = 'F';
        grade[1] = 'F';
        val = 0;

    }

    synchronized void calculateGrade() {
        while (value) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Hi");
            }
            if (marks1 >= 80 && marks1 <= 100) {
                grade[0] = 'A';
                val += 10;
            } else if (marks2 >= 60 && marks2 < 80) {
                grade[1] = 'B';
                val += 8;
            }
            value = true;
            notify();
        }
    }

    synchronized void display() {
        while (!value) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Hi");
            }
            System.out.println("Name:" + name);
            System.out.println("Grades:" + grade[0] + " " + grade[1]);
            System.out.println("Grade Point:" + val / 2);
            value = false;
            notify();
        }

    }
}

class Thread1 extends Thread {
    Student t;

    Thread1(Student t) {
        this.t = t;
    }

    public void run() {
        t.calculateGrade();
    }
}

class Thread2 implements Runnable {
    Student t;

    Thread2(Student t) {
        this.t = t;
    }

    public void run() {
        t.display();
    }
}

public class StudentMarks {
    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            Student k = new Student("Akbar", 85, 79);
            Thread1 t1 = new Thread1(k);
            Thread t2 = new Thread(new Thread2(k));

            t1.start();
            t2.start();
        }

    }

}