package Generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student [name: " + name + ", age: " + age + ", grade: " + grade + "]";
    }

    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Rishav", 20, 85.5));
        studentList.add(new Student("Ayan",21, 92.0));
        studentList.add(new Student("Ritesh", 22, 78.8));

        System.out.println("\nOriginal list:");
        for (Student student : studentList) {
            System.out.println(student);
        }

        System.out.println("\nSorted list by grade (increasing order):");
        Collections.sort(studentList, Comparator.comparingDouble(Student::getGrade));
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
