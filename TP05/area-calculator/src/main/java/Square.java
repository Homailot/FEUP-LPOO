public class Square implements AreaShape {
    private double side;

    Square(double side) {
        this.side = side;
    }


    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side*side;
    }

    @Override
    public String draw() {
        return "Square";
    }
}
