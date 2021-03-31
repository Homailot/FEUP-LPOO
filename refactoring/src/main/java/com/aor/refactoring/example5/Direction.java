package com.aor.refactoring.example5;

public abstract class Direction {
    public static Direction createDirection(char direction) {
        switch (direction) {
            case 'E':
                return new EastDirection();
            case 'W':
                return new WestDirection();
            case 'S':
                return new SouthDirection();
            case 'N':
            default:
                return new NorthDirection();
        }
    }

    protected abstract char getDirection();

    public abstract void moveForward(Turtle turtle);

    public abstract void rotateRight(Turtle turtle);

    public abstract void rotateLeft(Turtle turtle);
}
