public class SlicedPizza implements Pizza {
    private final Pizza pizza;
    private final int slices;

    public SlicedPizza(Pizza pizza, int slices) {
        this.pizza = pizza;
        this.slices = slices;
    }

    @Override
    public boolean addIngredient(Ingredient ingredient) {
        return pizza.addIngredient(ingredient);
    }

    @Override
    public int getIngredientCount() {
        return pizza.getIngredientCount();
    }

    @Override
    public boolean contains(Ingredient ingredient) {
        return pizza.contains(ingredient);
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 2;
    }

    @Override
    public void setPrice(double v) {
        this.pizza.setPrice(v);
    }

    public int getSlices() {
        return slices;
    }
}
