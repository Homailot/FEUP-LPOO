public abstract class AlienClient implements Client {
    private OrderingStrategy strategy;

    public AlienClient() {
        this.strategy = createOrderingStrategy();
    }

    @Override
    public void happyHourEnded(Bar bar) {
        strategy.happyHourEnded(bar);
    }

    @Override
    public void happyHourStarted(Bar bar) {
        strategy.happyHourStarted(bar);
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        strategy.wants(drink, recipe, bar);
    }

    protected abstract OrderingStrategy createOrderingStrategy();
}
