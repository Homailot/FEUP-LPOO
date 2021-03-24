import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringTransformerTest {
    @Test
    public void transformUndo() {
        StringDrink drink = new StringDrink("AbCd-aBcD");

        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();
        StringReplacer sr = new StringReplacer('A', 'X');

        si.execute(drink);
        assertEquals("DcBa-dCbA", drink.getText());
        cc.execute(drink);
        assertEquals("dCbA-DcBa", drink.getText());
        sr.execute(drink);
        assertEquals("dCbX-DcBa", drink.getText());

        sr.undo(drink);
        assertEquals("dCbA-DcBa", drink.getText());
        cc.undo(drink);
        assertEquals("DcBa-dCbA", drink.getText());
        si.undo(drink);
        assertEquals("AbCd-aBcD", drink.getText());



    }
}