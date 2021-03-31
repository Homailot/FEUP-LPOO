public class MargueritaRecipe extends Recipe {
    @Override
    public Pizza makeMediumPizza() {
        Pizza pizza = new MediumPizza();
        pizza.addIngredient(new Ingredient("Tomato"));
        pizza.addIngredient(new Ingredient("Mozzarella"));
        pizza.addIngredient(new Ingredient("Basil"));

        return pizza;
    }
}
