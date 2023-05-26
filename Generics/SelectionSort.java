package Generics;

// Write and test a generic Sort program based on selection sort or any sorting of your choice.
// Write a test program that inputs, sorts and outputs an Integer array and a Float array. 
// [Hint: Use <T extends Comparable<T>> in the type-parameter section for method the sorting program, 
// so that you can use method compareTo to compare the objects of the type that T represents.]

import java.util.Scanner;

class Sort<T extends Comparable<T>> {
    public void selectionSort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            T temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}

public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        Integer[] arr1 = new Integer[n];
        System.out.println("Enter the elements of the Integer array: ");
        for (int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();

        Sort<Integer> s1 = new Sort<Integer>();
        s1.selectionSort(arr1);

        System.out.println("The sorted Integer array is: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr1[i] + " ");



        Float[] arr2 = new Float[n];
        System.out.println("Enter the elements of the Float array: ");
        for (int i = 0; i < n; i++)
            arr2[i] = sc.nextFloat();

        Sort<Float> s2 = new Sort<Float>();
        s2.selectionSort(arr2);

        System.out.println("\nThe sorted Float array is: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr2[i] + " ");

        sc.close();
    }
}