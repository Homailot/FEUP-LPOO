public class Line implements Shape{
    private double length;

    Line(double length) {
        setLength(length);
    }

    @Override
    public double getArea() {
        throw new NoAreaException();
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
