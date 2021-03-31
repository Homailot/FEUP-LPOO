package com.aor.refactoring.example5;

public class Turtle {
    private int row;
    private int column;
    private Direction direction;

    public Turtle(int row, int column, char direction) {
        this.row = row;
        this.column = column;

        this.direction = Direction.createDirection(direction);
    }

    public void execute(char command) {
        if (command == 'L') direction.rotateLeft(this);
        else if (command == 'R') direction.rotateRight(this);
        else if (command == 'F') direction.moveForward(this);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public char getDirection() {
        return direction.getDirection();
    }
}
