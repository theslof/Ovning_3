package com.theslof;

public class ResizeableEllipse extends Ellipse implements IResizable{
    public ResizeableEllipse(double l, double w) {
        super(l, w);
    }

    @Override
    public void resize(int scale) {
        setLength(getLength() * (scale * 0.01));
        setWidth(getWidth() * (scale * 0.01));
    }
}
