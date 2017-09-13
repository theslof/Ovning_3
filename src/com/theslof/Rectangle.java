package com.theslof;

public class Rectangle extends Shape implements Comparable{

    public Rectangle() {
        this(0, 0);
    }

    public Rectangle(double l, double w) {
        super(l, w);
    }

    @Override
    public double getArea() {
        return getLength() * getWidth();
    }

    @Override
    public double getPerimiter() {
        return getLength() * 2 + getWidth() * 2;
    }

    @Override
    public int compareTo(Object o) {
        Shape s = (Shape) o;
        if (this.getArea() < s.getArea())
            return -1;
        if (this.getArea() > s.getArea())
            return 1;
        return 0;
    }
}
