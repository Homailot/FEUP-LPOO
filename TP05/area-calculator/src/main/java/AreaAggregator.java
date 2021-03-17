import java.util.ArrayList;
import java.util.List;

public class AreaAggregator implements SumProvider{
    private final List<HasArea> hasAreas = new ArrayList<>();

    public void addHasArea(HasArea hasArea) {
        hasAreas.add(hasArea);
    }

    public double sum() {
        double sum = 0;
        for (HasArea hasArea : hasAreas) {
            sum += hasArea.getArea();
        }
        return sum;
    }
}
