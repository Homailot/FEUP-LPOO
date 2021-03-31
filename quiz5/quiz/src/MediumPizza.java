import java.util.ArrayList;
import java.util.List;

public class MediumPizza implements Pizza {
    private final List<Ingredient> ingredients;
    private double price;

    MediumPizza() {
        super();
        this.ingredients = new ArrayList<>();
        this.price = 0;
    }

    @Override
    public boolean addIngredient(Ingredient ingredient) {
        if(ingredients.contains(ingredient)) return false;
        else return ingredients.add(ingredient);
    }

    @Override
    public int getIngredientCount() {
        return ingredients.size();
    }

    @Override
    public boolean contains(Ingredient ingredient) {
        return ingredients.contains(ingredient);
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double v) {
        this.price = v;
    }

}
