package com.theslof;

public class Ellipse extends Shape implements Comparable {

    public Ellipse() {
        this(0, 0);
    }

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

    @Override
    public int compareTo(Object o) {
        Shape s = (Shape) o;
        if(this.getArea() < s.getArea())
            return -1;
        if(this.getArea() > s.getArea())
            return 1;
        return 0;
    }
}
