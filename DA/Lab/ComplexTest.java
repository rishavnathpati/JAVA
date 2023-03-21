// Create  a  class  called  Complex  for  performing  arithmetic  with  complex  numbers.  Complex  numbers
// have the form realPart + imaginaryPart * i; where i is the imaginary unit.  
// Write a program to test your class. Use floating-point variables to represent the private data of the class. 
// Provide a  constructor  that  enables  an  object  of  this  class  to  be  initialized when it’s  declared.  Provide  a 
// no-argument constructor with default values in case no initializers are provided. Provide public methods 
// that perform the following operations: 
// a)  Add  two  Complex  numbers:  The  real  parts  are  added  together  and  the  imaginary  parts  are  added 
// together. 
// b) Subtract two Complex numbers: The real part of the right operand is subtracted from the real part of 
// the  left  operand,  and  the  imaginary  part  of  the  right  operand  is  subtracted  from  the  imaginary  part  of 
// the left operand. 
// c) Print Complex numbers in the form (realPart, imaginaryPart). 

class Complex {
    private double realPart;
    private double imaginaryPart;

    public Complex() {
        this.realPart = 0.0;
        this.imaginaryPart = 0.0;
    }

    public Complex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public Complex add(Complex other) {
        double real = this.realPart + other.realPart;
        double imaginary = this.imaginaryPart + other.imaginaryPart;
        return new Complex(real, imaginary);
    }

    public Complex subtract(Complex other) {
        double real = this.realPart - other.realPart;
        double imaginary = this.imaginaryPart - other.imaginaryPart;
        return new Complex(real, imaginary);
    }

    public void print() {
        System.out.println("(" + this.realPart + ", " + this.imaginaryPart + ")");
    }
}

public class ComplexTest {
    public static void main(String[] args) {
        Complex c1 = new Complex(1.0, 2.0);
        Complex c2 = new Complex(3.0, 4.0);
        Complex c3 = c1.add(c2);
        Complex c4 = c1.subtract(c2);
        System.out.println("Addition of c1 and c2:");
        c3.print();
        System.out.println("Subtraction of c1 and c2:");
        c4.print();
    }
}
