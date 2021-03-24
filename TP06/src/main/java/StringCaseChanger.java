public class StringCaseChanger implements StringTransformer{
    String original;

    @Override
    public void execute(StringDrink drink) {
        original = drink.getText();
        StringBuilder builder = new StringBuilder();
        char[] chars = drink.getText().toCharArray();

        for(char ch : chars) {
            if(Character.isLowerCase(ch)) {
              builder.append(Character.toUpperCase(ch));
            } else {
                builder.append(Character.toLowerCase(ch));
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
