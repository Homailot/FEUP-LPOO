public class Application {
    public static void main(String[] args) {
        AreaAggregator aggregator = new AreaAggregator();

        aggregator.addShape(new Circle(1));
        aggregator.addShape(new Square(2));
        aggregator.addShape(new Circle(2));
        aggregator.addShape(new Square(10));
        aggregator.addShape(new Ellipse(1,1));

        AreaStringOutputter stringOutputter = new AreaStringOutputter(aggregator);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(aggregator);

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());
    }
}