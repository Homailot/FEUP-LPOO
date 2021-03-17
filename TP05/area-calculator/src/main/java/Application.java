public class Application {
    public static void main(String[] args) {
        AreaAggregator aggregator = new AreaAggregator();

        aggregator.addShape(new Circle(1));
        aggregator.addShape(new Square(2));
        aggregator.addShape(new Circle(2));
        aggregator.addShape(new Square(10));
        aggregator.addShape(new Ellipse(1,1));

        System.out.println(aggregator.output());
    }
}
