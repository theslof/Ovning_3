package com.theslof;

public class ResizeableRectangle extends Rectangle implements IResizable{

    public ResizeableRectangle(double l, double w) {
        super(l, w);
    }

    @Override
    public void resize(int scale) {
        setLength(getLength() * (scale * 0.01));
        setWidth(getWidth() * (scale * 0.01));
    }
}
