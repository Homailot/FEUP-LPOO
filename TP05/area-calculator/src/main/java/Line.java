public class Line implements BasicShape{
    private double length;

    Line(double length) {
        setLength(length);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
