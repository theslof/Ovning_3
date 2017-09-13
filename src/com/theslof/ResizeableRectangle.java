package com.theslof;

public class ResizeableRectangle extends Rectangle implements IResizable, Comparable {

    public ResizeableRectangle() {
        this(1, 1);
    }

    public ResizeableRectangle(double l, double w) {
        super(l, w);
    }

    @Override
    public void resize(int scale) {
        setLength(getLength() * (scale * 0.01));
        setWidth(getWidth() * (scale * 0.01));
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
