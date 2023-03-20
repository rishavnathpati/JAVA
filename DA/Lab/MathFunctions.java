package Lab;

import java.util.Arrays;
// Develop an interface with two methods namely, add and multiply for addition and multiplication of mathematical objects 
// such as vectors and matrices. Develop a class Vector that implements the interface with necessary data members. 
// Develop another class Matrix that implements the interface with necessary data members. 
// Develop a class containing the main method and show the computation of the sum of two vectors and 
// their scalar product and the sum of two matrices and the product of the matrices.

/**
 * This is an interface that provides methods to add and multiply mathematical
 * objects
 */
interface IMathematicalObject<T> {
    T add(T other);

    T multiply(T other);
}

class Vector implements IMathematicalObject<Vector> {
    private double[] vector;

    public double[] getVector() {
        return vector;
    }

    public Vector(double... values) {
        this.vector = values;
    }

    public Vector add(Vector other) {
        if (this.vector.length != other.vector.length) {
            throw new IllegalArgumentException("Vectors must be of equal length");
        }

        double[] result = new double[this.vector.length];
        for (int i = 0; i < this.vector.length; i++) {
            result[i] = this.vector[i] + other.vector[i];
        }

        return new Vector(result);
    }

    public Vector multiply(Vector other) {
        if (this.vector.length != other.vector.length) {
            throw new IllegalArgumentException("Vectors must be of equal length");
        }

        double[] result = new double[this.vector.length];
        for (int i = 0; i < this.vector.length; i++) {
            result[i] = this.vector[i] * other.vector[i];
        }

        return new Vector(result);
    }
}

class Matrix implements IMathematicalObject<Matrix> {
    private double[][] matrix;

    public double[][] getMatrix() {
        return matrix;
    }

    public Matrix(double[][] values) {
        this.matrix = values;
    }

    public Matrix add(Matrix other) {
        if (this.matrix.length != other.matrix.length || this.matrix[0].length != other.matrix[0].length) {
            throw new IllegalArgumentException("Matrices must be of equal size");
        }

        double[][] result = new double[this.matrix.length][this.matrix[0].length];
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                result[i][j] = this.matrix[i][j] + other.matrix[i][j];
            }
        }

        return new Matrix(result);
    }

    public Matrix multiply(Matrix other) {
        if (this.matrix[0].length != other.matrix.length) {
            throw new IllegalArgumentException(
                    "Number of columns in first matrix must be equal to number of rows in second matrix");
        }

        double[][] result = new double[this.matrix.length][other.matrix[0].length];
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < other.matrix[0].length; j++) {
                double sum = 0.0;
                for (int k = 0; k < this.matrix[0].length; k++) {
                    sum += this.matrix[i][k] * other.matrix[k][j];
                }
                result[i][j] = sum;
            }
        }

        return new Matrix(result);
    }
}

public class MathFunctions {
    public static void main(String[] args) {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(4, 5, 6);

        Vector v3 = v1.add(v2);
        System.out.println("\nv1 + v2 = " + Arrays.toString(v3.getVector()));

        Vector v4 = v1.multiply(v2);

        System.out.println("\nv1 * v2 = " + Arrays.toString(v4.getVector()));

        Matrix m1 = new Matrix(new double[][] { { 1, 2 }, { 3, 4 } });
        Matrix m2 = new Matrix(new double[][] { { 5, 6 }, { 7, 8 } });

        Matrix m3 = m1.add(m2);
        System.out.println("\n\nm1 + m2 = ");
        var matrix3 = m3.getMatrix();
        for (int i = 0; i < matrix3.length; i++) {
            System.out.println(Arrays.toString(matrix3[i]));
        }

        Matrix m4 = m1.multiply(m2);
        System.out.println("\nm1 * m2 = ");
        var matrix4 = m4.getMatrix();
        for (int i = 0; i < matrix4.length; i++) {
            System.out.println(Arrays.toString(matrix4[i]));
        }
    }
}