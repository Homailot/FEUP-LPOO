package com.aor.refactoring.example2;

public abstract class Shape {
    protected double x;
    protected double y;

    protected Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Shape createShape(double x, double y, double width, double height) {
        return new Rectangle(x,y,width,height);
    }

    public static Shape createShape(double x, double y, double radius) {
        return new Circle(x,y,radius);
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract void draw(GraphicFramework graphics);
}
