package com.theslof;

public class Rectangle extends Shape{

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
}
