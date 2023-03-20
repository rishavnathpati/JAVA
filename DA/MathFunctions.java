import java.util.Arrays;
// Develop an interface with two methods namely, add and multiply for addition and multiplication of mathematical objects 
// such as vectors and matrices. Develop a class Vector that implements the interface with necessary data members. 
// Develop another class Matrix that implements the interface with necessary data members. 
// Develop a class containing the main method and show the computation of the sum of two vectors and 
// their scalar product and the sum of two matrices and the product of the matrices.

/**
 * This is an interface that provides methods to add and multiply mathematical objects
 */
interface IMathematicalObject<T> {
    T add(T other);
    T multiply(T other);
}


// This is a class that implements a vector of numbers. The vector is represented as an array of doubles
// The class implements an interface IMathematicalObject that provides methods to add and multiply vectors
class Vector implements IMathematicalObject<Vector> {
    double[] values;

    public Vector(double... values) {
        this.values = values;
    }

    public Vector add(Vector other) {
        if (this.values.length != other.values.length) {
            throw new IllegalArgumentException("Vectors must be of equal length");
        }

        double[] result = new double[this.values.length];
        for (int i = 0; i < this.values.length; i++) {
            result[i] = this.values[i] + other.values[i];
        }

        return new Vector(result);
    }

    public Vector multiply(Vector other) {
        if (this.values.length != other.values.length) {
            throw new IllegalArgumentException("Vectors must be of equal length");
        }

        double[] result = new double[this.values.length];
        for (int i = 0; i < this.values.length; i++) {
            result[i] = this.values[i] * other.values[i];
        }

        return new Vector(result);
    }
}

class Matrix implements IMathematicalObject<Matrix> {
    double[][] values;

    public Matrix(double[][] values) {
        this.values = values;
    }

    public Matrix add(Matrix other) {
        if (this.values.length != other.values.length || this.values[0].length != other.values[0].length) {
            throw new IllegalArgumentException("Matrices must be of equal size");
        }

        double[][] result = new double[this.values.length][this.values[0].length];
        for (int i = 0; i < this.values.length; i++) {
            for (int j = 0; j < this.values[0].length; j++) {
                result[i][j] = this.values[i][j] + other.values[i][j];
            }
        }

        return new Matrix(result);
    }

    public Matrix multiply(Matrix other) {
        if (this.values[0].length != other.values.length) {
            throw new IllegalArgumentException(
                    "Number of columns in first matrix must be equal to number of rows in second matrix");
        }

        double[][] result = new double[this.values.length][other.values[0].length];
        for (int i = 0; i < this.values.length; i++) {
            for (int j = 0; j < other.values[0].length; j++) {
                double sum = 0.0;
                for (int k = 0; k < this.values[0].length; k++) {
                    sum += this.values[i][k] * other.values[k][j];
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
        System.out.println("v1 + v2 = " + Arrays.toString(v3.values));

        Vector v4 = v1.multiply(v2);

        System.out.println("v1 * v2 = " + Arrays.toString(v4.values));

        Matrix m1 = new Matrix(new double[][] { { 1, 2 }, { 3, 4 } });
        Matrix m2 = new Matrix(new double[][] { { 5, 6 }, { 7, 8 } });

        Matrix m3 = m1.add(m2);
        System.out.println("m1 + m2 = " + Arrays.deepToString(m3.values));

        Matrix m4 = m1.multiply(m2);
        System.out.println("m1 * m2 = " + Arrays.deepToString(m4.values));
    }
}