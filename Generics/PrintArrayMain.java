package Generics;

// Develop and test a generic method printArray that takes three parameters namely, a generic array type and two integer arguments, lowSubscript and highSubscript. 
// A call to this method prints only the designated portion of the array. Validate lowSubscript and highSubscript. 
// If either is out of range, the printArray method should throw an InvalidSubscriptException; otherwise, printArray should return the number of elements printed. 
// Write a main to the printArray method on arrays of Integer type, Double type and Character type.

import java.util.Scanner;

class InvalidSubscriptException extends Exception {
    InvalidSubscriptException(String s) {
        super(s);
    }
}

class PrintArray {
    public <T> int printArray(T[] arr, int lowSubscript, int highSubscript) throws InvalidSubscriptException {
        if (lowSubscript < 0 || highSubscript >= arr.length)
            throw new InvalidSubscriptException("Invalid Subscript");
        else {
            for (int i = lowSubscript; i <= highSubscript; i++)
                System.out.print(arr[i] + " ");
            return highSubscript - lowSubscript + 1;
        }
    }
}

public class PrintArrayMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        Integer[] arr1 = new Integer[n];
        System.out.println("Enter the elements of the Integer array: ");
        for (int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();

        PrintArray p1 = new PrintArray();
        try {
            System.out.println("The number of elements printed are: " + p1.printArray(arr1, 0, n - 1));
        } catch (InvalidSubscriptException e) {
            System.out.println(e.getMessage());
        }

        Double[] arr2 = new Double[n];
        System.out.println("Enter the elements of the Double array: ");
        for (int i = 0; i < n; i++)
            arr2[i] = sc.nextDouble();

        PrintArray p2 = new PrintArray();
        try {
            System.out.println("The number of elements printed are: " + p2.printArray(arr2, 0, n - 1));
        } catch (InvalidSubscriptException e) {
            System.out.println(e.getMessage());
        }

        Character[] arr3 = new Character[n];
        System.out.println("Enter the elements of the Character array: ");
        for (int i = 0; i < n; i++)
            arr3[i] = sc.next().charAt(0);

        PrintArray p3 = new PrintArray();
        try {
            System.out.println("The number of elements printed are: " + p3.printArray(arr3, 0, n - 1));
        } catch (InvalidSubscriptException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
