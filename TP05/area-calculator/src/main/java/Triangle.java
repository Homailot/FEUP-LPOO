public class Triangle implements Shape{
    private double base, height;

    Triangle(double base,double height) {
        setBase(base);
        setHeight(height);
    }

    @Override
    public double getArea() {
        return base*height/2;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
