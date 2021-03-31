public class MargueritaCertifier extends PizzaCertifier {
    @Override
    public boolean isCertified(Pizza pizza1) {
        return (pizza1.contains(new Ingredient("Tomato")) &&
                pizza1.contains(new Ingredient("Mozzarella")) &&
                pizza1.contains(new Ingredient("Basil")) &&
                pizza1.getIngredientCount() == 3);
    }
}
