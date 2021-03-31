package com.aor.refactoring.example5;

public class EastDirection extends Direction{

    @Override
    protected char getDirection() {
        return 'E';
    }

    @Override
    public void moveForward(Turtle turtle) {
        turtle.setColumn(turtle.getColumn() + 1);
    }

    @Override
    public void rotateRight(Turtle turtle) {
       turtle.setDirection(new SouthDirection());
    }

    @Override
    public void rotateLeft(Turtle turtle) {
        turtle.setDirection(new NorthDirection());
    }
}
