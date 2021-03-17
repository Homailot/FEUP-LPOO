public class House implements HasArea{
    private double area;

    House(double area) {
        setArea(area);
    }

    @Override
    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
