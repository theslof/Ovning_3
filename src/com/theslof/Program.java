package com.theslof;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public enum ShapeType {Ellipse, Rectangle};

    public static void main(String[] args) {
        ShapeType shape;
        do {
            shape = doMenu();

            Shape s;
            if((s = createShape(shape)) != null) {
                setDimensions(s);
                viewShapeInfo(s);
            }
        } while (shape != null);
    }

    private static ShapeType doMenu() {
        System.out.println("(1) Skapa en ellips");
        System.out.println("(2) Skapa en rektangel");
        System.out.println("(0) Avsluta");
        System.out.print("Välj ett alternativ: ");

        int choice = -1;

        do{
            choice = (int) inputDouble();
        } while (choice < 0 || choice > 2);

        if(choice == 1)
            return ShapeType.Ellipse;
        if(choice == 2)
            return ShapeType.Rectangle;
        return null;
    }

    private static void setDimensions(Shape shape) {
        System.out.print("Mata in längden: ");
        double length = inputDouble();
        System.out.print("Mata in bredden: ");
        double width = inputDouble();
        shape.setLength(length);
        shape.setWidth(width);
    }

    public static Shape createShape(ShapeType shape){
        if(shape == ShapeType.Ellipse)
            return new Ellipse();
        if(shape == ShapeType.Rectangle)
            return new Rectangle();
        return null;
    }

    public static void viewShapeInfo(Shape shape){
        System.out.println(shape);
    }

    private static double inputDouble() {
        //Skapa en ny Scanner
        Scanner input = new Scanner(System.in);

        double i = 0;
        //waiting håler reda på om vi väntar eller har en int redo
        boolean waiting = true;

        do {
            //Try/catch för att undvika krasch
            try {
                //Om Try lyckas så har vi en int, waiting sätts till false;
                i = input.nextDouble();
                waiting = false;
            } catch (InputMismatchException e) {
                //Vi lyckades inte läsa en int, hoppa till nästa ord i input
                input.next();
            }
        } while (waiting);

        return i;
    }
}
