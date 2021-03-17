import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        AreaAggregator aggregator = new AreaAggregator();

        aggregator.addHasArea(new Circle(1));
        aggregator.addHasArea(new Square(2));
        aggregator.addHasArea(new Circle(2));
        aggregator.addHasArea(new Square(10));
        aggregator.addHasArea(new Ellipse(1,1));
        aggregator.addHasArea(new Triangle(2,2));
        aggregator.addHasArea(new House(20));

        AreaStringOutputter stringOutputter = new AreaStringOutputter(aggregator);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(aggregator);

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());

        List<House> houses = new ArrayList<>();
        houses.add(new House(50));
        houses.add(new House(150));

        City city = new City(houses);

        AreaStringOutputter cityStringOutputter = new AreaStringOutputter(city);
    }
}
