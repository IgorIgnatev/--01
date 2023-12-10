package src.main.java.com.oop.figure;

import java.util.Objects;

public class Line {
    private String name;
    private Point pointA;
    private Point pointB;

    public Line(Point pointA, Point pointB) {
        this(pointA, pointB, "Unknown");
    }

    public Line(Point pointA, Point pointB, String name) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.name = name;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(name, line.name) &&
                Objects.equals(pointA, line.pointA) &&
                Objects.equals(pointB, line.pointB);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, pointA, pointB);
    }

    @Override
    public String toString() {
        return "Line{" +
                "name='" + name + '\'' +
                ", pointA=" + pointA +
                ", pointB=" + pointB +
                '}';
    }
}

