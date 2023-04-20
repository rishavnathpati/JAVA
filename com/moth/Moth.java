// Develop the class Moth in a package that models a moth flying along a straight line. 
// A moth has a position determined by its coordinates with respect to an origin and the distance from the origin. 
// Provide getter and setter method for position and distance of the moth. Override the toString method of the Object class. 
// When a moth moves toward a point of light, its new position is halfway between its old position and the position of the light source. 
// Supply a constructor to initialize the position of a moth and the methods to move a moth toward light and to retrieve the current position of the moth. 
// Develop the MothTester class in another package containing the main method and it should construct a moth, move it toward a couple of light sources, and check the moth’s position.

// Path: MothTester.java

package com.moth;

public class Moth {
    private double x;
    private double y;
    private double distance;

    public Moth(double x, double y) {
        this.x = x;
        this.y = y;
        this.distance = Math.sqrt(x * x + y * y);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDistance() {
        return distance;
    }

    public void moveToLight(double x, double y) {
        this.x = (this.x + x) / 2;
        this.y = (this.y + y) / 2;
        this.distance = Math.sqrt(this.x * this.x + this.y * this.y);
    }

    @Override
    public String toString() {
        return "The moth is at (" + x + ", " + y + ") and the distance from the origin is " + distance;
    }
}
