package com.theslof;

public abstract class Shape {
    private double _length;
    private double _width;

    public Shape(double l, double w) {
        _length = l;
        _width = w;
    }

    public abstract double getArea();

    public abstract double getPerimiter();

    public double getLength() {
        return _length;
    }

    public void setLength(double length) {
        //If new _length is negative, ignore new _length
        if(length < 0)
            return;
        this._length = length;
    }

    public double getWidth() {
        return _width;
    }

    public void setWidth(double width) {
        //If new _width is negative, ignore new _width
        if(width < 0)
            return;
        this._width = width;
    }

    @Override
    public String toString() {
        return String.format(
                "Längd  : %.2f\n" +
                "Bredd  : %.2f\n" +
                "Omkrets: %.2f\n" +
                "Area   : %.2f\n",
                getLength(), getWidth(), getPerimiter(), getArea());
    }
}
