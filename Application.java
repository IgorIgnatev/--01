package com.oop;
import src.main.java.com.oop.figure.Line;
import src.main.java.com.oop.figure.Point;
import src.main.java.com.oop.figure.Square;

public class Application {
    public static void main(String[] args) {
        Point pointX1 = new Point(1, 2);
        Point pointX2 = new Point(3, 4);
        Point pointX3 = new Point(5, 6);
        Point pointX4 = new Point(7, 8);
        Line lineAB = new Line(pointX1, pointX2);
        Line lineBC = new Line(pointX2, pointX3);
        Line lineCD = new Line(pointX3, pointX4);
        Line lineDA = new Line(pointX4, pointX1);

        Square square = new Square.SquareBuilder(lineAB, lineBC, lineCD, lineDA)
                .color("Black").name("Test").build();
        System.out.println(square);
    }
}

