public class StringReplacer implements StringTransformer{
    private final char replace_from;
    private final char replace_to;
    String original;

    StringReplacer(char replace_from, char replace_to) {
        this.replace_from = replace_from;
        this.replace_to = replace_to;
    }

    @Override
    public void execute(StringDrink drink) {
        original = drink.getText();
        StringBuilder builder = new StringBuilder();

        for(char ch : drink.getText().toCharArray()) {
            if(ch == replace_from) {
                builder.append(replace_to);
            } else {
                builder.append(ch);
            }
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
