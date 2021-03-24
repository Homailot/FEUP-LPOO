import java.util.List;

public class StringTransformerGroup implements StringTransformer{
    String original;
    List<StringTransformer> stringTransformers;

    StringTransformerGroup(List<StringTransformer> stringTransformers) {
        this.stringTransformers = stringTransformers;
    }

    @Override
    public void execute(StringDrink drink) {
        original = drink.getText();

        for(StringTransformer transformer : stringTransformers) {
            transformer.execute(drink);
        }
    }

    @Override
    public void undo(StringDrink drink) {
        if(original != null) {
            drink.setText(original);
        }
    }
}
