import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy{
    private List<StringDrinkOrder> orders = new ArrayList<>();

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        if(bar.isHappyHour()) bar.order(drink, recipe);
        else {
            orders.add(new StringDrinkOrder(drink, recipe, bar));
        }
    }

    @Override
    public void happyHourStarted(Bar bar) {
        for(StringDrinkOrder order : orders) {
            if(order.getBar().equals(bar)) {
                ((StringBar) bar).order(order.getDrink(), order.getRecipe());
            }
        }
    }

    @Override
    public void happyHourEnded(Bar bar) {

    }
}
