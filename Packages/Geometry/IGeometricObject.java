// Design a class named Triangle that implements an interface called GeometricObject. The
// GeometrocObject interface should be in one package and the Triangle class should be in some other
// package. The interface GeometricObject has the abstract methods getArea() that computes and returns
// the area of a geometric object and getPerimeter() that computes and returns the perimeter of a
// geometric object. The Triangle class should have private double data fields named side1, side2, and
// side3 denoting the length of the three sides of a triangle, a constructor that creates a triangle with the
// specified value for side1, side2 and side3, the getter and setter methods for all three data fields and an
// implementation of the getArea() and getPerimeter() method. Design a class containing the main method
// in a third package to show the invocation of the getArea() and getPerimeter() method on a Triangle
// object.

// Path: Geometry/IGeometricObject.java
package Packages.Geometry;

public interface IGeometricObject {
    public double getArea();

    public double getPerimeter();

}