package com.aor.refactoring.example5;

public class NorthDirection extends Direction{

    @Override
    protected char getDirection() {
        return 'N';
    }

    @Override
    public void moveForward(Turtle turtle) {
        turtle.setRow(turtle.getRow() - 1);
    }

    @Override
    public void rotateRight(Turtle turtle) {
        turtle.setDirection(new EastDirection());
    }

    @Override
    public void rotateLeft(Turtle turtle) {
        turtle.setDirection(new WestDirection());
    }
}
