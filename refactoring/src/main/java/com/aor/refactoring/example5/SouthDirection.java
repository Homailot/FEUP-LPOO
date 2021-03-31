package com.aor.refactoring.example5;

public class SouthDirection extends Direction{
    @Override
    protected char getDirection() {
        return 'S';
    }

    @Override
    public void moveForward(Turtle turtle) {
        turtle.setRow(turtle.getRow() + 1);
    }

    @Override
    public void rotateRight(Turtle turtle) {
        turtle.setDirection(new WestDirection());
    }

    @Override
    public void rotateLeft(Turtle turtle) {
        turtle.setDirection(new EastDirection());
    }
}
