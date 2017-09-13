package com.theslof.Comparator;

import com.theslof.Shape;

import java.util.Comparator;

public class PerimiterComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        if(o1.getPerimiter() > o2.getPerimiter())
            return 1;
        if(o1.getPerimiter() < o2.getPerimiter())
            return -1;
        return 0;
    }
}
