public class StringInverter implements StringTransformer{
    String original;

    @Override
    public void execute(StringDrink drink) {
        original = drink.getText();
        StringBuilder builder = new StringBuilder();
        String text = drink.getText();
        char[] chars = text.toCharArray();

        for(int i = chars.length-1; i >= 0; i--) {
            builder.append(chars[i]);
        }

        drink.setText(builder.toString());
    }

    @Override
    public void undo(StringDrink drink) {
        if(original != null) {
            drink.setText(original);
        }
    }
}
