package com.theslof;

import sun.security.provider.SHA;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static ArrayList<Shape> shapes = new ArrayList<>();

    public static void main(String[] args) {
        ShapeType shape; //Skapa en ShapeType-variabel som håller vårt menyval
        do {
            shape = doMenu(); //Visa menyn och spara användarens val

            Shape s; //Skapa en Shape-variabel som håller objektet

            //Kör createShape(shape) och spara Shape i s.
            //Om s är null, dvs. användaren valde ingen ShapeType,
            //så hoppar vi över resten.
            if ((s = createShape(shape)) != null) {
                setDimensions(s); //Läs in längd/bredd och ändra objektets värden
                shapes.add(s);
            }
        } while (shape != null);

        shapes.sort(new AreaComparator());
        for (Shape s:shapes) {
            viewShapeInfo(s);
        }
    }

    private static ShapeType doMenu() {
        System.out.println("(1) Skapa en ellips");
        System.out.println("(2) Skapa en rektangel");
        System.out.println("(3) Skapa en ellips som kan ändra storlek");
        System.out.println("(4) Skapa en rektangel som kan ändra storlek");
        System.out.println("(0) Avsluta");
        System.out.print("Välj ett alternativ: ");

        int choice;

        do {
            choice = (int) inputDouble(); //Läs in en double och gör typecast till int
        } while (choice < 0 || choice > 4); //Loopa om valet är ogiltigt

        if (choice == 1)
            return ShapeType.ELLIPSE; //Användaren valde Ellips
        if (choice == 2)
            return ShapeType.RECTANGLE; //Användaren valde Rektangel
        if (choice == 1)
            return ShapeType.RESELLIPSE; //Användaren valde Ellips
        if (choice == 2)
            return ShapeType.RESRECTANGLE; //Användaren valde Rektangel
        return null; //Användaren valde Avsluta, så vi returnerar null och skapar inget objekt
    }

    private static void setDimensions(Shape shape) {
        System.out.print("Mata in längden: ");
        double length = inputDouble();
        System.out.print("Mata in bredden: ");
        double width = inputDouble();
        shape.setLength(length);
        shape.setWidth(width);
    }

    public static void resizeShape(Shape shape){
        if(!(shape instanceof IResizable))
            return;
        System.out.print("Ändra storlek med antal procent: ");
        double scale = inputDouble();
        ((IResizable)shape).resize((int)scale);
    }

    public static Shape createShape(ShapeType shape) {
        if (shape == ShapeType.ELLIPSE)
            return new Ellipse(0,0);
        if (shape == ShapeType.RECTANGLE)
            return new Rectangle(0,0);
        if (shape == ShapeType.RESELLIPSE)
            return new ResizeableEllipse(0,0);
        if (shape == ShapeType.RESRECTANGLE)
            return new ResizeableRectangle(0,0);
        return null;
    }

    public static void viewShapeInfo(Shape shape) {
        System.out.println(shape);
    }

    private static double inputDouble() {
        //Skapa en ny Scanner
        Scanner input = new Scanner(System.in);

        double i = 0;
        //waiting håler reda på om vi väntar eller har en double redo
        boolean waiting = true;

        do {
            //Try/catch för att undvika krasch
            try {
                //Om Try lyckas så har vi en double, waiting sätts till false;
                i = input.nextDouble();
                waiting = false;
            } catch (InputMismatchException e) {
                //Vi lyckades inte läsa en double, hoppa till nästa ord i input
                input.next();
            }
        } while (waiting);

        return i;
    }
}
