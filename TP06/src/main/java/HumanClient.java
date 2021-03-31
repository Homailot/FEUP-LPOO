public class HumanClient implements Client{
    private OrderingStrategy strategy;

    HumanClient(OrderingStrategy strategy) {

        this.strategy = strategy;
    }

    @Override
    public void happyHourStarted(Bar bar) {
        strategy.happyHourStarted(bar);
    }

    @Override
    public void happyHourEnded(Bar bar) {
        strategy.happyHourEnded(bar);
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        strategy.wants(drink, recipe, bar);
    }
}
