public class StringDrinkOrder {
    private final StringDrink drink;
    private final StringRecipe recipe;
    private final StringBar bar;

    public StringDrinkOrder(StringDrink drink, StringRecipe recipe, StringBar bar) {
        this.drink = drink;
        this.recipe = recipe;
        this.bar = bar;
    }

    public StringDrink getDrink() {
        return drink;
    }

    public StringRecipe getRecipe() {
        return recipe;
    }

    public StringBar getBar() {
        return bar;
    }
}
