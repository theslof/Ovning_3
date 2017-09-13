package com.theslof;

public class Ellipse extends Shape {

    public Ellipse(double l, double w) {
        super(l, w);
    }

    @Override
    public double getArea() {
        return (getLength() * 0.5) * (getWidth() * 0.5) * Math.PI;
    }

    @Override
    public double getPerimiter() {
        double a = getLength() * 0.5;
        double b = getWidth() * 0.5;
        //Ramanujan's approximation, close enough:
        return Math.PI * Math.abs(3 * (a + b) - Math.sqrt((3 * a + b) * (a + 3 * b)));
    }
}
