import java.util.List;

public class GenericRecipe extends Recipe {
    List<Ingredient> ingredients;

    public GenericRecipe(List<Ingredient> ingredients) {
        super();
        this.ingredients = ingredients;
    }

    @Override
    public Pizza makeMediumPizza() {
        Pizza pizza = new MediumPizza();

        for(Ingredient ingredient : ingredients) {
            pizza.addIngredient(ingredient);
        }

        return pizza;
    }
}
