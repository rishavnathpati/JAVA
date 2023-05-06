
import java.util.Scanner;

interface IMathematicalFunction {
    Object add(Object other);

    Object multiply(Object other);
}

class Vector implements IMathematicalFunction {
    double a, b, c;

    Vector(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public Object add(Object other) {
        Vector v = (Vector) other;
        double suma = 0.0;
        double sumb = 0.0;
        double sumc = 0.0;
        suma = this.a + v.a;
        sumb = this.b + v.b;
        sumc = this.c + v.c;
        return new Vector(suma, sumb, sumc);
    }

    @Override
    public Object multiply(Object other) {
        Vector vm = (Vector) other;
        double mula = 0.0;
        double mulb = 0.0;
        double mulc = 0.0;
        mula = this.a * vm.a;
        mulb = this.b * vm.b;
        mulc = this.c * vm.c;
        return new Vector(mula, mulb, mulc);
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ", " + c + ")";
    }
}

class Matrix implements IMathematicalFunction {
    int matrix[][] = new int[2][2];
    Scanner sc = new Scanner(System.in);

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public Object add(Object other) {
        int[][] sum = new int[2][2];
        Matrix m = (Matrix) other;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                sum[i][j] = this.matrix[i][j] + m.matrix[i][j];
            }
        }
        return new Matrix(sum);
    }

    @Override
    public Object multiply(Object other) {
        int[][] mul = new int[2][2];
        Matrix m = (Matrix) other;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                mul[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    mul[i][j] += this.matrix[i][k] * m.matrix[k][j];
                }
            }
        }
        return new Matrix(mul);
    }
}

public class MathematicalFunc {
    public static void main(String[] args) {
        int[][] m1 = { { 1, 2 }, { 3, 4 } };
        int[][] m2 = { { 1, 2 }, { 3, 4 } };
        Matrix m = new Matrix(m1);
        Matrix mm = new Matrix(m2);
        Matrix madd = (Matrix) (m.add(mm));
        Matrix mmul = (Matrix) (m.multiply(mm));
        System.out.println("Original Matrix 1:");
        for (int i = 0; i < 2; i++) {

            for (int j = 0; j < 2; j++) {
                System.out.print(m1[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Original Matrix 2:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(m2[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Result after adding two matrix");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(madd.matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Result after multiplying two matrix");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(mmul.matrix[i][j] + "\t");
            }
            System.out.println();
        }
        Vector vo1 = new Vector(5.3, 6.1, 8.1);

        Vector vo2 = new Vector(2.3, 9.1, 3.6);
        Vector va = (Vector) vo1.add(vo2);
        Vector vm = (Vector) vo1.multiply(vo2);
        System.out.println("Original Vector 1:" + vo1);
        System.out.println("Original Vector 2: " + vo2);
        System.out.println("Result after adding two vectors:" + va);
        System.out.println("Result after multiplying two vectors:" + vm);
    }
}