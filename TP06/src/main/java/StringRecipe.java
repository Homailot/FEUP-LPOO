import java.util.List;

public class StringRecipe {
    List<StringTransformer> stringTransformers;

    StringRecipe(List<StringTransformer> stringTransformers) {
        this.stringTransformers = stringTransformers;
    }

    public void mix(StringDrink drink) {
        for(StringTransformer transformer : stringTransformers) {
            transformer.execute(drink);
        }
    }
}
