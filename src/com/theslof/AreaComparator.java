package com.theslof;

import java.util.Comparator;

public class AreaComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        if(o1.getArea() > o2.getArea())
            return 1;
        if(o1.getArea() < o2.getArea())
            return -1;
        return 0;
    }
}
