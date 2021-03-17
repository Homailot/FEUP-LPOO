import java.awt.geom.Area;
import java.util.List;

public class City implements SumProvider {
    private List<House> houses;

    City(List<House> houses) {
        setHouses(houses);
    }

    public void addHouse(House house) {
        houses.add(house);
    }

    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    public double sum() {
        double sum = 0;
        for(House house : houses) {
            sum += house.getArea();
        }

        return sum;
    }
}
