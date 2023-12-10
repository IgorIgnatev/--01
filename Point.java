package src.main.java.com.oop.figure;

import java.util.Objects;

public class Point {
    private String name;
    private double x;
    private double y;

    public Point(double x, double y) {
        this(x, y, "Unknown");
    }

    public Point(double x, double y, String name) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setX(double x) {
        this.x = x;
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0 &&
                Objects.equals(name, point.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}

