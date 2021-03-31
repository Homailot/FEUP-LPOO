package com.aor.refactoring.example5;

public class WestDirection extends Direction{
    @Override
    protected char getDirection() {
        return 'W';
    }

    @Override
    public void moveForward(Turtle turtle) {
        turtle.setColumn(turtle.getColumn() - 1);
    }

    @Override
    public void rotateRight(Turtle turtle) {
        turtle.setDirection(new NorthDirection());
    }

    @Override
    public void rotateLeft(Turtle turtle) {
        turtle.setDirection(new SouthDirection());
    }
}
