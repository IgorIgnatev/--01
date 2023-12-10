package src.main.java.com.oop.figure;

import java.util.Objects;

public class Square {
    private String name;
    private String color;
    private Line lineAB;
    private Line lineBC;
    private Line lineCD;
    private Line lineDA;

    public Square(Line lineAB, Line lineBC, Line lineCD, Line lineDA) {
        this.lineAB = lineAB;
        this.lineBC = lineBC;
        this.lineCD = lineCD;
        this.lineDA = lineDA;
    }

    public static class SquareBuilder {
        private String name;
        private String color;
        private Line lineAB;
        private Line lineBC;
        private Line lineCD;
        private Line lineDA;

        public SquareBuilder(Line lineAB, Line lineBC, Line lineCD, Line lineDA) {
            this.lineAB = lineAB;
            this.lineBC = lineBC;
            this.lineCD = lineCD;
            this.lineDA = lineDA;
        }

        public SquareBuilder color(String color) {
            this.color = color;
            return this;
        }

        public SquareBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Square build() {
            return new Square(this);
        }
    }

    private Square(SquareBuilder squareBuilder) {
        name = squareBuilder.name;
        color = squareBuilder.color;
        lineAB = squareBuilder.lineAB;
        lineBC = squareBuilder.lineBC;
        lineCD = squareBuilder.lineCD;
        lineDA = squareBuilder.lineDA;
    }

    public void changeLines(Line lineAB, Line lineBC, Line lineCD, Line lineDA) {
        this.lineAB = lineAB;
        this.lineBC = lineBC;
        this.lineCD = lineCD;
        this.lineDA = lineDA;
    }

    public void increaseSquere(double percent) {
        if (lineAB != null && percent != 0) {
            lineAB.getPointA().setX(lineAB.getPointA().getX() * percent);
            lineAB.getPointA().setY(lineAB.getPointA().getY() * percent);
            //the same for each side
        }
    }

    public void compressSquere(double percent) {
        if (lineAB != null && percent != 0) {
            lineAB.getPointA().setX(lineAB.getPointA().getX() / percent);
            lineAB.getPointA().setY(lineAB.getPointA().getY() / percent);
            //the same for each side
        }
    }

    public void turnSquere(double percent) {
        if (lineAB != null && percent != 0) {
            lineAB.getPointA().setX(lineAB.getPointA().getX() + percent);
            lineAB.getPointA().setY(lineAB.getPointA().getY() - percent);
            //the same for each side
        }
    }

    public void changeColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Line getLineAB() {
        return lineAB;
    }

    public void setLineAB(Line lineAB) {
        this.lineAB = lineAB;
    }

    public Line getLineBC() {
        return lineBC;
    }

    public void setLineBC(Line lineBC) {
        this.lineBC = lineBC;
    }

    public Line getLineCD() {
        return lineCD;
    }

    public void setLineCD(Line lineCD) {
        this.lineCD = lineCD;
    }

    public Line getLineDA() {
        return lineDA;
    }

    public void setLineDA(Line lineDA) {
        this.lineDA = lineDA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;
        Square square = (Square) o;
        return Objects.equals(name, square.name) &&
                Objects.equals(color, square.color);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, color);
    }

    @Override
    public String toString() {
        return "Square{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", lineAB=" + lineAB +
                ", lineBC=" + lineBC +
                ", lineCD=" + lineCD +
                ", lineDA=" + lineDA +
                '}';
    }
}

